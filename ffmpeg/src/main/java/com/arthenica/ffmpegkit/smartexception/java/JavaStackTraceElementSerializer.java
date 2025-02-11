package com.arthenica.ffmpegkit.smartexception.java;

import com.arthenica.ffmpegkit.smartexception.AbstractExceptions;
import com.arthenica.ffmpegkit.smartexception.StackTraceElementSerializer;


public class JavaStackTraceElementSerializer implements StackTraceElementSerializer {
    @Override
    public String toString(StackTraceElement stackTraceElement, boolean printModuleName, boolean printPackageInformation) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stackTraceElement.getMethodName());
        if (stackTraceElement.isNativeMethod()) {
            stringBuilder.append(getNativeMethodDefinition());
        } else if (stackTraceElement.getFileName() != null && stackTraceElement.getFileName().length() > 0) {
            stringBuilder.append("(");
            stringBuilder.append(stackTraceElement.getFileName());
            if (stackTraceElement.getLineNumber() >= 0) {
                stringBuilder.append(":");
                stringBuilder.append(stackTraceElement.getLineNumber());
            }
            stringBuilder.append(")");
        } else {
            stringBuilder.append(getUnknownSourceDefinition());
        }
        if (printPackageInformation) {
            stringBuilder.append(getPackageInformation(stackTraceElement));
        }
        return stringBuilder.toString();
    }

    @Override
    public String getPackageInformation(StackTraceElement stackTraceElement) {
        StringBuilder stringBuilder = new StringBuilder();
        String className = stackTraceElement.getClassName();
        Class<?> loadedClass = Exceptions.classLoader.loadClass(className);
        if (loadedClass != null) {
            String libraryName = AbstractExceptions.libraryName(loadedClass);
            String version = AbstractExceptions.version(Exceptions.packageLoader, loadedClass, AbstractExceptions.packageName(className));
            stringBuilder.append(AbstractExceptions.packageInformation(libraryName, version));
        }
        String libraryName2 = stringBuilder.toString();
        return libraryName2;
    }

    @Override
    public String getModuleName(StackTraceElement stackTraceElement) {
        return "";
    }

    @Override
    public String getNativeMethodDefinition() {
        return "(Native Method)";
    }

    @Override
    public String getUnknownSourceDefinition() {
        return "(Unknown Source)";
    }
}
