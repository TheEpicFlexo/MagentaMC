package de.theepicflexo.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.theepicflexo.util.Fill;

public class Click implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			// getItemName
			if (p.getGameMode().equals(GameMode.ADVENTURE)) {
				if (e.getItem() != null) {
					if (e.getItem().hasItemMeta()) {
						if (e.getItem().getItemMeta().getDisplayName().equals("§7§lTeleporter")) {
							Fill.fillCompass(p);
							e.setCancelled(true);
						} else if(e.getItem().getItemMeta().getDisplayName().equals("§5§lGadgets")) {
							Fill.fillGadgets(p);
							e.setCancelled(true);
						} else {
							e.setCancelled(false);

						}
					} else {
						e.setCancelled(false);
					}
				}
			} else if(p.getGameMode().equals(GameMode.CREATIVE)){
				e.setCancelled(false);
			}
		} else {
			e.setCancelled(true);
		}
	}
}
