package blackout.superseat.commands;

import org.bukkit.command.CommandSender;

import blackout.superseat.utils.Config;

public class CommandReload {
	
	/**
	 * Execute the command /reload
	 * @param sender
	 */
	public void run(CommandSender sender) {
		Config.load();
		sender.sendMessage("§bSuper seat configuration reloaded");
	}
}
