package com.wl.dandan.view.generator;

import com.wl.dandan.model.Destination;
import com.wl.dandan.model.Taxonomy;
import com.wl.dandan.view.element.Navigation;
import com.wl.dandan.view.element.Page;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageGenerator {

    private final String outputDir;

    public PageGenerator(String outputDir) {
        this.outputDir = outputDir;
    }

    public void generateHtml(Destination destination, Taxonomy taxonomy){
        Page page = createPage(destination, taxonomy);
        try {
            TemplateEngine.getInstance().render(page, outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Page createPage(Destination destination, Taxonomy taxonomy){
        Page page = new Page(destination);

        page.setNavigation(new Navigation(buildNavigationUrl(taxonomy), taxonomy.getName()));

        if (taxonomy.hasChildren()){
            for(Taxonomy child: taxonomy.getChildren()){
                Navigation navigation = new Navigation(buildNavigationUrl(child), child.getName());
                page.addChildNavigation(navigation);
            }
        }

        Taxonomy parent = taxonomy.getParent();
        while(parent != null) {
            Navigation parentNav = new Navigation(buildNavigationUrl(parent), parent.getName());
            page.addParentNavigation(parentNav);
            parent = parent.getParent();
        }

        return page;
    }

    private static String buildNavigationUrl(final Taxonomy taxonomy){
        List<String> urls = new ArrayList<String>();
        urls.add(taxonomy.getName());
        Taxonomy parent = taxonomy.getParent();
        while(parent != null) {
            urls.add(0, parent.getName());
            parent = parent.getParent();
        }

        StringBuffer buffer = new StringBuffer();
        for(String url: urls){
            buffer.append(url);
            buffer.append(File.separator);
        }
        buffer.append(Page.INDEX_PAGE);
        return buffer.toString();
    }

    public String getOutputDir() {
        return outputDir;
    }

}
