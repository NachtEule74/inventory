package com.eule.inventory.data;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryDataManager {

    // Die "Datenbank" im Arbeitsspeicher
    private final ConcurrentHashMap<UUID, Integer> unlockedPages = new ConcurrentHashMap<>();

    /**
     * Holt die Seitenanzahl direkt über die UUID.
     * Keine Hytale-spezifischen Entity-Probleme mehr.
     */
    public int getPages(UUID uuid) {
        return unlockedPages.getOrDefault(uuid, 0);
    }

    public void unlockNextPage(UUID uuid) {
        int current = getPages(uuid);
        unlockedPages.put(uuid, current + 1);
    }

    public void saveAll() {
        // Hier später Speichern in Datei
    }
}
