package io.vvrozhkova.bugredusers_api.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/app.properties"
})
public interface AppConfig extends Config {

    String apiUrl();

    String userName();
    String userEmail();
    String userPassword();

    String testRun();
    String youtrackToken();
}
