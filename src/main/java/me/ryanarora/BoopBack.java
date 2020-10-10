package me.ryanarora;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = BoopBack.MODID, version = BoopBack.VERSION, clientSideOnly = BoopBack.clientSideOnly)
public class BoopBack
{
    public static final String MODID = "boopback";
    public static final String VERSION = "1.0";
    public static final boolean clientSideOnly = true;

    private Minecraft mc = Minecraft.getMinecraft();

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void chatEvent(ClientChatReceivedEvent event)
    {
        String text = event.message.getUnformattedText();

        if (text.startsWith("From ") && text.endsWith(": Boop!")) {
            String[] reversed = reverseStringArray(text.split(" "));
            String username = reversed[1].replace(":", "");

            mc.thePlayer.sendChatMessage("/boop " + username);
        }
    }

    public String[] reverseStringArray(String [] array){
        String [] reversed = new String [array.length];
        for(int i = array.length; i > 0; i--){
            reversed[array.length - i] = array[i - 1];
        }
        return reversed;
    }
}
