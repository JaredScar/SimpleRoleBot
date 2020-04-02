package store.badger.simplerolebot.listeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import store.badger.simplerolebot.api.API;
import store.badger.simplerolebot.main.Main;

public class MentionListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
        if (evt.getChannelType() == ChannelType.TEXT) {
            for (Member mentioned : evt.getMessage().getMentionedMembers()) {
                if (mentioned.getUser().getAsMention().equals(Main.getJDA().getSelfUser().getAsMention())) {
                    // They mentioned the bot
                    evt.getTextChannel().sendMessage(API.getInformationMessage(evt.getMember()).build()).submit();
                }
            }
        }
    }
}
