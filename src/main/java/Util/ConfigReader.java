package Util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

    private static Properties properties;

    public static Properties initialize_Properties() {
        properties = new Properties();

        try {
            // config dosyanın yolu — gerektiğinde güncelle
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Config dosyası okunamadı: " + e.getMessage());
        }

        return getProperties();
    }
    public static Properties getProperties() {
        return properties;
    }

}
