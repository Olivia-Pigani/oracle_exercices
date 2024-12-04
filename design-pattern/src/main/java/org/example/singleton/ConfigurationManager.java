package org.example.singleton;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class ConfigurationManager {

    private static ConfigurationManager configurationManagerInstance;

    private Map<String,String> configMap = new HashMap<>();

    private ConfigurationManager(){
        //fake import
        configMap = new HashMap<>();
        configMap.put("db.host", "localhost");
        configMap.put("db.port", "5432");
    };

    public static ConfigurationManager getConfigurationInstance(){
        if(configurationManagerInstance == null){
            configurationManagerInstance = new ConfigurationManager();
        }

        return configurationManagerInstance;
    }

    public String getAConfig(String key){
        return configMap.get(key);
    }

}
