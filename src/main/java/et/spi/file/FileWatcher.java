package et.spi.file;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.file.*;
import java.util.List;
@Service
public class FileWatcher {


    @EventListener(ApplicationReadyEvent.class)
    @Async
    public   void extracted() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path directory = Paths.get("d:\\test\\");
            directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Watching for changes in: " + directory);


            WatchKey key;
            while ((key = watchService.take()) != null) {

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        System.out.println("Event overflow occurred.");
                        continue;
                    }

                    System.out.println(event.context() + ", count: " +
                            event.count() + ", event: " + event.kind());

                    Path changedPath = (Path) event.context();
                    System.out.println("Event kind: " + kind + ", File affected: " + changedPath+ " _ "+System.currentTimeMillis());

                }
                boolean reset = key.reset();
                if (!reset) {
                    System.out.println("Watch key is no longer valid. Exiting watch loop.");
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}