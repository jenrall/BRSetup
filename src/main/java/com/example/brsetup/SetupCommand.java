package com.example.brsetup;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage("Only players.");
            return true;
        }

        if (!p.hasPermission("brsetup.admin")) {
            p.sendMessage(Component.text("No permission.", NamedTextColor.RED));
            return true;
        }

        SetupGUI.openMain(p);
        return true;
    }
}
