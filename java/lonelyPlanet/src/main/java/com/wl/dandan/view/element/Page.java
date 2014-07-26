package com.wl.dandan.view.element;

import com.wl.dandan.model.Destination;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.wl.dandan.view.generator.AssetsGenerator.getCssAssetsPath;
import static com.wl.dandan.view.generator.AssetsGenerator.getJsAssetsPath;

public class Page {

    public static final String INDEX_PAGE = "index.html";

    private Navigation navigation;
    private List<Navigation> parentNavigations = new ArrayList();
    private List<Navigation> childrenNavigations = new ArrayList();

    private Destination destination;

    public Page(Destination destination) {
        this.destination = destination;
    }

    public void addChildNavigation(Navigation navigation){
        this.childrenNavigations.add(navigation);
    }

    public void addParentNavigation(Navigation navigation){
        this.parentNavigations.add(0, navigation);
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    public String getOutputDir(){
        StringBuilder builder = new StringBuilder();
        for (Navigation nav: parentNavigations){
            builder.append(nav.getTitle() + File.separator);
        }
        builder.append(navigation.getTitle() + File.separator);
        return builder.toString();
    }

    public Destination getDestination() {
        return destination;
    }


    public Navigation getNavigation() {
        return navigation;
    }

    public List<Navigation> getParentNavigations() {
        return Collections.unmodifiableList(parentNavigations);
    }

    public List<Navigation> getChildrenNavigations() {
        return Collections.unmodifiableList(childrenNavigations);
    }
}
