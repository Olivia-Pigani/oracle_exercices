package org.example.singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,String> configMap = new HashMap<>();

        configMap.put("db.host", "localhost");
        configMap.put("db.port", "5432");


        ConfigurationManager configurationManager = ConfigurationManager.getConfigurationInstance();

        System.out.println(configurationManager.getAConfig(configMap,"db.host"));


    }
}
