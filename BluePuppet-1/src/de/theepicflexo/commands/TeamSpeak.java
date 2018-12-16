package de.theepicflexo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamSpeak implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ts") || cmd.getName().equalsIgnoreCase("teamspeak")) {
			Player p = (Player) sender;
			p.sendMessage(" ");
			p.sendMessage("§7TeamSpeak:");
			p.sendMessage("§7MagentaMC.de");
			p.sendMessage(" ");
		}
		return true;
	}

}
