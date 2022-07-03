package io.vvrozhkova.bugredusers_common.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/app.properties",
        "system:properties"
})
public interface AppConfig extends Config {

    String webUrl();

    String apiUrl();

    String userName();

    String userEmail();

    String userPassword();

    String testRun();

    String youtrackToken();

}
