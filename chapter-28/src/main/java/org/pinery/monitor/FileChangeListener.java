package org.pinery.monitor;

import org.pinery.Subscribe;

/**
 *
 **/
public class FileChangeListener {
    @Subscribe
    public void onChange(FileChangeEvent event) {
        System.out.printf("%s-%s\n",event.getPath(),event.getKind());
    }
}
