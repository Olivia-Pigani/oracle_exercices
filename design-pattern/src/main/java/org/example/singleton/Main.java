package org.example.singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> configMap = new HashMap<>();
        configMap.put("db.host", "localhost");
        configMap.put("db.port", "5432");

        ConfigurationManager configurationManager1 = ConfigurationManager.getConfigurationInstance();
        ConfigurationManager configurationManager2 = ConfigurationManager.getConfigurationInstance();
        configurationManager1.loadConfig(configMap);
        System.out.println(configurationManager1.getAConfig("db.host"));
        System.out.println(configurationManager1.getAConfig("qzzdqzdqd"));

        if (configurationManager1 == configurationManager2) {
            System.out.println("same object");
        }


        Map<String, String> configMap2 = new HashMap<>();
        configMap.put("db.host", "aaaaaa");
        configMap.put("db.pqdqt", "54dddd32");

        configurationManager1.loadConfig(configMap2);

    }
}
