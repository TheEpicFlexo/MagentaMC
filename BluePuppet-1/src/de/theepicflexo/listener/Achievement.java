package de.theepicflexo.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class Achievement implements Listener{

	@EventHandler
	public void onAchievement(PlayerAchievementAwardedEvent e) {
		e.setCancelled(true);
	}
	
}
