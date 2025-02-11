package com.arthenica.ffmpegkit.smartexception.java;

import com.arthenica.ffmpegkit.smartexception.AbstractExceptions;
import com.arthenica.ffmpegkit.smartexception.ClassLoader;
import com.arthenica.ffmpegkit.smartexception.PackageLoader;
import com.arthenica.ffmpegkit.smartexception.StackTraceElementSerializer;
import com.arthenica.ffmpegkit.smartexception.ThrowableWrapper;
import java.util.Set;


public class Exceptions {
    static PackageLoader packageLoader = new JavaPackageLoader();
    static ClassLoader classLoader = new JavaClassLoader();

    static {
        AbstractExceptions.setStackTraceElementSerializer(new JavaStackTraceElementSerializer());
    }

    public static void registerRootPackage(String packageString) {
        AbstractExceptions.registerRootPackage(packageString);
    }

    public static void clearRootPackages() {
        AbstractExceptions.clearRootPackages();
    }

    public static void registerGroupPackage(String packageString) {
        AbstractExceptions.registerGroupPackage(packageString);
    }

    public static void clearGroupPackages() {
        AbstractExceptions.clearGroupPackages();
    }

    public static StackTraceElementSerializer getStackTraceElementSerializer() {
        return AbstractExceptions.getStackTraceElementSerializer();
    }

    public static void setStackTraceElementSerializer(StackTraceElementSerializer stackTraceElementSerializer) {
        AbstractExceptions.setStackTraceElementSerializer(stackTraceElementSerializer);
    }

    public static void registerIgnorePackage(String packageString, boolean ignoreCauseClasses) {
        AbstractExceptions.registerIgnorePackage(packageString, ignoreCauseClasses);
    }

    public static void clearIgnorePackages() {
        AbstractExceptions.clearIgnorePackages();
    }

    public static boolean getIgnoreAllCauses() {
        return AbstractExceptions.getIgnoreAllCauses();
    }

    public static void setIgnoreAllCauses(boolean ignoreAllCauses) {
        AbstractExceptions.setIgnoreAllCauses(ignoreAllCauses);
    }

    public static boolean isPrintPackageInformation() {
        return AbstractExceptions.isPrintPackageInformation();
    }

    public static void setPrintPackageInformation(boolean printPackageInformation) {
        AbstractExceptions.setPrintPackageInformation(printPackageInformation);
    }

    public static boolean getPrintSuppressedExceptions() {
        return AbstractExceptions.getPrintSuppressedExceptions();
    }

    public static void setPrintSuppressedExceptions(boolean printSuppressedExceptions) {
        AbstractExceptions.setPrintSuppressedExceptions(printSuppressedExceptions);
    }

    public static String getStackTraceString(Throwable throwable) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable));
    }

    public static String getStackTraceString(Throwable throwable, boolean ignoreAllCauses) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), ignoreAllCauses);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> rootPackageSet, Set<String> groupPackageSet, Set<String> ignorePackageSet) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), rootPackageSet, groupPackageSet, ignorePackageSet);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> rootPackageSet, Set<String> groupPackageSet, Set<String> ignorePackageSet, boolean ignoreAllCauses) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), rootPackageSet, groupPackageSet, ignorePackageSet, ignoreAllCauses);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> rootPackageSet, Set<String> groupPackageSet, Set<String> ignorePackageSet, boolean ignoreAllCauses, boolean printPackageInformation) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), rootPackageSet, groupPackageSet, ignorePackageSet, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> rootPackageSet, Set<String> groupPackageSet, Set<String> ignorePackageSet, boolean ignoreAllCauses, boolean printPackageInformation, boolean printSuppressedExceptions) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), rootPackageSet, groupPackageSet, ignorePackageSet, ignoreAllCauses, printPackageInformation, printSuppressedExceptions);
    }

    public static String getStackTraceString(Throwable throwable, String rootPackage) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), rootPackage);
    }

    public static String getStackTraceString(Throwable throwable, String rootPackage, String groupPackage) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), rootPackage, groupPackage);
    }

    public static String getStackTraceString(Throwable throwable, int maxDepth) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), maxDepth);
    }

    public static String getStackTraceString(Throwable throwable, int maxDepth, boolean ignoreAllCauses) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), maxDepth, ignoreAllCauses);
    }

    public static String getStackTraceString(Throwable throwable, int maxDepth, boolean ignoreAllCauses, boolean printPackageInformation) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), maxDepth, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(Throwable throwable, int maxDepth, boolean ignoreAllCauses, boolean printPackageInformation, boolean printSuppressedExceptions) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), maxDepth, ignoreAllCauses, printPackageInformation, printSuppressedExceptions);
    }

    public static String getAllMessages(Throwable throwable) {
        return AbstractExceptions.getAllMessages(throwable);
    }

    public static boolean containsCause(Throwable throwable, Class<?> causeClass) {
        return AbstractExceptions.containsCause(throwable, causeClass);
    }

    public static boolean containsCause(Throwable throwable, Class<?> causeClass, String causeMessage) {
        return AbstractExceptions.containsCause(throwable, causeClass, causeMessage);
    }

    public static Throwable getCause(Throwable throwable) {
        return AbstractExceptions.getCause(throwable);
    }

    public static Throwable getCause(Throwable throwable, int maxDepth) {
        return AbstractExceptions.getCause(throwable, maxDepth);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass) {
        return AbstractExceptions.searchCause(throwable, causeClass);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass, String causeMessage) {
        return AbstractExceptions.searchCause(throwable, causeClass, causeMessage);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass, String causeMessage, int maxDepth) {
        return AbstractExceptions.searchCause(throwable, causeClass, causeMessage, maxDepth);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> causeClass, int maxDepth) {
        return AbstractExceptions.searchCause(throwable, causeClass, maxDepth);
    }
}
