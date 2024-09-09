package org.pinery;

/**
 *
 **/
public class Reference {
    //左多19位, 0010左移19位,10后面+19个0= 2^20次方=1048576
    private final byte[] data = new byte[2 << 19];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("the reference will be GC");
    }
}
