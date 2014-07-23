package com.wl.dandan.singleton;

public class HungarySingleton {

    public static HungarySingleton instance = new HungarySingleton();

    private HungarySingleton() {
    }

    public static HungarySingleton getInstance() {
        return instance;
    }
}
