package InterviewPrep2;

import java.util.*;

public class OrderConfiguration {
    public static void main(String[] args) {
        String configuration = "0001LAJ5KBX9H8|0003UKURNK403F|0002M06K1Z9WFA|0004OWRXZFMS2C";
        System.out.println(ordered_configuration(configuration));
    }

    public static List<String> ordered_configuration(String configuration) {
        Map<String, String> configurationMap = new TreeMap<>();
        List<String> configurationsList = new ArrayList<>(List.of(configuration.split("\\|")));
        List<String> configValues = new ArrayList<>();

        // if configuration string does not contain "|" characters, it is invalid
        if(configurationsList.size() <= 1) {
            return new ArrayList<>(List.of("Invalid configuration"));
        }

        for(String configPart : configurationsList) {
            String configKey;
            String configValue;

            // if configPart string cannot create configKey and configValue properly, it is invalid
            try {
                configKey = configPart.substring(0, 4);
                configValue = configPart.substring(4);
            } catch (StringIndexOutOfBoundsException e) {
                return new ArrayList<>(List.of("Invalid configuration"));
            }

            // if configPart string is not exactly 14 chars long (key is 4, value is 10), configKey is 0000, or configurationMap
            // already contains the configKey, the configuration string is invalid
            if(configPart.length() != 14 || configKey == "0000" || configurationMap.containsKey(configKey)) {
                return new ArrayList<>(List.of("Invalid configuration"));
            }

            configurationMap.put(configKey, configValue);
        }

        // add all sorted configuration values to the returning List
        configValues.addAll(configurationMap.values());
        return configValues;
    }
}
