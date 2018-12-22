package de.theepicflexo.listener;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.theepicflexo.main.Main;

public class EPInteract implements Listener {
	HashMap<Player, EnderPearl> enderpearls = new HashMap<>();

	@EventHandler
	public void onEnderPearl(PlayerInteractEvent e) {
		ItemStack EPitem = new ItemStack(Material.ENDER_PEARL);
		ItemMeta EPmeta = EPitem.getItemMeta();
		EPmeta.setDisplayName("§5Enderperle");
		EPitem.setItemMeta(EPmeta);
		
		ItemStack fwitem = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta fwmeta = fwitem.getItemMeta();
		fwmeta.setDisplayName("§7Enderpearl");
		fwitem.setItemMeta(fwmeta);

		Player p = e.getPlayer();
		if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getGameMode().equals(GameMode.ADVENTURE)) {
				if (e.getItem().getType().equals(Material.ENDER_PEARL)) {
					p.getInventory().setItem(2, fwitem);
					EnderPearl enderpearl = p.launchProjectile(EnderPearl.class);
					enderpearl.setPassenger(p);
					enderpearls.put(p, enderpearl);

					Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {

						@Override
						public void run() {
							p.getInventory().setItem(2, EPitem);
							p.updateInventory();
						}
					}, 20 * 5);

					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
		}
	}

	@EventHandler
	public void onVehicle(VehicleExitEvent e) {
		if (e.getExited() instanceof Player) {
			if (enderpearls.containsKey(e.getExited())) {
				enderpearls.get(e.getExited()).remove();
			}
		}
	}

}
