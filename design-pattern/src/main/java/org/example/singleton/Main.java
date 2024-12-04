package org.example.singleton;

public class Main {

    public static void main(String[] args) {


        ConfigurationManager configurationManager1 = ConfigurationManager.getConfigurationInstance();
        ConfigurationManager configurationManager2 = ConfigurationManager.getConfigurationInstance();
        System.out.println(configurationManager1.getAConfig("db.host"));

        if (configurationManager1 == configurationManager2) {
            System.out.println("same object");
        }

    }
}
