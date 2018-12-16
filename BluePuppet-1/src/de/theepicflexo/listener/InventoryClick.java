package de.theepicflexo.listener;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.theepicflexo.commands.SetWarp;
import de.theepicflexo.util.Fill;

public class InventoryClick implements Listener {
	FileConfiguration cfg = SetWarp.getFileConfiguration();

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if (p.getGameMode() == GameMode.ADVENTURE) {
				if (e.getCurrentItem().hasItemMeta()) {

					if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Teleporter")) {
						Fill.fillCompass(p);
						e.setCancelled(true);
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lSpawn")) {
						if (cfg.getBoolean("spawn.use")) {

							Location loc = p.getLocation();
							loc.setX(cfg.getDouble("spawn.x"));
							loc.setY(cfg.getDouble("spawn.y"));
							loc.setZ(cfg.getDouble("spawn.z"));
							loc.setPitch(cfg.getInt("spawn.pitch"));
							loc.setYaw(cfg.getInt("spawn.yaw"));
							p.teleport(loc);
							e.setCancelled(true);
						} else {
							p.sendMessage("§8[§4ERROR-404§8] §4Spawn konnte nicht gefunden werden");
							p.sendMessage(
									"§8[§4ERROR-404§8] §4Bitte Kontaktiere §bTheEpicFlexo §4über den TeamSpeak (/ts)");
							e.setCancelled(true);
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4§lBed§r§lWars")) {
						if (cfg.getBoolean("bw.use")) {

							Location loc = p.getLocation();
							loc.setX(cfg.getDouble("bw.x"));
							loc.setY(cfg.getDouble("bw.y"));
							loc.setZ(cfg.getDouble("bw.z"));
							loc.setPitch(cfg.getInt("bw.pitch"));
							loc.setYaw(cfg.getInt("bw.yaw"));
							p.teleport(loc);
							e.setCancelled(true);
						} else {
							p.sendMessage("§8[§4ERROR-404§8] §4BedWars konnte nicht gefunden werden");
							p.sendMessage(
									"§8[§4ERROR-404§8] §4Bitte Kontaktiere §bTheEpicFlexo §4über den TeamSpeak (/ts)");
							e.setCancelled(true);
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKnockIT")) {
						if (cfg.getBoolean("knockit.use")) {

							Location loc = p.getLocation();
							loc.setX(cfg.getDouble("knockit.x"));
							loc.setY(cfg.getDouble("knockit.y"));
							loc.setZ(cfg.getDouble("knockit.z"));
							loc.setPitch(cfg.getInt("knockit.pitch"));
							loc.setYaw(cfg.getInt("knockit.yaw"));
							p.teleport(loc);
							e.setCancelled(true);
						} else {
							p.sendMessage("§8[§4ERROR-404§8] §4KnockIT konnte nicht gefunden werden");
							p.sendMessage(
									"§8[§4ERROR-404§8] §4Bitte Kontaktiere §bTheEpicFlexo §4über den TeamSpeak (/ts)");
							e.setCancelled(true);
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lCityBuild")) {
						if (cfg.getBoolean("cb.use")) {

							Location loc = p.getLocation();
							loc.setX(cfg.getDouble("cb.x"));
							loc.setY(cfg.getDouble("cb.y"));
							loc.setZ(cfg.getDouble("cb.z"));
							loc.setPitch(cfg.getInt("cb.pitch"));
							loc.setYaw(cfg.getInt("cb.yaw"));
							p.teleport(loc);
							e.setCancelled(true);
						} else {
							p.sendMessage("§8[§4ERROR-404§8] §4CityBuild konnte nicht gefunden werden");
							p.sendMessage(
									"§8[§4ERROR-404§8] §4Bitte Kontaktiere §bTheEpicFlexo §4über den TeamSpeak (/ts)");
							e.setCancelled(true);
						}
					} else {
						e.setCancelled(true);
					}
				} else {
					e.setCancelled(false);
				}
			} else {
				e.setCancelled(false);
			}
		} else {
			e.setCancelled(true);
		}
	}
}