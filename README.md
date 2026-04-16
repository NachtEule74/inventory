ENGLISH:
🛡️ THE PLUGIN IS RUNNING BUT I CAN'T SEE THE UI CHANGES!!!

🛡️ Hytale Metin2-Style Inventory SystemA specialized backend and UI system for Hytale that extends the classic inventory with a tab-based structure. This plugin focuses on data management and automated unlocking logic without cluttering the chat with commands.

🚀 Core Features
🗂️ Automated Inventory Expansion: The system manages up to four independent inventory pages. Access is controlled not via commands, but directly through player data.
🔒 Status-Based UI (Headless Logic)The UI independently determines which tabs are available based on the data provided by the plugin.UUID Binding: All progress is permanently tied to the player’s UUID.Smart Loading: Data is loaded asynchronously immediately upon login (PlayerConnectEvent) to prevent delays when opening the inventory.
⚡ Optimized ECS Data Structure The plugin uses the Hytale Entity-Component-System (ECS) in a high-performance “Event-Only” configuration: Memory-Efficient: Uses ConcurrentHashMap for thread-safe access. Lifecycle-Managed: Automatic saving upon server shutdown or disconnect to prevent data loss.

📂 Project Structure
com.eule.inventory: Initializes the data manager and event buses
com.eule.inventory.data: Core logic of the InventoryDataManager
com.eule.inventory.listeners: Connects Hytale events (login/logout) to the data layer.

🛠 Integration & Technical SetupPlace the inventory.jar file in your plugins folder.Make sure the UUIDComponent is available in your server build. The plugin automatically registers with the EventBus and begins monitoring player data.Data Query (API for Other Plugins)Other plugins can retrieve the unlocked pages directly via the instance, for example, to place items only in specific pockets:Javaint pages = inventoryPlugin.getInstance().getDataManager().getPages(playerUUID);
🎨 UI Logic (Assets)Since no commands are used, the inventory is accessed via the standard Hytale UI bindings. The plugin provides the necessary data contexts (unlockedPages) for this, which can be used in the .json UI templates to lock or unlock tabs.

🤝 ContributeSince the command layer has been removed, the focus is now on expanding storage options (e.g., SQL connection or JSON files). Pull requests for new storage providers are very welcome.

🛡️ License
Anyone can use this project. I created it with AI and don’t really know much about programming, but a Hytale plugin like this would be awesome.


GERMAN:
🛡️ PLUGIN LÄUFT ABER SEHE DIE UI ÄNDERUNGEN NICHT!!!

🛡️ Hytale Metin2-Style Inventory SystemEin spezialisiertes Backend- und UI-System für Hytale, das das klassische Inventar um eine tab-basierte Struktur erweitert. Dieses Plugin konzentriert sich auf die Datenhaltung und automatisierte Freischalt-Logik, ohne den Chat mit Befehlen zu belasten.

🚀 Kern-Features
🗂️ Automatisierte Inventar-ErweiterungDas System verwaltet bis zu vier unabhängige Inventarseiten. Der Zugriff wird nicht über Befehle, sondern direkt über die Player-Daten gesteuert.
🔒 Status-basierte UI (Headless Logic)Die UI entscheidet eigenständig basierend auf den vom Plugin bereitgestellten Daten, welche Tabs nutzbar sind.UUID-Binding: Jeder Fortschritt wird permanent an die Spieler-UUID gebunden.Smart Loading: Daten werden sofort beim Login (PlayerConnectEvent) asynchron geladen, um Verzögerungen beim Öffnen des Inventars zu vermeiden.
⚡ Optimierte ECS-DatenstrukturDas Plugin nutzt das Hytale Entity-Component-System (ECS) in einer performanten "Event-Only" Konfiguration:Memory-Efficient: Nutzt ConcurrentHashMap für thread-sicheren Zugriff.Lifecycle-Managed: Automatisches Speichern beim Server-Shutdown oder Disconnect, um Datenverlust zu verhindern.

📂 Projekt-Struktur
com.eule.inventory: Initialisiert den Daten-Manager und die Event-Busse
com.eule.inventory.data: Kernlogik des InventoryDataManager
com.eule.inventory.listeners: Verbindet Hytale-Events (Login/Logout) mit der Daten-Ebene.

🛠 Integration & TechnikInstallationLege die inventory.jar in deinen plugins Ordner.Stelle sicher, dass die UUIDComponent in deinem Server-Build verfügbar ist.Das Plugin registriert sich automatisch beim EventBus und beginnt mit der Überwachung der Spieler-Daten.Daten-Abfrage (API für andere Plugins)Andere Plugins können die freigeschalteten Seiten direkt über die Instanz abrufen, um z.B. Items nur in bestimmte Taschen zu legen:Javaint pages = inventoryPlugin.getInstance().getDataManager().getPages(playerUUID);
🎨 UI-Logik (Assets)Da keine Commands genutzt werden, erfolgt der Aufruf des Inventars über die Standard-Hytale UI-Bindings. Das Plugin liefert hierfür die nötigen Daten-Kontexte (unlockedPages), die in den .json UI-Templates verwendet werden können, um Tabs zu sperren oder freizugeben.

🤝 MitwirkenDa die Command-Ebene entfernt wurde, liegt der Fokus nun auf der Erweiterung der Speichermedien (z.B. SQL-Anbindung oder JSON-Files). Pull Requests für neue Storage-Provider sind herzlich willkommen.

🛡️ Lizenz
Dieses Projekt kann jeder nutzen habe es mit Ai erstellt und hab nicht wirklich Plan von Programmieren aber so ein Hytale plugin wäre schon geil
