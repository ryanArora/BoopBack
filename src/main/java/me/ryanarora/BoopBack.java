package me.ryanarora;


import me.ryanarora.commands.BoopBackToggleCommand;
import me.ryanarora.events.ChatEvent;
import me.ryanarora.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = BoopBack.MODID, version = BoopBack.VERSION, clientSideOnly = BoopBack.clientSideOnly)
public class BoopBack
{

    private static Configuration config;

    public static final Minecraft mc = Minecraft.getMinecraft();


    public static final String MODID = "boopback";
    public static final String VERSION = "1.0";
    public static final boolean clientSideOnly = true;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        config = new Configuration(event.getSuggestedConfigurationFile());
    }


    public static Configuration getConfig(){
        return config;
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ChatEvent());
        ClientCommandHandler.instance.registerCommand(new BoopBackToggleCommand());
    }



}
