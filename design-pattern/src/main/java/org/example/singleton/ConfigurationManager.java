package org.example.singleton;

import java.util.Map;

public class ConfigurationManager {

    private static ConfigurationManager configurationManagerInstance;

    private Map<String, String> configMap;

//    private ConfigurationManager() {
//        //fake import
//        configMap = new HashMap<>();
//        configMap.put("db.host", "localhost");
//        configMap.put("db.port", "5432");
//    }

    private ConfigurationManager() {

    }


    public static synchronized ConfigurationManager getConfigurationInstance() {
        if (configurationManagerInstance == null) {
            configurationManagerInstance = new ConfigurationManager();
        }

        return configurationManagerInstance;
    }

    public String getAConfig(String key) {
        return configMap.getOrDefault(key, "key do not exist");
    }

    public void loadConfig(Map<String, String> configs) {
        if (configMap == null) {
            configMap = configs;
        } else {
            System.out.println("there is already an existing config map");
        }
    }
}
