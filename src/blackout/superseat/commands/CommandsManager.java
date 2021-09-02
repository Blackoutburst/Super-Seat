package blackout.superseat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandsManager {
	
	/**
	 * The command manager
	 * Execute the right command using
	 * the command name or alias
	 * @param sender
	 * @param command
	 * @param label
	 * @param args
	 */
	public void execute(CommandSender sender, Command command, String label, String[] args) {
		switch(label) {
			case "superseat:seatwand": case "seatwand": new CommandSeatWand().run(sender); break;
			case "superseat:reload": case "reload": new CommandReload().run(sender); break;
			default: break;
		}
	}
}
