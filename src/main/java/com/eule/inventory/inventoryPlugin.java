package com.eule.inventory;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.event.EventRegistry;
import com.hypixel.hytale.logger.HytaleLogger;


import com.eule.inventory.listeners.PlayerListener;
import com.eule.inventory.data.InventoryDataManager; // Der Import für deinen Manager

import javax.annotation.Nonnull;
import java.util.logging.Level;

/**
 * inventory - A Hytale server plugin.
 */
public class inventoryPlugin extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    private static inventoryPlugin instance;

    // 1. Die Variable für den DataManager hinzufügen
    private InventoryDataManager dataManager;

    public inventoryPlugin(@Nonnull JavaPluginInit init) {
        super(init);
        instance = this;
    }

    /**
     * Get the plugin instance.
     * @return The plugin instance
     */
    public static inventoryPlugin getInstance() {
        return instance;
    }

    // 2. Diese Methode MUSS hier stehen, damit der PlayerListener sie finden kann
    public InventoryDataManager getDataManager() {
        return dataManager;
    }

    @Override
    protected void setup() {
        LOGGER.at(Level.INFO).log("[inventory] Setting up...");

        // 3. Den DataManager hier initialisieren
        this.dataManager = new InventoryDataManager();


        // Register event listeners
        registerListeners();

        LOGGER.at(Level.INFO).log("[inventory] Setup complete!");
    }


    /**
     * Register event listeners.
     */
    private void registerListeners() {
        EventRegistry eventBus = getEventRegistry();

        try {
            new PlayerListener().register(eventBus);
            LOGGER.at(Level.INFO).log("[inventory] Registered player event listeners");
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log("[inventory] Failed to register listeners");
        }
    }

    @Override
    protected void start() {
        LOGGER.at(Level.INFO).log("[inventory] Started!");
        LOGGER.at(Level.INFO).log("[inventory] Use /inv help for commands");
    }

    @Override
    protected void shutdown() {
        LOGGER.at(Level.INFO).log("[inventory] Shutting down...");

        // 4. Daten beim Beenden speichern
        if (dataManager != null) {
            dataManager.saveAll();
        }

        instance = null;
    }
}