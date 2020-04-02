package store.badger.simplerolebot.listeners;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import store.badger.simplerolebot.api.API;
import store.badger.simplerolebot.main.Main;

import java.util.concurrent.TimeUnit;

public class RoleCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
        TextChannel chan = evt.getTextChannel();
        Member mem = evt.getMember();
        String msgCont = evt.getMessage().getContentRaw();
        String[] argsWithCommand = msgCont.split(" ");
        String command = argsWithCommand[0];
        String[] args = msgCont.replace(command + " ", "").split(" ");
        /**
         * Commands:
         * ;;role remove @User <roleID>
         * ;;role add @User <roleID>
         */
        if (command.equalsIgnoreCase(";;role")) {
            // This is the command for roles
            evt.getMessage().delete().submit();
            if (args.length == 3) {
                String roleID = args[2];
                String userID = args[1].replaceAll("<", "").replaceAll(">", "")
                        .replaceAll("@", "").replaceAll("!", "");
                if (!isLong(roleID)) {
                    // Not valid
                    try {
                        Message msg = chan.sendMessage(API.getSyntaxEmbed("You entered an improper RoleID", mem).build()).submit().get();
                        msg.delete().submitAfter(10, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
                if (!isLong(userID)) {
                    // Not valid
                    try {
                        Message msg = chan.sendMessage(API.getSyntaxEmbed("You entered an improper User", mem).build()).submit().get();
                        msg.delete().submitAfter(10, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
                Role role = Main.getJDA().getRoleById(Long.parseLong(roleID));
                Member roleUser = evt.getGuild().getMemberById(Long.parseLong(userID));
                if (role == null) {
                    // Is null, not valid
                    try {
                        Message msg = chan.sendMessage(API.getSyntaxEmbed("You entered an improper RoleID", mem).build()).submit().get();
                        msg.delete().submitAfter(10, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
                if (roleUser == null) {
                    // Is null, not valid
                    try {
                        Message msg = chan.sendMessage(API.getSyntaxEmbed("You entered an improper User", mem).build()).submit().get();
                        msg.delete().submitAfter(10, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    // Remove a role
                    if (API.hasPermission(mem, role)) {
                        if (API.hasRoleAbove(mem, role)) {
                            // Has permission to remove it
                            Main.getJDA().getGuildById(evt.getGuild().getId()).getController().removeSingleRoleFromMember(
                                    roleUser, role
                            ).submit();
                            chan.sendMessage(API.getSuccessEmbed(
                                    "Removed role " + role.getName() + " from user " + roleUser.getNickname(),
                                    mem).build()).submit();
                        } else {
                            chan.sendMessage(API.getFailureEmbed("Your role is lower than the one you are trying to remove... " +
                                            "\n\nYou do not have the proper permission to do this...",
                                    mem).build()).submit();
                        }
                    } else {
                        // Does not have permission
                        chan.sendMessage(API.getFailureEmbed("You do not have the proper permission to do this...",
                                mem).build()).submit();
                    }
                } else
                    if(args[0].equalsIgnoreCase("add")) {
                        // Add a role
                        if (API.hasPermission(mem, role)) {
                            if(API.hasRoleAbove(mem, role)) {
                                // Has permission to add it
                                Main.getJDA().getGuildById(evt.getGuild().getId()).getController().addSingleRoleToMember(
                                        roleUser, role
                                ).submit();
                                chan.sendMessage(API.getSuccessEmbed(
                                        "Added role " + role.getName() + " to user " + roleUser.getNickname(),
                                        mem).build()).submit();
                            } else {
                                chan.sendMessage(API.getFailureEmbed("Your role is lower than the one you are trying to remove... " +
                                                "\n\nYou do not have the proper permission to do this...",
                                        mem).build()).submit();
                            }
                        } else {
                            // Does not have permission
                            chan.sendMessage(API.getFailureEmbed("You do not have the proper permission to do this...",
                                    mem).build()).submit();
                        }
                    }
            } else {
                // They did it wrong, should only have 3 arguments
                try {
                    Message msg = chan.sendMessage(API.getSyntaxEmbed(";;role add @User <roleID>\n\n;;role remove @User <roleID>", mem).build()).submit().get();
                    msg.delete().submitAfter(10, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean isLong(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
