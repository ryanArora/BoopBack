package me.ryanarora.threads;

import me.ryanarora.BoopBack;

public class DelayMessage extends Thread {
    private int delay;
    private String chatMsg;

    public DelayMessage(int delaytime, String chatMsg) {
        this.delay = delaytime;
        this.chatMsg = chatMsg;
    }

    @Override
    public void run() {
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BoopBack.mc.thePlayer.sendChatMessage(chatMsg);
    }
}
