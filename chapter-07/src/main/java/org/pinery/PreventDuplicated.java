package org.pinery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author gensci
 * @DateTime 2024/7/20 8:45
 * @Description
 **/
public class PreventDuplicated {
    private final static String LOCK_PATH = "D:\\IT\\Java\\high-concurrency-multi-thread\\multi-thread";
    private final static String LOCK_FILE = ".lock";
    private final static String PERMISSIONS = "rw-------";

    public static void main(String[] args) throws IOException {
        //2.检查是否存在 .lock文件
        checkRunning();
        //1.注入 Hook线程,在程序退出时删除lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The program received kill SIGNAL.");
            getLockFile().toFile().delete();
        }));
        //3.简单模仿当前程序正常运行
        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("program is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists()) {
            throw new RuntimeException("The program already running");
        }
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
        //Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
        boolean isOk = new File(path.toFile().getPath()).createNewFile();

    }

    private static Path getLockFile() {
        Path path = Paths.get(LOCK_PATH, LOCK_FILE);
        System.out.println(path.getFileName());
        return path;
    }



}
