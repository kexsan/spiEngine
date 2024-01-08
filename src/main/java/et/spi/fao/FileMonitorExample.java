package et.spi.fao;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.comparator.LastModifiedFileComparator;

import java.io.File;

public class FileMonitorExample {

    public static void main(String[] args) {
        // Specify the directory to be monitored
        File directory = new File("d:\\tempf");

        // Создаем объект File, представляющий отслеживаемую директорию
        //File directory = new File(directoryToWatch);

        // Создаем экземпляр FileAlterationObserver для отслеживания изменений в директории
        FileAlterationObserver observer = new FileAlterationObserver(directory);

        // Создаем объект FileAlterationListener, который будет реагировать на изменения
        FileAlterationListener listener = new YourFileListener();

        // Регистрируем слушателя с наблюдателем
        observer.addListener(listener);

        // Создаем экземпляр FileAlterationMonitor с интервалом мониторинга 1000 миллисекунд (1 секунда)
        FileAlterationMonitor monitor = new FileAlterationMonitor(1000);

        // Регистрируем наблюдателя с монитором
        monitor.addObserver(observer);

        // Запускаем монитор
        try {
            monitor.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}


