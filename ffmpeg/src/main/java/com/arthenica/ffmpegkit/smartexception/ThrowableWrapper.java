package com.arthenica.ffmpegkit.smartexception;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class ThrowableWrapper {
    private final ThrowableWrapper cause;
    private final String className;
    private final String message;
    private final StackTraceElementWrapper[] stackTrace;
    private final ThrowableWrapper[] suppressed;

    public ThrowableWrapper(Throwable throwable) {
        this(throwable, Collections.newSetFromMap(new IdentityHashMap()));
    }

    public ThrowableWrapper(Throwable throwable, Set<Throwable> alreadyWrapped) {
        alreadyWrapped.add(throwable);
        this.message = throwable.getMessage();
        if (throwable.getCause() != null && !alreadyWrapped.contains(throwable.getCause())) {
            this.cause = new ThrowableWrapper(throwable.getCause(), alreadyWrapped);
        } else {
            this.cause = null;
        }
        this.className = throwable.getClass().getName();
        Throwable[] suppressedThrowableArray = throwable.getSuppressed();
        List<ThrowableWrapper> tmpList = new LinkedList<>();
        int throwableSuppressedLength = suppressedThrowableArray.length;
        for (int i = 0; i < throwableSuppressedLength; i++) {
            if (!alreadyWrapped.contains(suppressedThrowableArray[i])) {
                tmpList.add(new ThrowableWrapper(suppressedThrowableArray[i], alreadyWrapped));
            }
        }
        this.suppressed = (ThrowableWrapper[]) tmpList.toArray(new ThrowableWrapper[0]);
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        this.stackTrace = new StackTraceElementWrapper[stackTraceElements.length];
        int stackTraceElementsLength = stackTraceElements.length;
        for (int i2 = 0; i2 < stackTraceElementsLength; i2++) {
            this.stackTrace[i2] = new StackTraceElementWrapper(stackTraceElements[i2]);
        }
    }

    public ThrowableWrapper(String message, ThrowableWrapper cause, String className, ThrowableWrapper[] suppressed, StackTraceElementWrapper[] stackTrace) {
        this.message = message;
        this.cause = cause;
        this.className = className;
        this.suppressed = suppressed;
        this.stackTrace = stackTrace;
    }

    public String getMessage() {
        return this.message;
    }

    public ThrowableWrapper getCause() {
        return this.cause;
    }

    public String getClassName() {
        return this.className;
    }

    public ThrowableWrapper[] getSuppressed() {
        return this.suppressed;
    }

    public StackTraceElementWrapper[] getStackTrace() {
        return this.stackTrace;
    }
}
