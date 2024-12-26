package playground.classloading.testlib;

import playground.classloading.testlib.classes.EntryPointClass;
import playground.classloading.testlib.classes.Log;
import playground.classloading.testlib.log.LogLevel;

public class ClassLoadingTest {

    public static void main(String[] args) {
        Log.setLogger(new LoggerImpl());

        EntryPointClass.start();
    }

    static class LoggerImpl implements Log.Logger {

        @Override
        public void log(LogLevel logLevel, String tag, String message, Throwable error) {
            System.out.println(logLevel + " [" + tag + "] " + message);
            if (error != null) {
                error.printStackTrace();
            }
        }
    }
}
