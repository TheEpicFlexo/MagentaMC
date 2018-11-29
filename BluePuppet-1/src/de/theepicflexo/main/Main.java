package de.theepicflexo.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.theepicflexo.sql.MySQL;
import de.theepicflexo.sql.MySQLconfig;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		MySQLconfig file = new MySQLconfig();
		file.setStandart();
		file.readData();
		
		MySQL.connect();
//		MySQL.update("CREATE TABLE IF NOT EXISTS lobby (UUID VARCHAR)");
		
		Bukkit.getConsoleSender().sendMessage(">>");
		Bukkit.getConsoleSender().sendMessage("§8[BluePuppet] §aLobby wurde Aktiviert!");
		Bukkit.getConsoleSender().sendMessage(">>");
	}
	
	@Override
	public void onDisable() {
		MySQL.disconnect();
	}
}