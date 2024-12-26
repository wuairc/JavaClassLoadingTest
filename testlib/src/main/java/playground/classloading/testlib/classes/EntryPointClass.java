package playground.classloading.testlib.classes;

import static playground.classloading.testlib.classes.Util.getSimpleName;
import static playground.classloading.testlib.classes.Util.noteClassClinitCalled;
import static playground.classloading.testlib.classes.Util.noteInterfaceInited;

import java.lang.reflect.Field;

public class EntryPointClass {

    private static final String TAG = "EntryPointClass";

    static {
        noteClassClinitCalled();
    }

    public static void start() {
        Log.info(TAG, "start");

        setStaticField();
    }

    private static void setStaticField() {
        try {
            Class<TargetClass> aClass = TargetClass.class;
            Log.info(TAG, "target class: " + getSimpleName(aClass.toString()));

            Field field = aClass.getField("staticFieldToSet");
            Log.info(TAG, "got field: " + getSimpleName(field.getType().toString()) + " "
                    + getSimpleName(field.getDeclaringClass().toString()) + "." + field.getName());

            Log.info(TAG, "before get redirect field value");
            Object oldValue = field.get(null);
            Log.info(TAG, "redirect field value is " + oldValue);

            Log.info(TAG, "new StaticFieldToSetImpl");
            StaticFieldToSet staticFieldToSet = new StaticFieldToSetImpl();

            Log.info(TAG, "before set field value: " + getSimpleName(staticFieldToSet.toString()));
            field.set(null, staticFieldToSet);

            Log.info(TAG, "call staticFieldToSet.StaticFieldToSetMethod");
            TargetClass.staticFieldToSet.StaticFieldToSetMethod();
            Log.info(TAG, "after call staticFieldToSet.StaticFieldToSetMethod");

            Log.info(TAG, "field const value is " + StaticFieldToSet.StaticFieldToSetConst);

            Log.info(TAG, "get targetClassStaticField: " + TargetClass.targetClassStaticField);

        } catch (Throwable e) {
            Log.error(TAG, "get field", e);
        }
    }


    public static class TargetClass extends DirectSuper implements TargetClassInterface {

        static {
            noteClassClinitCalled();
        }

        public static StaticFieldToSet staticFieldToSet = null;

        public static TargetClassStaticField targetClassStaticField = null;
        public static TargetClassStaticFieldWithInitValue targetClassStaticFieldWithInitValue = new TargetClassStaticFieldWithInitValue();
        public TargetClassInstanceField targetClassInstanceField = null;
        public TargetClassInstanceFieldWithInitValue targetClassInstanceFieldWithInitValue = new TargetClassInstanceFieldWithInitValue();

        public static void staticMethod() {
            Log.info(TAG, "static method called");
        }

        @Override
        public void DirectSuperInterfaceMethod() {

        }

        @Override
        public void SecondDirectSuperInterfaceMethod() {

        }
    }

    public interface StaticFieldToSet {
        String StaticFieldToSetConst = noteInterfaceInited();

        void StaticFieldToSetMethod();
    }

    public static class StaticFieldToSetImpl implements StaticFieldToSet {

        @Override
        public void StaticFieldToSetMethod() {
            Log.debug(TAG, "StaticFieldToSetMethod called");
        }
    }

    public static class TargetClassStaticField {
        static {
            noteClassClinitCalled();
        }
    }

    public static class TargetClassStaticFieldWithInitValue {
        static {
            noteClassClinitCalled();
        }
    }

    public static class TargetClassInstanceField {
        static {
            noteClassClinitCalled();
        }
    }

    public static class TargetClassInstanceFieldWithInitValue {
        static {
            noteClassClinitCalled();
        }
    }

    interface TargetClassInterface {
        String TargetClass = noteInterfaceInited();
    }

    public static abstract class DirectSuper extends SecondDirectSuper implements DirectSuperInterface {
        static {
            noteClassClinitCalled();
        }

        public static DirectSuperStaticField directSuperStaticField = null;
        public static DirectSuperStaticFieldWithInitValue directSuperStaticFieldWithInitValue = new DirectSuperStaticFieldWithInitValue();
        public DirectSuperInstanceField directSuperInstanceField = null;
        public DirectSuperInstanceFieldWithInitValue directSuperInstanceFieldWithInitValue = new DirectSuperInstanceFieldWithInitValue();
    }

    interface DirectSuperInterface {
        String DirectSuper = noteInterfaceInited();

        void DirectSuperInterfaceMethod();
    }


    public static class DirectSuperStaticField {
        static {
            noteClassClinitCalled();
        }
    }

    public static class DirectSuperStaticFieldWithInitValue {
        static {
            noteClassClinitCalled();
        }
    }

    public static class DirectSuperInstanceField {
        static {
            noteClassClinitCalled();
        }
    }

    public static class DirectSuperInstanceFieldWithInitValue {
        static {
            noteClassClinitCalled();
        }
    }

    public static abstract class SecondDirectSuper implements SecondDirectSuperInterface {
        static {
            noteClassClinitCalled();
        }

        public static SecondDirectSuperStaticField secondDirectSuperStaticField = null;
        public static SecondDirectSuperStaticFieldWithInitValue secondDirectSuperStaticFieldWithInitValue = new SecondDirectSuperStaticFieldWithInitValue();
        public SecondDirectSuperInstanceField secondDirectSuperInstanceField = null;
        public SecondDirectSuperInstanceFieldWithInitValue secondDirectSuperInstanceFieldWithInitValue = new SecondDirectSuperInstanceFieldWithInitValue();
    }

    interface SecondDirectSuperInterface {
        String SecondDirectSuper = noteInterfaceInited();

        void SecondDirectSuperInterfaceMethod();
    }

    public static class SecondDirectSuperStaticField {
        static {
            noteClassClinitCalled();
        }
    }

    public static class SecondDirectSuperStaticFieldWithInitValue {
        static {
            noteClassClinitCalled();
        }
    }

    public static class SecondDirectSuperInstanceField {
        static {
            noteClassClinitCalled();
        }
    }

    public static class SecondDirectSuperInstanceFieldWithInitValue {
        static {
            noteClassClinitCalled();
        }
    }
}
