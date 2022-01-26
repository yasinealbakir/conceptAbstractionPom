package configs;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources("file:./src/test/resources/config/config.properties")

public interface IConfig extends Config {

    @Key("url")
    public String url();


}
