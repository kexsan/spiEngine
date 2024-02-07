package et.spi.fao;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class LMFileWhatcher extends FileAlterationObserver {
    public LMFileWhatcher(File directory) {
        super(directory);


    }

}
