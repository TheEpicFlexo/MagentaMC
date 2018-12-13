package de.theepicflexo.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.theepicflexo.main.Main;

public class ProjectileLaunch implements Listener {

	@EventHandler
	public void onThrow(ProjectileLaunchEvent e) {
		if (e.getEntity() instanceof EnderPearl) {

			ItemStack EnderPearl = new ItemStack(Material.ENDER_PEARL);
			final ItemMeta EnderPearlMeta = EnderPearl.getItemMeta();
			EnderPearlMeta.setDisplayName("§6§lEnderperle");
			EnderPearl.setItemMeta(EnderPearlMeta);

			Player p = (Player) e.getEntity().getShooter();

			Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {

				@Override
				public void run() {
					if (e.getEntity().getShooter() instanceof Player) {

						p.getInventory().setItem(2, EnderPearl);
					}

				}
			}, 20 * 3);
		}

	}
}
