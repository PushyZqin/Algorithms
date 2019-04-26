package site.pushy.algorithms.apply.tree;

import java.io.File;

/**
 * @author Pushy
 * @since 2019/4/3 21:42
 */
public class ListDir {

    static void listDir(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            for (File each : file.listFiles()) {
                listDir(each, depth + 1);
            }
        }
    }

    static void listDirectory(String path) {
        listDir(new File(path), 0);
    }

    static long sizeDirectory(String path) {
        return sizeDirectory(new File(path));
    }

    static long sizeDirectory(File file) {
        long totalSize = file.length();

        if (file.isDirectory()) {
            for (File each : file.listFiles()) {
                totalSize += sizeDirectory(each);
            }
        }
        return totalSize;
    }

    public static void main(String[] args) {
        String path = "E:\\Programming\\Arithmetic\\java-algorithms\\src\\site\\pushy\\algorithms\\datastructure";

        listDirectory(path);

//        long size = sizeDirectory(path);
//        System.out.println(size);
//        System.out.println(size / 1024.00 + " KB");
    }

}
