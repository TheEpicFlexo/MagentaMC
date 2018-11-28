package de.theepicflexo.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {

		Bukkit.getConsoleSender().sendMessage(">>");
		Bukkit.getConsoleSender().sendMessage("§8[BluePuppet] Aktiviert!");
		Bukkit.getConsoleSender().sendMessage(">>");
	}
}
