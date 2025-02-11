package com.arthenica.ffmpegkit.smartexception;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public abstract class AbstractExceptions {
    public static final boolean DEFAULT_IGNORE_ALL_CAUSES = false;
    public static final int DEFAULT_MAX_DEPTH = 10;
    public static final boolean DEFAULT_PRINT_MODULE_NAME = true;
    public static final boolean DEFAULT_PRINT_PACKAGE_INFORMATION = false;
    public static final boolean DEFAULT_PRINT_SUPPRESSED_EXCEPTIONS = true;
    static StackTraceElementSerializer stackTraceElementSerializer;
    static final Set<String> rootPackageSet = Collections.synchronizedSet(new HashSet());
    static final Set<String> groupPackageSet = Collections.synchronizedSet(new HashSet());
    static final Set<String> ignorePackageSet = Collections.synchronizedSet(new HashSet());
    static final Set<String> ignoreCausePackageSet = Collections.synchronizedSet(new HashSet());
    static boolean ignoreAllCauses = false;
    static boolean printPackageInformation = false;
    static boolean printModuleName = true;
    static boolean printSuppressedExceptions = true;

    public static boolean getPrintModuleName() {
        return printModuleName;
    }

    public static void setPrintModuleName(boolean printModuleName2) {
        printModuleName = printModuleName2;
    }

    public static void registerRootPackage(String packageString) {
        rootPackageSet.add(packageString);
    }

    public static void clearRootPackages() {
        rootPackageSet.clear();
    }

    public static void registerGroupPackage(String packageString) {
        groupPackageSet.add(packageString);
    }

    public static void clearGroupPackages() {
        groupPackageSet.clear();
    }

    public static StackTraceElementSerializer getStackTraceElementSerializer() {
        return stackTraceElementSerializer;
    }

    public static void setStackTraceElementSerializer(StackTraceElementSerializer stackTraceElementSerializer2) {
        stackTraceElementSerializer = stackTraceElementSerializer2;
    }

    public static void registerIgnorePackage(String packageString, boolean ignoreCauseClasses) {
        ignorePackageSet.add(packageString);
        if (ignoreCauseClasses) {
            ignoreCausePackageSet.add(packageString);
        }
    }

    public static void clearIgnorePackages() {
        ignorePackageSet.clear();
        ignoreCausePackageSet.clear();
    }

    public static boolean getIgnoreAllCauses() {
        return ignoreAllCauses;
    }

    public static void setIgnoreAllCauses(boolean ignoreAllCauses2) {
        ignoreAllCauses = ignoreAllCauses2;
    }

    public static boolean isPrintPackageInformation() {
        return printPackageInformation;
    }

    public static void setPrintPackageInformation(boolean printPackageInformation2) {
        printPackageInformation = printPackageInformation2;
    }

    public static boolean getPrintSuppressedExceptions() {
        return printSuppressedExceptions;
    }

    public static void setPrintSuppressedExceptions(boolean printSuppressedExceptions2) {
        printSuppressedExceptions = printSuppressedExceptions2;
    }

    public static String getStackTraceString(ThrowableWrapper throwable) {
        return getStackTraceString(throwable, rootPackageSet, groupPackageSet, ignorePackageSet, 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, boolean ignoreAllCauses2) {
        return getStackTraceString(throwable, rootPackageSet, groupPackageSet, ignorePackageSet, 0, ignoreAllCauses2, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2) {
        return getStackTraceString(throwable, rootPackageSet2, groupPackageSet2, ignorePackageSet2, 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, boolean ignoreAllCauses2) {
        return getStackTraceString(throwable, rootPackageSet2, groupPackageSet2, ignorePackageSet2, 0, ignoreAllCauses2, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, boolean ignoreAllCauses2, boolean printPackageInformation2) {
        return getStackTraceString(throwable, rootPackageSet2, groupPackageSet2, ignorePackageSet2, 0, ignoreAllCauses2, printPackageInformation2);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, boolean ignoreAllCauses2, boolean printPackageInformation2, boolean printSuppressedExceptions2) {
        return getStackTraceString(throwable, rootPackageSet2, groupPackageSet2, ignorePackageSet2, 0, ignoreAllCauses2, printPackageInformation2, printModuleName, printSuppressedExceptions2);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, String rootPackage) {
        return getStackTraceString(throwable, (Set<String>) Collections.singleton(rootPackage), new HashSet(), new HashSet(), 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, String rootPackage, String groupPackage) {
        return getStackTraceString(throwable, (Set<String>) Collections.singleton(rootPackage), (Set<String>) Collections.singleton(groupPackage), new HashSet(), 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, int maxDepth) {
        return getStackTraceString(throwable, new HashSet(), new HashSet(), new HashSet(), maxDepth, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, int maxDepth, boolean ignoreAllCauses2) {
        return getStackTraceString(throwable, new HashSet(), new HashSet(), new HashSet(), maxDepth, ignoreAllCauses2, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, int maxDepth, boolean ignoreAllCauses2, boolean printPackageInformation2) {
        return getStackTraceString(throwable, new HashSet(), new HashSet(), new HashSet(), maxDepth, ignoreAllCauses2, printPackageInformation2);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, int maxDepth, boolean ignoreAllCauses2, boolean printPackageInformation2, boolean printSuppressedExceptions2) {
        return getStackTraceString(throwable, new HashSet(), new HashSet(), new HashSet(), maxDepth, ignoreAllCauses2, printPackageInformation2, printModuleName, printSuppressedExceptions2);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, int maxDepth, boolean ignoreAllCauses2, boolean printPackageInformation2) {
        return getStackTraceString(throwable, rootPackageSet2, groupPackageSet2, ignorePackageSet2, maxDepth, ignoreAllCauses2, printPackageInformation2, printModuleName);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, int maxDepth, boolean ignoreAllCauses2, boolean printPackageInformation2, boolean printModuleName2) {
        return getStackTraceString(throwable, false, false, rootPackageSet2, groupPackageSet2, ignorePackageSet2, maxDepth, ignoreAllCauses2, printPackageInformation2, printModuleName2, printSuppressedExceptions);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, int maxDepth, boolean ignoreAllCauses2, boolean printPackageInformation2, boolean printModuleName2, boolean printSuppressedExceptions2) {
        return getStackTraceString(throwable, false, false, rootPackageSet2, groupPackageSet2, ignorePackageSet2, maxDepth, ignoreAllCauses2, printPackageInformation2, printModuleName2, printSuppressedExceptions2);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, boolean isCause, boolean isSuppressed, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, int maxDepth, boolean ignoreAllCauses2, boolean printPackageInformation2, boolean printModuleName2, boolean printSuppressedExceptions2) {
        return getStackTraceString(throwable, "", isCause, isSuppressed, rootPackageSet2, groupPackageSet2, ignorePackageSet2, maxDepth, ignoreAllCauses2, printPackageInformation2, printModuleName2, printSuppressedExceptions2);
    }

    public static String getStackTraceString(ThrowableWrapper throwable, String prefix, boolean isCause, boolean isSuppressed, Set<String> rootPackageSet2, Set<String> groupPackageSet2, Set<String> ignorePackageSet2, int maxDepth, boolean ignoreAllCauses2, boolean printPackageInformation2, boolean printModuleName2, boolean printSuppressedExceptions2) {
        StackTraceElement[] stackTraceElements;
        String message;
        String className;
        int i;
        int i2;
        String currentGroupPackage;
        StringBuilder builder = new StringBuilder();
        if (throwable == null) {
            return "";
        }
        String className2 = throwable.getClassName();
        if (maxDepth <= 0) {
            stackTraceElements = getStackTrace(throwable, rootPackageSet2, ignorePackageSet2);
        } else {
            stackTraceElements = getStackTrace(throwable, maxDepth);
        }
        String message2 = throwable.getMessage();
        if (!isEmpty(message2)) {
            message = message2;
        } else {
            message = throwable.getMessage();
        }
        if (isCause) {
            builder.append(System.lineSeparator());
            builder.append(prefix);
            builder.append("Caused by: ");
        } else if (isSuppressed) {
            builder.append(System.lineSeparator());
            builder.append(prefix);
            builder.append("Suppressed: ");
        }
        builder.append(className2);
        if (!isEmpty(message)) {
            builder.append(": ");
            builder.append(message);
        }
        int length = stackTraceElements.length;
        String currentGroupPackage2 = null;
        StackTraceElement firstStackTraceElementInTheGroup = null;
        int currentGroupCount = 0;
        int i3 = 0;
        while (i3 < length) {
            StackTraceElement traceElement = stackTraceElements[i3];
            String traceElementClassName = traceElement.getClassName();
            String groupPackageMatch = getContainingPackage(traceElementClassName, groupPackageSet2);
            if (groupPackageMatch != null) {
                if (groupPackageMatch.equals(currentGroupPackage2)) {
                    i = i3;
                    i2 = length;
                    currentGroupCount++;
                    currentGroupPackage = currentGroupPackage2;
                } else {
                    i = i3;
                    i2 = length;
                    appendStackTraceGroupElement(builder, currentGroupPackage2, currentGroupCount, firstStackTraceElementInTheGroup, printModuleName2, printPackageInformation2, prefix);
                    builder.append(System.lineSeparator());
                    builder.append(prefix);
                    builder.append("\tat ");
                    currentGroupPackage = groupPackageMatch;
                    firstStackTraceElementInTheGroup = traceElement;
                    currentGroupCount = 1;
                }
            } else {
                i = i3;
                i2 = length;
                int currentGroupCount2 = appendStackTraceGroupElement(builder, currentGroupPackage2, currentGroupCount, firstStackTraceElementInTheGroup, printModuleName2, printPackageInformation2, prefix);
                builder.append(System.lineSeparator());
                builder.append(prefix);
                builder.append("\tat ");
                if (stackTraceElementSerializer == null) {
                    throw new IllegalArgumentException("Stack trace element serializer not initialized.");
                }
                builder.append(prefix);
                builder.append(stackTraceElementSerializer.toString(traceElement, printModuleName2, printPackageInformation2));
                currentGroupPackage = null;
                currentGroupCount = currentGroupCount2;
            }
            i3 = i + 1;
            currentGroupPackage2 = currentGroupPackage;
            length = i2;
        }
        appendStackTraceGroupElement(builder, currentGroupPackage2, currentGroupCount, firstStackTraceElementInTheGroup, printModuleName2, printPackageInformation2, prefix);
        ThrowableWrapper[] suppressed = throwable.getSuppressed();
        if (suppressed == null || suppressed.length <= 0 || !printSuppressedExceptions2) {
            className = className2;
        } else {
            int length2 = suppressed.length;
            int i4 = 0;
            while (i4 < length2) {
                ThrowableWrapper suppressedThrowableWrapper = suppressed[i4];
                builder.append(getStackTraceString(suppressedThrowableWrapper, prefix + "\t", false, true, rootPackageSet2, groupPackageSet2, ignorePackageSet2, maxDepth, ignoreAllCauses2, printPackageInformation2, printModuleName2, printSuppressedExceptions2));
                i4++;
                className2 = className2;
                length2 = length2;
                message = message;
                stackTraceElements = stackTraceElements;
                suppressed = suppressed;
            }
            className = className2;
        }
        ThrowableWrapper cause = throwable.getCause();
        if (cause != null && !containsPackage(className, ignoreCausePackageSet) && !ignoreAllCauses2) {
            builder.append(getStackTraceString(cause, prefix, true, false, rootPackageSet2, groupPackageSet2, ignorePackageSet2, maxDepth, ignoreAllCauses2, printPackageInformation2, printModuleName2, printSuppressedExceptions2));
        }
        return builder.toString();
    }

    public static int appendStackTraceGroupElement(StringBuilder stringBuilder, String currentGroupPackage, int numberOfElementsInTheCurrentGroup, StackTraceElement firstStackTraceElementInTheGroup, boolean printModuleName2, boolean printPackageInformation2, String prefix) {
        if (numberOfElementsInTheCurrentGroup > 0) {
            if (stackTraceElementSerializer == null) {
                throw new IllegalArgumentException("Stack trace element serializer not initialized.");
            }
            stringBuilder.append(prefix);
            if (numberOfElementsInTheCurrentGroup == 1) {
                stringBuilder.append(stackTraceElementSerializer.toString(firstStackTraceElementInTheGroup, printModuleName2, printPackageInformation2));
                return 0;
            }
            stringBuilder.append(String.format("%s%s ... %d more", stackTraceElementSerializer.getModuleName(firstStackTraceElementInTheGroup), currentGroupPackage, Integer.valueOf(numberOfElementsInTheCurrentGroup - 1)));
            if (printPackageInformation2) {
                stringBuilder.append(stackTraceElementSerializer.getPackageInformation(firstStackTraceElementInTheGroup));
                return 0;
            }
            return 0;
        }
        return 0;
    }

    public static boolean containsPackage(String fullClassName, Set<String> packageSet) {
        return getContainingPackage(fullClassName, packageSet) != null;
    }

    public static String getContainingPackage(String fullClassName, Set<String> packageSet) {
        for (String parentExceptionPackage : packageSet) {
            if (fullClassName.startsWith(parentExceptionPackage)) {
                return parentExceptionPackage;
            }
        }
        return null;
    }

    public static String getAllMessages(Throwable throwable) {
        StringBuilder messageBuilder = new StringBuilder();
        getAllMessages(throwable, messageBuilder);
        return messageBuilder.toString();
    }

    public static void getAllMessages(Throwable throwable, StringBuilder messageBuilder) {
        if (throwable != null) {
            String message = throwable.getMessage();
            if (!isEmpty(message)) {
                if (messageBuilder.length() != 0) {
                    messageBuilder.append(System.lineSeparator());
                    messageBuilder.append(" - Caused by: ");
                }
                messageBuilder.append(message);
            }
            getAllMessages(throwable.getCause(), messageBuilder);
        }
    }

    public static StackTraceElement[] getStackTrace(ThrowableWrapper throwable, int maxDepth) {
        ArrayList<StackTraceElement> list = new ArrayList<>();
        if (throwable != null) {
            StackTraceElementWrapper[] stackTrace = throwable.getStackTrace();
            for (int i = 0; i < stackTrace.length && i < maxDepth; i++) {
                list.add(stackTrace[i].getStackTraceElement());
            }
        }
        return (StackTraceElement[]) list.toArray(new StackTraceElement[0]);
    }

    public static StackTraceElement[] getStackTrace(ThrowableWrapper throwable, Set<String> rootPackageSet2, Set<String> ignorePackageSet2) {
        ArrayList<StackTraceElement> list = new ArrayList<>();
        ArrayList<StackTraceElement> partialList = new ArrayList<>();
        if (throwable != null) {
            for (StackTraceElementWrapper stackTraceElement : throwable.getStackTrace()) {
                String className = stackTraceElement.getStackTraceElement().getClassName();
                if (!isEmpty(className)) {
                    if (containsPackage(className, rootPackageSet2)) {
                        list.addAll(partialList);
                        list.add(stackTraceElement.getStackTraceElement());
                    } else if (!containsPackage(className, ignorePackageSet2)) {
                        partialList.add(stackTraceElement.getStackTraceElement());
                    }
                }
            }
        }
        if (list.isEmpty()) {
            list.addAll(partialList);
        }
        return (StackTraceElement[]) list.toArray(new StackTraceElement[0]);
    }

    public static boolean containsCause(Throwable throwable, Class<?> causeClass) {
        return containsCause(throwable, causeClass, null);
    }

    public static boolean containsCause(Throwable throwable, Class<?> causeClass, String causeMessage) {
        return searchCause(throwable, causeClass, causeMessage, 10) != null;
    }

    public static Throwable getCause(Throwable throwable) {
        return getCause(throwable, 10);
    }

    public static Throwable getCause(Throwable throwable, int maxDepth) {
        if (throwable == null) {
            return null;
        }
        if (maxDepth <= 0) {
            return throwable;
        }
        Throwable cause = throwable.getCause();
        if (cause == null) {
            return throwable;
        }
        return getCause(cause, maxDepth - 1);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass) {
        return searchCause(throwable, causeClass, null, 10);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass, String causeMessage) {
        return searchCause(throwable, causeClass, causeMessage, 10);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass, String causeMessage, int maxDepth) {
        Throwable cause;
        if (throwable == null) {
            return null;
        }
        if (isEmpty(causeMessage)) {
            if (throwable.getClass().equals(causeClass)) {
                return throwable;
            }
        } else if (throwable.getClass().equals(causeClass) && getAllMessages(throwable).toLowerCase().contains(causeMessage.toLowerCase())) {
            return throwable;
        }
        if (maxDepth <= 0 || (cause = throwable.getCause()) == null) {
            return null;
        }
        return searchCause(cause, causeClass, causeMessage, maxDepth - 1);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass, int maxDepth) {
        Throwable cause;
        if (throwable == null) {
            return null;
        }
        if (throwable.getClass().equals(causeClass)) {
            return throwable;
        }
        if (maxDepth <= 0 || (cause = throwable.getCause()) == null) {
            return null;
        }
        return searchCause(cause, causeClass, maxDepth - 1);
    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static String packageName(String className) {
        int index;
        if (className == null || (index = className.lastIndexOf(".")) < 0) {
            return "";
        }
        return className.substring(0, index);
    }

    public static String version(PackageLoader packageLoader, Class<?> type, String packageName) {
        try {
            Package loadedPackage = type.getPackage();
            if (loadedPackage != null) {
                return loadedPackage.getImplementationVersion();
            }
            Package loadedPackage2 = packageLoader.getPackage(type.getClassLoader(), packageName);
            if (loadedPackage2 != null) {
                return loadedPackage2.getImplementationVersion();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String libraryName(Class<?> type) {
        String resource;
        int index;
        if (type != null) {
            try {
                URL resourceUrl = type.getClassLoader().getResource(type.getName().replace('.', '/') + ".class");
                if (resourceUrl != null && (index = (resource = resourceUrl.toString()).lastIndexOf(33)) > 0) {
                    String resource2 = resource.substring(0, index);
                    int index2 = resource2.lastIndexOf(47);
                    if (index2 > 0) {
                        resource2 = resource2.substring(index2 + 1);
                    }
                    int index3 = resource2.lastIndexOf(92);
                    if (index3 > 0) {
                        return resource2.substring(index3 + 1);
                    }
                    return resource2;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static String packageInformation(String libraryName, String version) {
        boolean hasLibraryName = libraryName != null;
        boolean hasVersion = version != null;
        if (hasLibraryName || hasVersion) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" [");
            if (hasLibraryName) {
                stringBuilder.append(libraryName);
            }
            if (hasVersion) {
                if (hasLibraryName) {
                    if (!libraryName.contains(version)) {
                        stringBuilder.append(":");
                        stringBuilder.append(version);
                    }
                } else {
                    stringBuilder.append(version);
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        return "";
    }
}
