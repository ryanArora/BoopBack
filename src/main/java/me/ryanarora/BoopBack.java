package me.ryanarora;

import me.ryanarora.commands.BoopBackCommand;
import me.ryanarora.events.ChatEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BoopBack.MODID, version = BoopBack.VERSION, clientSideOnly = BoopBack.clientSideOnly)
public class BoopBack
{
    public static final String MODID = "boopback";
    public static final String VERSION = "1.0";
    public static final boolean clientSideOnly = true;

    public static final Minecraft mc = Minecraft.getMinecraft();
    private static Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        config = new Configuration(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ChatEvent());
        ClientCommandHandler.instance.registerCommand(new BoopBackCommand());
    }

    public static Configuration getConfig(){
        return config;
    }
}
