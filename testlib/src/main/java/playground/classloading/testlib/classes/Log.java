package playground.classloading.testlib.classes;

import playground.classloading.testlib.log.LogLevel;

public class Log {
    private static Logger sLogger = null;

    public static void setLogger(Logger logger) {
        sLogger = logger;
    }

    public static void debug(String tag, String message) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Debug, tag, message, null);
        }
    }

    public static void debug(String tag, String message, Throwable error) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Debug, tag, message, error);
        }
    }

    public static void info(String tag, String message) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Info, tag, message, null);
        }
    }

    public static void info(String tag, String message, Throwable error) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Info, tag, message, error);
        }
    }


    public static void warn(String tag, String message) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Warn, tag, message, null);
        }
    }

    public static void warn(String tag, String message, Throwable error) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Warn, tag, message, error);
        }
    }


    public static void error(String tag, String message) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Error, tag, message, null);
        }
    }

    public static void error(String tag, String message, Throwable error) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(LogLevel.Error, tag, message, error);
        }
    }

    public interface Logger {
        void log(LogLevel logLevel, String tag, String message, Throwable error);
    }
}

