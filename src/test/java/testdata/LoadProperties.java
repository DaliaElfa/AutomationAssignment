package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    private static Properties LoadProperties(String path)
    {
        Properties Pro = new Properties();
        try {
            FileInputStream stream = new FileInputStream(path);
            Pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error :" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
        }

        return Pro;
    }

    public static Properties UserData = LoadProperties(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\userdata.properties");
}
