package store.badger.simplerolebot.main;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.bukkit.configuration.file.YamlConfiguration;
import store.badger.simplerolebot.listeners.MentionListener;
import store.badger.simplerolebot.listeners.RoleCommand;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static JDA jda;
    public static void main(String[] args) throws LoginException, IOException, URISyntaxException {
        File config = new File("config.yml");
        YamlConfiguration fig = YamlConfiguration.loadConfiguration(config);
        String token = fig.getString("BotToken");
        JDA jdaa = new JDABuilder(token)
                .addEventListener(new RoleCommand()).addEventListener(new MentionListener()).build();
        System.out.println("BOT IS RUNNING");
        jda = jdaa;
        Timer task = new Timer();
        task.scheduleAtFixedRate(new TimerTask() {
            int displayStatus = 0;
            @Override
            public void run() {
                if (displayStatus == 0) {
                    jda.getPresence().setPresence(Game.of(Game.GameType.DEFAULT,";;role | https://docs.badger.store"), true);
                    displayStatus = 1;
                } else {
                    jda.getPresence().setPresence(Game.of(Game.GameType.DEFAULT, "https://github.com/thewolfbadger"), true);
                    displayStatus = 0;
                }
            }
        }, 0L, 1000*60*10L); // updates every 10 minutes
    }
    public static YamlConfiguration getConfig() {
        File config = new File("config.yml");
        YamlConfiguration fig = YamlConfiguration.loadConfiguration(config);
        return fig;
    }
    public static JDA getJDA() {
        return jda;
    }
}
