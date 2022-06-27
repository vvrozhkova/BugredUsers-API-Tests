package io.vvrozhkova.bugredusers_api.config;

import org.aeonbits.owner.ConfigFactory;


public class App {
    public static AppConfig config =
            ConfigFactory.create(AppConfig.class, System.getProperties());
}
