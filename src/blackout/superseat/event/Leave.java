package blackout.superseat.event;

import org.bukkit.event.player.PlayerQuitEvent;

import blackout.superseat.main.Main;
import blackout.superseat.utils.SPlayer;

public class Leave {
	
	/**
	 * Remove the player from our player list
	 * @param event
	 */
	public void execute(PlayerQuitEvent event) {
		SPlayer sp = SPlayer.getSPlayer(event.getPlayer());
		Main.sPlayers.remove(sp);
	}
}
