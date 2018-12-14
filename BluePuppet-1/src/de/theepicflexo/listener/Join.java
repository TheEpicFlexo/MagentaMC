package de.theepicflexo.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.inventivetalent.tabapi.TabAPI;

public class Join implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		ItemStack teleitem = new ItemStack(Material.NETHER_STAR);
		ItemMeta telemeta = teleitem.getItemMeta();
		telemeta.setDisplayName("§7Teleporter");
		teleitem.setItemMeta(telemeta);
		Player p = e.getPlayer();

		p.setGameMode(GameMode.ADVENTURE);
		p.setFoodLevel(20);
		p.setMaxHealth(1);
		p.getInventory().clear();
		for (int i = 0; i < 500; i++) {
			p.sendMessage(" ");
		}
		p.sendMessage("§7§kpasdojasdölfhjasdolöfhjasdlöfjkasjdflöhjaasdfasd");
		p.sendMessage(" ");
		p.sendMessage("  §6Herzlich Willkommen §b" + p.getName());
		p.sendMessage(" ");
		p.sendMessage("  §6Es sind §b" + Bukkit.getServer().getOnlinePlayers().size() + " §6Spieler Online");
		p.sendMessage(" ");
		p.sendMessage("§7§kpasdojasdölfhjasdolöfhjasdlöfjkasjdflöhjaasdfasd");
		p.sendMessage(" ");
		if (p.hasPlayedBefore()) {
			e.setJoinMessage(null);
			p.getInventory().setItem(1, teleitem);
		} else {
			e.setJoinMessage("§aHerzlich Willkommen " + p.getName());
			p.getInventory().setItem(1, teleitem);
		}
	}

}
