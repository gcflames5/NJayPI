package net.njay.njaypi.Util;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

/** Source: http://www.crazysquirrel.com/computing/java/basics/java-file-and-directory-copying.jspx */
public class FileUtil {
    public static void copy(File source, File destination) throws IOException {
        copy(source, destination, false);
    }

    public static void copy(File source, File destination, boolean force) throws IOException {
        if (!source.exists()) {
            throw new IllegalArgumentException("Source (" + source.getPath() + ") doesn't exist.");
        }

        if (!force && destination.exists()) {
            throw new IllegalArgumentException("Destination (" + destination.getPath() + ") exists.");
        }

        if (source.isDirectory()) {
            copyDirectory(source, destination);
        } else {
            copyFile(source, destination);
        }
    }

    private static void copyDirectory(File source, File destination) throws IOException {
        if (!destination.mkdirs()) {
            throw new IOException("Failed to create destination directories");
        }

        File[] files = source.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                copyDirectory(file, new File(destination, file.getName()));
            } else {
                copyFile(file, new File(destination, file.getName()));
            }
        }
    }

    private static void copyFile(File source, File destination) throws IOException {
        Files.copy(source, destination);
    }

    public static void delete(File f) {
        if (f.isDirectory()) {
            for (File c : f.listFiles()) {
                delete(c);
            }
        }

        f.delete();
    }

    public static boolean isHidden(File file) {
        return file.isHidden() || file.getName().startsWith(".");
    }
}
