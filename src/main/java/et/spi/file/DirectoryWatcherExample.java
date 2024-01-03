package et.spi.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class DirectoryWatcherExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("d:\\test");

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while (true) {
            key = watchService.poll(100, TimeUnit.MICROSECONDS);
            if (key != null) {


                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(
                            "Event kind:" + event.kind()
                                    + ". File affected: " + event.context() + ".");
                }
                key.reset();
                Thread.sleep(1000);
            }
        }
    }
}