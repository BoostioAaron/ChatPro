package dev.boostio.Commands;

import dev.boostio.ChatPro;
import dev.boostio.Utils.ColoringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NameColor implements CommandExecutor {

    public static Inventory colorSelectionMenu = Bukkit.createInventory(null, 9, "Color Selector GUI");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players are allowed to execute this command :(");
            return false;
        }

        if (!sender.hasPermission("chatpro.colorcodes")) {
            sender.sendMessage(ColoringUtils.setColor(ChatPro.colorCommandNoPermission));
            return false;
        }

        Player player = (Player) sender;

        player.openInventory(colorSelectionMenu);
        player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);

        ItemStack defaultColor = new ItemStack(Material.WOOL, 1, (short) 0);
        ItemMeta defaultColorMD = defaultColor.getItemMeta();
        defaultColorMD.setDisplayName(ChatColor.WHITE + "Default");
        ArrayList<String> defaultLore = new ArrayList<>();
        defaultLore.add(ChatColor.BLUE + "Click to select color");
        defaultColorMD.setLore(defaultLore);
        defaultColor.setItemMeta(defaultColorMD);

        ItemStack lightBlueColor = new ItemStack(Material.WOOL, 1, (short) 3);
        ItemMeta lightBlueColorMD = lightBlueColor.getItemMeta();
        lightBlueColorMD.setDisplayName(ChatColor.AQUA + "Aqua");
        ArrayList<String> aquaLore = new ArrayList<>();
        aquaLore.add(ChatColor.BLUE + "Click to select color");
        lightBlueColorMD.setLore(aquaLore);
        lightBlueColor.setItemMeta(lightBlueColorMD);

        ItemStack greenColor = new ItemStack(Material.WOOL, 1, (short) 5);
        ItemMeta greenColorMD = greenColor.getItemMeta();
        greenColorMD.setDisplayName(ChatColor.GREEN + "Green");
        ArrayList<String> greenLore = new ArrayList<>();
        greenLore.add(ChatColor.BLUE + "Click to select color");
        greenColorMD.setLore(greenLore);
        greenColor.setItemMeta(greenColorMD);

        ItemStack grayColor = new ItemStack(Material.WOOL, 1, (short) 8);
        ItemMeta grayColorMD = grayColor.getItemMeta();
        grayColorMD.setDisplayName(ChatColor.GRAY + "Gray");
        ArrayList<String> grayLore = new ArrayList<>();
        greenLore.add(ChatColor.BLUE + "Click to select color");
        grayColorMD.setLore(grayLore);
        grayColor.setItemMeta(grayColorMD);


        // Add Items to the class menu
        colorSelectionMenu.setItem(0, defaultColor);
        colorSelectionMenu.setItem(1, grayColor);
        colorSelectionMenu.setItem(2, lightBlueColor);
        colorSelectionMenu.setItem(3, greenColor);

        return false;
    }
}
