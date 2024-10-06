package org.pinery.monitor;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @Author gensci
 * @DateTime 2024/9/21 11:43
 * @Description
 **/
public class FileChangeEvent {

    //文件路径
    private final Path path;
    //事件类型,用于识别
    private final WatchEvent.Kind<?> kind;

    public FileChangeEvent(Path path, WatchEvent.Kind<?> kind) {
        this.path = path;
        this.kind = kind;
    }

    public Path getPath() {
        return path;
    }

    public WatchEvent.Kind<?> getKind() {
        return kind;
    }
}
