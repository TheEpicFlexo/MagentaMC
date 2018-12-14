package de.theepicflexo.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.theepicflexo.util.Fill;

public class InventoryClick implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if (p.getGameMode().equals(GameMode.ADVENTURE)) {
				if (e.getCurrentItem().hasItemMeta()) {

					if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Teleporter")) {
						Fill.fillCompass(p);
						e.setCancelled(true);
					} else {
						e.setCancelled(true);
					}
				} else {
					e.setCancelled(false);
				}
			} else {
				e.setCancelled(false);
			}
		}
		e.setCancelled(true);
	}
}