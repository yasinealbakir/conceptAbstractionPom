package configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static <T> T reader(Class<? extends Config> clazz) {
        return (T) ConfigFactory.create(clazz);
    }
}
