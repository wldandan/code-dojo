package com.wl.dandan.singleton;

public class LazySingleton {

    public static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }
}
