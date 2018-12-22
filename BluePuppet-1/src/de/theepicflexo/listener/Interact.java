package de.theepicflexo.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import de.theepicflexo.util.Fill;

public class Interact implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getGameMode().equals(GameMode.ADVENTURE)) {
				if (e.getItem() != null) {
					if(e.getItem().hasItemMeta()) {
						if (e.getItem().getItemMeta().getDisplayName().equals("§7§lTeleporter")) {
							Fill.fillCompass(p);
							e.setCancelled(true);
						} else if (e.getItem().getItemMeta().getDisplayName().equals("§5§lGadgets")) {
							if(p.hasPermission("server.debug")) {
								Fill.fillGadgets(p);
								e.setCancelled(true);
							} else {
								p.sendMessage("§cComing Soon");
							}
							
						} else if(e.getItem().getType().equals(Material.ENDER_PEARL)) {
							e.setCancelled(true);
						}
					} else {
						e.setCancelled(true);
					}
					
				} else {
					e.setCancelled(false);
				}

			} else if (p.getGameMode().equals(GameMode.CREATIVE)) {
				e.setCancelled(false);
			}
		}

	}

}
