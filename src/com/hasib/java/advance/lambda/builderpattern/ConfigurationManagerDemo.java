package com.hasib.java.advance.lambda.builderpattern;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConfigurationManagerDemo {
    public static void main(String[] args) {
        ConfigurationManager configurationManager = ConfigurationManager.make(configurationManager1 -> configurationManager1.setUrl("Hudai ajaira testing")
                .setUsername("Bazlur")
                .setPassword("12345")
                .addRole("Admin")
                .addRole("Developer"));
    }
}

class ConfigurationManager {
    private String url, username, password;
    private List<String> roleList = new ArrayList<>();

    private ConfigurationManager() {
    }

    public static ConfigurationManager make(Consumer<ConfigurationManager> configurationManagerConsumer) {
        System.out.println("Making a configuration manager...");
        ConfigurationManager configurationManager = new ConfigurationManager();
        configurationManagerConsumer.accept(configurationManager);
        return configurationManager;
    }

    public ConfigurationManager setUrl(String url) {
        this.url = url;
        return this;
    }

    public ConfigurationManager setUsername(String username) {
        this.username = username;
        return this;
    }

    public ConfigurationManager setPassword(String password) {
        this.password = password;
        return this;
    }

    public ConfigurationManager addRole(String role) {
        this.roleList.add(role);
        return this;
    }
}
