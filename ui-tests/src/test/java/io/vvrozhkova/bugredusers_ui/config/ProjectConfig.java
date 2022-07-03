package io.vvrozhkova.bugredusers_ui.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config{

    @Config.DefaultValue("chrome")
    String browser();
    @Config.DefaultValue("91.0")
    String browserVersion();
    @Config.DefaultValue("1920x1080")
    String browserSize();
    String remoteDriverUrl();
    String videoStorage();

}
