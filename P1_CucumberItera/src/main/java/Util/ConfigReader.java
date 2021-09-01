package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public Properties init_prop()  {
        prop = new Properties();//object of properties class is created
        try {
            FileInputStream inputFile = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
