package de.theepicflexo.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Fill {

	public static void fillCompass(Player p) {

		Inventory teleporter = Bukkit.createInventory(null, 9 * 5, "§8Teleporter");

		// CreateItem
		ItemStack beditem = new ItemStack(Material.BED);
		ItemMeta bedmeta = beditem.getItemMeta();
		bedmeta.setDisplayName("§c§lBed§7§lWars");
		beditem.setItemMeta(bedmeta);
		
		ItemStack spawnitem = new ItemStack(Material.DIAMOND);
		ItemMeta spawnmeta = spawnitem.getItemMeta();
		spawnmeta.setDisplayName("§a§lSpawn");
		spawnitem.setItemMeta(spawnmeta);

		ItemStack comingsoonitem = new ItemStack(Material.BARRIER);
		ItemMeta comingsoonmeta = comingsoonitem.getItemMeta();
		comingsoonmeta.setDisplayName("§cComing Soon");
		comingsoonitem.setItemMeta(comingsoonmeta);

		// SetItem
		teleporter.setItem(22, spawnitem);
		teleporter.setItem(4, comingsoonitem);
		teleporter.setItem(10, comingsoonitem);
		teleporter.setItem(16, comingsoonitem);
		teleporter.setItem(28, comingsoonitem);
		teleporter.setItem(34, comingsoonitem);
		teleporter.setItem(40, comingsoonitem);



		for (int i = 0; i < teleporter.getSize(); i++) {
			if (teleporter.getItem(i) == null) {
				ItemStack glassitem = new ItemStack(Material.STAINED_GLASS_PANE);
				ItemMeta glassmeta = glassitem.getItemMeta();
				glassmeta.addEnchant(Enchantment.ARROW_FIRE, 0, false);
				glassmeta.setDisplayName("§8");
				glassitem.setItemMeta(glassmeta);
				teleporter.setItem(i, glassitem);
			}
		}

		// openInventory
		p.openInventory(teleporter);
	}
}
