package su.vigo.Form.Resources;

import java.util.ResourceBundle;

public final class Resources {
    static final ResourceBundle strings;

    static {
        strings = ResourceBundle.getBundle("su.vigo.Form.Resources.res");
    }

    private Resources() {
    }

    public static String string(String name) {
        return strings.getString(name);
    }
}
