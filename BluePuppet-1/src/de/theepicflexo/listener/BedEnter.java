package de.theepicflexo.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class BedEnter implements Listener{

	@EventHandler
	public void onBedEnter(PlayerBedEnterEvent e) {
		e.setCancelled(true);
	}
}
