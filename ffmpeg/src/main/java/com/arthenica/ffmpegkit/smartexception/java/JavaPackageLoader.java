package com.arthenica.ffmpegkit.smartexception.java;

import com.arthenica.ffmpegkit.smartexception.AbstractExceptions;
import com.arthenica.ffmpegkit.smartexception.PackageLoader;


public class JavaPackageLoader implements PackageLoader {
    @Override
    public Package getPackage(ClassLoader classLoader, String className) {
        return Package.getPackage(AbstractExceptions.packageName(className));
    }
}
