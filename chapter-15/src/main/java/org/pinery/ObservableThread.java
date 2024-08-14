package org.pinery;

/**
 * 任务监控的关键
 **/
public class ObservableThread<T> extends Thread implements Observable {

    //负责不同阶段触发事件的
    private final TaskLifeCycle<T> lifeCycle;
    //业务逻辑
    private final Task<T> task;
    private Cycle cycle;

    public ObservableThread(Task<T> task) {
        this(new TaskLifeCycle.EmptyLifecycle<>(), task);
    }

    public ObservableThread(TaskLifeCycle<T> lifeCycle, Task<T> task) {
        super();
        if (task == null) {
            throw new IllegalArgumentException("The task is required");
        }
        this.lifeCycle = lifeCycle;
        this.task = task;
    }



    @Override
    public final void run() {
        //执行线程逻辑单元的过程,分别触发相应的事件
        this.update(Cycle.STARTED, null, null);
        try{
            this.update(Cycle.RUNNING, null, null);
            //执行业务逻辑
            T result = this.task.call();
            this.update(Cycle.DONE, result, null);
        }catch (Exception ex){
            this.update(Cycle.DONE, null, ex);
        }
    }

    private void update(Cycle cycle, T result, Exception e) {
        this.cycle = cycle;
        if (lifeCycle == null) {
            return;
        }
        try {
            switch (cycle) {
                case STARTED:
                    this.lifeCycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifeCycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifeCycle.onFinish(currentThread(),result);
                    break;
                case ERROR:
                    this.lifeCycle.onError(currentThread(), e);
                    break;
            }
        } catch (Exception ex) {
            if (cycle == Cycle.ERROR) {
                throw ex;
            }
        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
