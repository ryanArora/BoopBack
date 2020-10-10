package me.ryanarora;


import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;


public class BoopBackConfig {
    private static Configuration config = BoopBack.getConfig();

    public static String getEnabled(){
        String enabled;
        Property enabledProp = config.get(Configuration.CATEGORY_GENERAL, "Enabled", "true", "Is the mod enabled or disabled");
        return enabledProp.getString();
    }

    public static void setEnabled(String key){

        if(key.equals("true") || key.equals("false")){
            try{
                Property enabledProp = config.get(Configuration.CATEGORY_GENERAL, "Enabled", "true", "Is the mod enabled or disabled");
                enabledProp.set(key);
                config.save();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}

