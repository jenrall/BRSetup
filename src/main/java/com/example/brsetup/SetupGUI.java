package com.example.brsetup;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SetupGUI {

    public static final String MAIN_TITLE = "BR Setup";

    // آیتم‌های قابل کلیک (شناسه‌ها)
    public static final String ACTION_CREATE = "action_create";
    public static final String ACTION_DELETE = "action_delete";
    public static final String ACTION_LIST = "action_list";
    public static final String ACTION_SET_LOBBY = "action_setlobby";
    public static final String ACTION_SET_SPAWN = "action_setspawn";
    public static final String ACTION_START = "action_start";
    public static final String ACTION_STOP = "action_stop";

    public static void openMain(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, Component.text(MAIN_TITLE));

        // پس‌زمینه
        ItemStack filler = makeItem(Material.GRAY_STAINED_GLASS_PANE, " ", null);
        for (int i = 0; i < 27; i++) inv.setItem(i, filler);

        // Create Arena
        inv.setItem(10, makeItem(Material.EMERALD_BLOCK,
                "§a§lCreate Arena",
                "§7با /br create <name> آرنا بساز"));

        // Delete Arena
        inv.setItem(11, makeItem(Material.REDSTONE_BLOCK,
                "§c§lDelete Arena",
                "§7با /br delete <name> حذف کن"));

        // List Arenas
        inv.setItem(12, makeItem(Material.BOOK,
                "§e§lList Arenas",
                "§7همه آرناها رو ببین"));

        // Set Lobby
        inv.setItem(14, makeItem(Material.OAK_DOOR,
                "§6§lSet Lobby",
                "§7نقطه لابی رو تنظیم کن"));

        // Set Spawn
        inv.setItem(15, makeItem(Material.COMPASS,
                "§b§lSet Game Spawn",
                "§7نقطه شروع بازی رو تنظیم کن"));

        // Start
        inv.setItem(21, makeItem(Material.LIME_WOOL,
                "§a§lStart Game",
                "§7بازی رو شروع کن"));

        // Stop
        inv.setItem(23, makeItem(Material.BARRIER,
                "§c§lStop Game",
                "§7بازی رو متوقف کن"));

        p.openInventory(inv);
    }

    private static ItemStack makeItem(Material mat, String name, String lore) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        if (lore != null) {
            meta.setLore(Arrays.asList(lore.split("\n")));
        }
        item.setItemMeta(meta);
        return item;
    }

    // شناسه آیتم رو از روی اسمش تشخیص بده
    public static String getAction(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return null;
        String name = item.getItemMeta().getDisplayName();
        if (name == null) return null;

        if (name.contains("Create Arena")) return ACTION_CREATE;
        if (name.contains("Delete Arena")) return ACTION_DELETE;
        if (name.contains("List Arenas")) return ACTION_LIST;
        if (name.contains("Set Lobby")) return ACTION_SET_LOBBY;
        if (name.contains("Set Game Spawn")) return ACTION_SET_SPAWN;
        if (name.contains("Start Game")) return ACTION_START;
        if (name.contains("Stop Game")) return ACTION_STOP;

        return null;
    }
}
