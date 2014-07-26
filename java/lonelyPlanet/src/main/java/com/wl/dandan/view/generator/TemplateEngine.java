package com.wl.dandan.view.generator;

import com.wl.dandan.view.element.Page;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static com.wl.dandan.view.generator.AssetsGenerator.getCssAssetsPath;
import static com.wl.dandan.view.generator.AssetsGenerator.getJsAssetsPath;

public class TemplateEngine {

    private static TemplateEngine instance = new TemplateEngine();

    public static TemplateEngine getInstance() {
        return instance;
    }

    private TemplateEngine() {
    }

    public void render(Page page, String rootDir) throws IOException {
        VelocityEngine ve = initEngine();
        VelocityContext context = initContext(page, rootDir);
        Writer writer = initFileWriter(page, rootDir);

        Template t = ve.getTemplate(File.separator + "template" + File.separator + "example.vm","UTF-8");
        t.merge( context, writer );

        writer.flush();
        writer.close();
    }

    private VelocityEngine initEngine() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.setProperty("input.encoding", "UTF-8");
        ve.setProperty("output.encoding", "UTF-8");
        ve.init();
        return ve;
    }

    private VelocityContext initContext(Page page, String rootDir) {
        VelocityContext context = new VelocityContext();
        context.put("rootDir",rootDir);
        context.put("cssUrls", getCssAssetsPath(rootDir));
        context.put("jsUrls", getJsAssetsPath(rootDir));
        context.put("parentLinks", page.getParentNavigations());
        context.put("selfLink", page.getNavigation());
        context.put("childrenLinks", page.getChildrenNavigations());
        context.put("destination", page.getDestination());
        return context;
    }

    private Writer initFileWriter(Page page, String rootDir) throws IOException {
        Writer writer;
        String outputDirectory = rootDir + File.separator + page.getOutputDir();
        new File(outputDirectory).mkdirs();
        writer = new FileWriter( outputDirectory + Page.INDEX_PAGE);
        System.out.println("Generating file " + outputDirectory + Page.INDEX_PAGE);

        return writer;
    }

}
