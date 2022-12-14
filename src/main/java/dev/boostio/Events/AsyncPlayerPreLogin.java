package dev.boostio.Events;

import dev.boostio.ChatPro;
import dev.boostio.Utils.ColoringUtils;
import dev.boostio.Utils.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

public class AsyncPlayerPreLogin implements Listener {

    @EventHandler
    public void onAsyncPreLogin(AsyncPlayerPreLoginEvent event) {
        UUID uuid = event.getUniqueId();

        PlayerData playerData = new PlayerData();
        ChatPro.getInstance().getPlayerData().put(uuid, playerData);

        ChatColor defaultColor = ColoringUtils.convertColor(ChatPro.defaultChatColor);

        //Set default chat color.
        ChatPro.getInstance().getPlayerData().get(uuid).setChatColorName(defaultColor);
    }
}
