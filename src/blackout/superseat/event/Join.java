package blackout.superseat.event;

import org.bukkit.event.player.PlayerJoinEvent;

import blackout.superseat.main.Main;
import blackout.superseat.utils.SPlayer;

public class Join {
	
	/**
	 * Add the player to our player list
	 * @param event
	 */
	public void execute(PlayerJoinEvent event) {
		Main.sPlayers.add(new SPlayer(event.getPlayer()));
	}
}
