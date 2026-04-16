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
