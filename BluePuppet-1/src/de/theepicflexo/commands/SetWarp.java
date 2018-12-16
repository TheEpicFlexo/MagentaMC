package de.theepicflexo.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;

public class SetWarp implements CommandExecutor {
	FileConfiguration cfg = getFileConfiguration();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("setwarp")) {
			if (p.hasPermission("server.setwarp")) {
				if (args.length > 0) {
					int x = p.getLocation().getBlockX();
					int y = p.getLocation().getBlockY();
					int z = p.getLocation().getBlockZ();
					float yaw = p.getLocation().getYaw();
					float pitch = p.getLocation().getPitch();

					try {
						cfg.save(getFile());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (args[0].equalsIgnoreCase("spawn")) {
						cfg.set("spawn.use", true);
						cfg.set("spawn.x", x);
						cfg.set("spawn.y", y);
						cfg.set("spawn.z", z);
						cfg.set("spawn.yaw", yaw);
						cfg.set("spawn.pitch", pitch);
						try {
							cfg.save(getFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						p.sendMessage("§8[§bLobby§8] §aSpawn erfolgreich gesetzt!");
					} else if (args[0].equalsIgnoreCase("bedwars")) {
						cfg.set("bw.use", true);
						cfg.set("bw.x", x);
						cfg.set("bw.y", y);
						cfg.set("bw.z", z);
						cfg.set("bw.yaw", yaw);
						cfg.set("bw.pitch", pitch);
						try {
							cfg.save(getFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						p.sendMessage("§8[§bLobby§8] §aBedWars erfolgreich gesetzt!");
					} else if (args[0].equalsIgnoreCase("KnockIt")) {
						cfg.set("knockit.use", true);
						cfg.set("knockit.x", x);
						cfg.set("knockit.y", y);
						cfg.set("knockit.z", z);
						cfg.set("knockit.yaw", yaw);
						cfg.set("knockit.pitch", pitch);
						try {
							cfg.save(getFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						p.sendMessage("§8[§bLobby§8] §aKnockIt erfolgreich gesetzt!");
					} else if (args[0].equalsIgnoreCase("Citybuild")) {
						cfg.set("cb.use", true);
						cfg.set("cb.x", x);
						cfg.set("cb.y", y);
						cfg.set("cb.z", z);
						cfg.set("cb.yaw", yaw);
						cfg.set("cb.pitch", pitch);
						try {
							cfg.save(getFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						p.sendMessage("§8[§bLobby§8] §aCityBuild erfolgreich gesetzt!");
					} else if (args[0].equalsIgnoreCase("Skywars")) {
						cfg.set("sw.use", true);
						cfg.set("sw.x", x);
						cfg.set("sw.y", y);
						cfg.set("sw.z", z);
						cfg.set("sw.yaw", yaw);
						cfg.set("sw.pitch", pitch);
						try {
							cfg.save(getFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						p.sendMessage("§8[§bLobby§8] §aSkyWars erfolgreich gesetzt!");
					} else {
						p.sendMessage("§4ERROR");
					}

				} else {
					p.sendMessage("§8[§bLobby§8] §cNutze /setwarp <warp>");
				}

			} else {
				p.sendMessage("§8[§bLobby§8] §cDas darfst du nicht!");
			}
			de.theepicflexo.main.Main.setInt();
			de.theepicflexo.main.Main.plugin.onEnable();
		}
		return false;
	}

	private static File getFile() {
		return new File("plugins/Lobby/Warp", "config.yml");
	}

	public static FileConfiguration getFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getFile());
	}

}
