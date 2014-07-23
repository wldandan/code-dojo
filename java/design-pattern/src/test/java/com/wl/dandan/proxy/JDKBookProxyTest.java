package com.wl.dandan.proxy;

import org.junit.Test;

public class JDKBookProxyTest {

    @Test
    public void testJavaProxy() throws Exception {
        JDKProxy proxy = new JDKProxy();
        Book javaBookProxy = (Book) proxy.bind(new JavaBook("Java In Action"));
        javaBookProxy.getTitle();
    }
}
