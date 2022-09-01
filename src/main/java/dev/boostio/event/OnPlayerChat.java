package dev.boostio.event;

import dev.boostio.ChatPro;
import dev.boostio.Utils.ColorCharParser;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class OnPlayerChat implements Listener {
    @EventHandler
    public void onLeave(AsyncPlayerChatEvent event) {
       Player player = event.getPlayer();

        if  (ChatPro.colorCodes) {

            ColorCharParser.ColorCodes(event);
        }

       ChatColor chatColor = ChatPro.getInstance().getPlayerData().get(player.getUniqueId()).getChatColorName();

       event.setFormat(chatColor + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.WHITE + ": " + event.getMessage());
    }
}
