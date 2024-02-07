package et.spi.fao;

import org.apache.commons.io.monitor.FileAlterationListener;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.comparator.LastModifiedFileComparator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class YourFileListener implements FileAlterationListener {

    @Override
    public void onStart(FileAlterationObserver observer) {
        // This method is called when the observer is started
    }

    @Override
    public void onDirectoryCreate(File directory) {
        // This method is called when a directory is created
    }

    @Override
    public void onDirectoryChange(File directory) {
        // This method is called when a directory is changed
    }

    @Override
    public void onDirectoryDelete(File directory) {
        // This method is called when a directory is deleted
    }

    @Override
    public void onFileCreate(File file) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(file.lastModified());
        String formattedString = String.format("File: %s, Last Modified: %s,", file.getName(), formattedDate);
        System.out.println(formattedString);
        System.out.println("__________________");
        System.out.println("File created: " + file);

        // List files in the directory and sort them using the custom comparator

        File[] files = file.getParentFile().listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);


        for (File file1 : files) {


            String formattedString1 = String.format("File: %s, Last Modified: %s,", file1.getName(), dateFormat.format(file1.lastModified()));
            System.out.println(formattedString1);

        }
    }

    @Override
    public void onFileChange(File file) {
        // This method is called when a file is changed
    }

    @Override
    public void onFileDelete(File file) {
        // This method is called when a file is deleted
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        // This method is called when the observer is stopped
    }
}