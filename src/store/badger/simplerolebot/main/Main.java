package store.badger.simplerolebot.main;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import store.badger.simplerolebot.listeners.RoleCommand;

import javax.security.auth.login.LoginException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws LoginException {
        String token = "";
        // TODO Get token from config.yml
        JDA jda = new JDABuilder(token)
                .addEventListener(new RoleCommand()).build();
        Timer task = new Timer();
        task.scheduleAtFixedRate(new TimerTask() {
            int displayStatus = 0;
            @Override
            public void run() {
                if (displayStatus == 0) {
                    jda.getPresence().setPresence(Game.watching(" " + jda.getGuilds().size() + " Guilds"), true);
                    displayStatus = 1;
                } else {
                    jda.getPresence().setPresence(Game.of(Game.GameType.DEFAULT, "https://github.com/thewolfbadger"), true);
                    displayStatus = 0;
                }
            }
        }, 0L, 1000*60*10L); // updates every 10 minutes
    }
}
