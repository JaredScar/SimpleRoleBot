package store.badger.simplerolebot.api;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import org.bukkit.configuration.file.YamlConfiguration;
import store.badger.simplerolebot.main.Main;

import java.awt.*;
import java.util.List;

public class API {
    public static boolean hasPermission(Member mem, Role role) {
        // Check if they have permission to give/take the provided role
        String givingRoleID = role.getId();
        YamlConfiguration config = Main.getConfig();
        for(String mainRole : config.getConfigurationSection("RoleConfiguration").getKeys(false)) {
            List<String> allowedRoleIDs = config.getStringList("RoleConfiguration." + mainRole);
            for (Role memRole : mem.getRoles()) {
                if (memRole.getId().equals(mainRole)) {
                    // They have this role, check next what roles they are allowed
                    for (String allowedRoleID : allowedRoleIDs) {
                        if (allowedRoleID.equals(givingRoleID) || allowedRoleID.equals("*")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean hasRoleAbove(Member mem, Role role) {
        for(Role r : mem.getRoles()) {
            if(r.getPositionRaw() > role.getPositionRaw()) {
                return true;
            }
        }
        return false;
    }
    public static EmbedBuilder getSuccessEmbed(String msg, Member mem) {
        EmbedBuilder embedb = new EmbedBuilder();
        embedb.setTitle("Success", "https://docs.badger.store/badger-software/simplerolebot");
        embedb.setFooter(mem.getUser().getAsTag(), mem.getUser().getAvatarUrl());
        embedb.setDescription(msg);
        embedb.setColor(Color.GREEN);
        embedb.setThumbnail("https://i.gyazo.com/aee20d021b30e63c8d1263093c0812ed.png");
        return embedb;
    }
    public static EmbedBuilder getSyntaxEmbed(String msg, Member mem) {
        EmbedBuilder embedb = new EmbedBuilder();
        embedb.setTitle("Invalid Syntax", "https://docs.badger.store/badger-software/simplerolebot");
        embedb.setFooter(mem.getUser().getAsTag(), mem.getUser().getAvatarUrl());
        embedb.setDescription(msg);
        embedb.setColor(Color.RED);
        embedb.setThumbnail("https://i.gyazo.com/aee20d021b30e63c8d1263093c0812ed.png");
        return embedb;
    }
    public static EmbedBuilder getFailureEmbed(String msg, Member mem) {
        EmbedBuilder embedb = new EmbedBuilder();
        embedb.setTitle("Failure", "https://docs.badger.store/badger-software/simplerolebot");
        embedb.setFooter(mem.getUser().getAsTag(), mem.getUser().getAvatarUrl());
        embedb.setDescription(msg);
        embedb.setColor(Color.RED);
        embedb.setThumbnail("https://i.gyazo.com/aee20d021b30e63c8d1263093c0812ed.png");
        return embedb;
    }
    public static EmbedBuilder getInformationMessage(Member mem) {
        EmbedBuilder embedb = new EmbedBuilder();
        embedb.setTitle("SimpleRoleBot by Badger", "https://github.com/TheWolfBadger/SimpleRoleBot");
        embedb.setFooter(mem.getUser().getAsTag(), mem.getUser().getAvatarUrl());
        embedb.setDescription("SimpleRoleBot was made by Badger (https://github.com/TheWolfBadger)\n\n"
        + "You can find more information on SimpleRoleBot over at https://docs.badger.store/badger-software/simplerolebot");
        embedb.setColor(Color.MAGENTA);
        embedb.setThumbnail("https://i.gyazo.com/aee20d021b30e63c8d1263093c0812ed.png");
        return embedb;
    }
}
