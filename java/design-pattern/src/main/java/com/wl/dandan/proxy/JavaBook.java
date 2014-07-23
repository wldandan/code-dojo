package com.wl.dandan.proxy;

public class JavaBook implements Book{

    private final String title;

    public JavaBook(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
