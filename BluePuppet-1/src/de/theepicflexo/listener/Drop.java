package de.theepicflexo.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Drop implements Listener{

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(p.getGameMode().equals(GameMode.ADVENTURE)) {
			e.setCancelled(true);
		}
	}
}
