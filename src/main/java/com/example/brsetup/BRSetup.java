package com.example.brsetup;

import org.bukkit.plugin.java.JavaPlugin;

public final class BRSetup extends JavaPlugin {

    private static BRSetup instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("brsetup").setExecutor(new SetupCommand());
        getServer().getPluginManager().registerEvents(new GUIListener(), this);

        getLogger().info("BRSetup enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BRSetup disabled!");
    }

    public static BRSetup getInstance() { return instance; }
}
