package com.arthenica.ffmpegkit.smartexception.java;

import com.arthenica.ffmpegkit.smartexception.ClassLoader;

public class JavaClassLoader implements ClassLoader {

    @Override
    public Class<?> loadClass(final String className) {
        try {
            java.lang.ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader.loadClass(className);
            }
        } catch (ClassNotFoundException | SecurityException ignored) {
        }

        try {
            java.lang.ClassLoader systemClassLoader = java.lang.ClassLoader.getSystemClassLoader();
            if (systemClassLoader != null) {
                return systemClassLoader.loadClass(className);
            }
        } catch (ClassNotFoundException | SecurityException | IllegalStateException | Error ignored) {
        }

        try {
            return Class.forName(className);
        } catch (ClassNotFoundException | LinkageError ignored) {
            return null;
        }
    }

}