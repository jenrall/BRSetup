package com.example.brsetup;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player p)) return;

        String title = e.getView().getTitle();
        if (!title.equals(SetupGUI.MAIN_TITLE)) return;

        e.setCancelled(true);

        ItemStack clicked = e.getCurrentItem();
        if (clicked == null) return;

        String action = SetupGUI.getAction(clicked);
        if (action == null) return;

        switch (action) {
            case SetupGUI.ACTION_CREATE -> p.performCommand("br create arena1");
            case SetupGUI.ACTION_DELETE -> p.performCommand("br delete arena1");
            case SetupGUI.ACTION_LIST -> p.performCommand("br list");
            case SetupGUI.ACTION_SET_LOBBY -> p.performCommand("br setlobby arena1");
            case SetupGUI.ACTION_SET_SPAWN -> p.performCommand("br setspawn arena1");
            case SetupGUI.ACTION_START -> p.performCommand("br start");
            case SetupGUI.ACTION_STOP -> p.performCommand("br stop");
            default -> p.sendMessage(Component.text("Unknown action.", NamedTextColor.RED));
        }

        p.closeInventory();
    }
}
