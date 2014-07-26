package com.wl.dandan.view.generator;

import com.wl.dandan.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssetsGenerator {

    private static List<String> assets = new ArrayList<String>();

    public static final String ASSETS_CSS = "/assets/css";
    public static final String ASSETS_FONTS = "/assets/fonts";
    public static final String ASSETS_JS = "/assets/js";

    static {
        assets.add(ASSETS_CSS);
        assets.add(ASSETS_FONTS);
        assets.add(ASSETS_JS);
    }

    public static void cloneAssets(String rootDir) throws IOException {
        for (String asset: assets){
            new File(rootDir + asset).mkdirs();
            Utils.copyFiles(getTemplateDir() + asset, rootDir + asset);
        }
    }

    public static List<String> getCssAssetsPath(String rootDir){
        return getAssetsPath(rootDir, ASSETS_CSS);
    }

    public static List<String> getJsAssetsPath(String rootDir){
        return getAssetsPath(rootDir, ASSETS_JS);
    }

    private static List<String> getAssetsPath(String rootDir, String assets){
        List<String> results = new ArrayList<String>();

        File assetsPath = new File(rootDir + assets);
        if (assetsPath.isDirectory()){
            for (File file: assetsPath.listFiles()){
                results.add(file.getAbsolutePath());
            }
        }
        return results;
    }


    private static String getTemplateDir() {
        String templateDir = System.getProperty("template.dir");
        if (null == templateDir){
            templateDir = AssetsGenerator.class.getClassLoader().getResource("template").getFile();
        }
        return templateDir;
    }
}
