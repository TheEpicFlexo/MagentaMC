package de.theepicflexo.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		e.setCancelled(true);
	}
}
