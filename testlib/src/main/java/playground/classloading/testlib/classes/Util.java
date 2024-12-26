package playground.classloading.testlib.classes;

public class Util {
    private static final String TAG = "ClassLoading";

    public static void noteClassClinitCalled() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTrace[2];
        Log.info(TAG, "clinit called: " + getSimpleName(element.getClassName()) + "." + element.getMethodName());
    }

    public static String noteInterfaceInited() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTrace[2];
        Log.info(TAG, "interface inited: " + getSimpleName(element.getClassName()) + "." + element.getMethodName());
        return "";
    }

    public static String getSimpleName(String className) {
        int index = className.lastIndexOf('$');
        if (index == -1) {
            index = className.lastIndexOf('.');
        }
        if (index == -1) {
            return className;
        }
        return className.substring(index + 1);
    }
}
