package hexlet.code;

public class OldNewValue {
    private static Object oldValue;
    private static Object newValue;

    public OldNewValue(Object oldValue, Object newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public static Object getOldValue() {
        return oldValue;
    }

    public static Object getNewValue() {
        return newValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }
}
