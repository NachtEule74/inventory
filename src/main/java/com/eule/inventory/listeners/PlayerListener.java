package com.eule.inventory.listeners;

import com.hypixel.hytale.event.EventRegistry;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef; // WICHTIGER IMPORT
import com.eule.inventory.inventoryPlugin;
import java.util.UUID;
import java.util.logging.Level;

public class PlayerListener {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public void register(EventRegistry eventBus) {
        try {
            eventBus.register(PlayerConnectEvent.class, this::onPlayerConnect);
            LOGGER.at(Level.INFO).log("[inventory] Registered PlayerConnectEvent listener");
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log("[inventory] Failed to register PlayerConnectEvent");
        }

        try {
            eventBus.register(PlayerDisconnectEvent.class, this::onPlayerDisconnect);
            LOGGER.at(Level.INFO).log("[inventory] Registered PlayerDisconnectEvent listener");
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log("[inventory] Failed to register PlayerDisconnectEvent");
        }
    }

    private void onPlayerConnect(PlayerConnectEvent event) {
        PlayerRef playerRef = event.getPlayerRef();
        if (playerRef == null) return;

        String playerName = playerRef.getUsername();
        // Hier holen wir die UUID sicher aus der PlayerRef
        UUID uuid = playerRef.getUuid();

        LOGGER.at(Level.INFO).log("[inventory] Player %s connected. Loading inventory data...", playerName);

        // HIER DIE LOGIK: Seitenanzahl abrufen
        int unlockedPages = inventoryPlugin.getInstance().getDataManager().getPages(uuid);

        // Optional: Nachricht an den Spieler (falls das Event spät genug feuert)
        // playerRef.tryGetPlayer().ifPresent(p -> p.sendMessage("Deine Inventarseiten wurden geladen."));
    }

    private void onPlayerDisconnect(PlayerDisconnectEvent event) {
        PlayerRef playerRef = event.getPlayerRef();
        if (playerRef == null) return;

        UUID uuid = playerRef.getUuid();
        LOGGER.at(Level.INFO).log("[inventory] Player %s disconnected. Saving data...", playerRef.getUsername());

        // HIER DIE LOGIK: Daten speichern, wenn der Spieler geht
        inventoryPlugin.getInstance().getDataManager().saveAll();
    }
}