package store.badger.simplerolebot.listeners;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RoleCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
        TextChannel chan = evt.getTextChannel();
        Member mem = evt.getMember();
        String msgCont = evt.getMessage().getContentRaw();
        String[] args = msgCont.split(" ");
        String command = args[0];
        /**
         * Commands:
         * ;;role remove @User <roleID>
         * ;;role add @User <roleID>
         */
        if (command.equalsIgnoreCase(";;role")) {
            // This is the command for roles
            if (args.length == 3) {
                String roleID = args[2];
                String userID = args[1].replaceAll("<", "").replaceAll(">", "")
                        .replaceAll("@", "");
                if (!isInteger(roleID)) {
                    // Not valid
                    // TODO Print not valid
                    return;
                }
                if (!isInteger(userID)) {
                    // Not valid
                    // TODO Print not valid
                    return;
                }
                if (args[1].equalsIgnoreCase("remove")) {
                    // Remove a role
                } else
                    if(args[1].equalsIgnoreCase("add")) {
                        // Add a role
                    }
            } else {
                // They did it wrong, should only have 3 arguments
            }
        }
    }
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
