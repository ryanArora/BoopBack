package me.ryanarora.commands;

import me.ryanarora.BoopBack;
import me.ryanarora.BoopBackConfig;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class BoopBackCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "boopback";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if (BoopBackConfig.getEnabled().equals("true")) {
            BoopBackConfig.setEnabled("false");
            BoopBack.mc.thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "BoopBack toggled to : " + EnumChatFormatting.RED + "false"));
        } else {
            BoopBackConfig.setEnabled("true");
            BoopBack.mc.thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "BoopBack toggled to : " + EnumChatFormatting.GREEN + "true!"));
        }
    }
}
