package com.wl.dandan.view.element;

public class Navigation {

    private String path;

    private String title;

    public Navigation(String path, String title) {
        this.path = path;
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }
}
