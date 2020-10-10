package me.ryanarora.events;

import me.ryanarora.BoopBack;
import me.ryanarora.BoopBackConfig;
import me.ryanarora.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
public class ChatEvent {

    private final Minecraft mc = BoopBack.mc;

    @SubscribeEvent
    public void chat(ClientChatReceivedEvent event){

        if(BoopBackConfig.getEnabled().equals("false")) return;

        String text = event.message.getUnformattedText();

        if (text.startsWith("From ") && text.endsWith(": Boop!")) {
            String[] reversed = Utils.reverseStringArray(text.split(" "));
            String username = reversed[1].replace(":", "");

            mc.thePlayer.sendChatMessage("/boop " + username);
        }
    }
}
