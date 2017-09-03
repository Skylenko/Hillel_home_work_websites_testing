package core.common.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    private static final String ENV_CONFIG_FILE = "env.config.file";
    private static final String PROPERTY_PATH = "src/main/resources/test.properties";

   // private static final String FINAL_PROPERTY_PATH = String.format(PROPERTY_PATH, ENV_CONFIG_FILE);

    private Properties testProperties = null;

    public PropertyUtils() throws IOException {
        this.testProperties = new Properties();
        this.testProperties.load(new FileInputStream(new File(PROPERTY_PATH)));
    }

    public String getProperty(String key){

       return testProperties.getProperty(key);

    }
}
