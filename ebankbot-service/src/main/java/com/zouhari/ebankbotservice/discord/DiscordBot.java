package com.zouhari.ebankbotservice.discord;


import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.DiscordMapping;
import com.zouhari.ebankbotservice.agents.EbankAgent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.ai.chat.prompt.Prompt;

/**
 * @author ZOUHARI Dyae errahmane
 * @Pseudo dezy
 **/
@DiscordController
public class DiscordBot {
    private EbankAgent ebankAgent;

    public DiscordBot(EbankAgent ebankAgent) {
        this.ebankAgent = ebankAgent;
    }
    @DiscordMapping
    private void perform(MessageReceivedEvent event) {
        if  (event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        String response = ebankAgent.chat(new Prompt(query));
        event.getChannel().sendMessage(response).queue();
    }
}
