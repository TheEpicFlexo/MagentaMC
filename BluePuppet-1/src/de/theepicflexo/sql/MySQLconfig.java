package de.theepicflexo.sql;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MySQLconfig {
	public void setStandart() {
		FileConfiguration cfg = getFileConfiguration();
		cfg.options().copyDefaults(true);
		
		cfg.addDefault("host", "host");
		cfg.addDefault("database", "lobby");
		cfg.addDefault("username", "root");
		cfg.addDefault("password", "password");
		
		
		try {
			cfg.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getFile() {
		return new File("plugins/Lobby/MySQL", "config.yml");
	}

	private FileConfiguration getFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getFile());
	}
	public void readData() {
		FileConfiguration cfg = getFileConfiguration();
		MySQL.host = cfg.getString("host");
		MySQL.database = cfg.getString("database");
		MySQL.user = cfg.getString("username");
		MySQL.password = cfg.getString("password");

	
	}
	
	

}
