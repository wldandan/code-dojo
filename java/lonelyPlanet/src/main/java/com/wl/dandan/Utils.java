package com.wl.dandan;

import com.google.common.io.Files;
import org.xml.sax.Attributes;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static int getInt(Attributes attributes, String name) {
        String v = getString(attributes, name);
        try {
            return Integer.parseInt(v);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String getString(Attributes attributes, String name) {
        String s = attributes.getValue(name);
        if (s == null)
            return null;
        return s.trim();
    }

//    public static Map<Integer, Taxonomy> parseNode(Taxonomy taxonomy){
//        Map<Integer, Taxonomy> nodeMap = new HashMap<Integer, Taxonomy>();
//        nodeMap.put(taxonomy.getId(), taxonomy);
//
//        for (Taxonomy currentTaxonomy : taxonomy.getChildren()){
//            parseNode(currentTaxonomy);
//        }
//        return nodeMap;
//    }

    public static void copyFiles(String srcDir, String destDir) throws IOException {
        final File sourceFile = new File(srcDir);
        final File targetFile = new File(destDir);

        if (sourceFile.isDirectory()){
            for (File file: sourceFile.listFiles()){
                Files.copy(file, new File(destDir + File.separator.toString() + file.getName()));
            }
        }
        else if (sourceFile.isFile()){
            Files.copy(sourceFile, targetFile);
        }

    }

}
