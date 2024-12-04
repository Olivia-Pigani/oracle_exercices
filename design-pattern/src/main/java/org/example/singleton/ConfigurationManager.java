package org.example.singleton;

import java.util.Map;

public class ConfigurationManager {

    private static ConfigurationManager configurationManagerInstance;

    private ConfigurationManager(){};

    public static ConfigurationManager getConfigurationInstance(){
        if(configurationManagerInstance == null){
            configurationManagerInstance = new ConfigurationManager();
        }

        return configurationManagerInstance;
    }

    public String getAConfig(Map<String,String> configs, String key){
        return configs.get(key);
    }

}
