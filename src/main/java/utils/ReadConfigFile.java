package utils;

import java.util.ResourceBundle;

public class ReadConfigFile {

    public static String getConfigProp(String type) {

        ResourceBundle rb = ResourceBundle.getBundle("config");
        return rb.getString(type);
    }
}
