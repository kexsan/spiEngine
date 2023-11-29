package et.spi.file;

import java.nio.file.*;

public class FileWatcher {

    public static void main(String[] args) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path directory = Paths.get("d:\\test\\");
            directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Watching for changes in: " + directory);

            while (true) {
                WatchKey key = watchService.take(); // Blocking call

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        System.out.println("Event overflow occurred.");
                        continue;
                    }

                    Path changedPath = (Path) event.context();
                    System.out.println("Event kind: " + kind + ", File affected: " + changedPath);
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