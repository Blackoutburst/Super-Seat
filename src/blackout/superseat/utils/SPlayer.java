package blackout.superseat.utils;

import org.bukkit.entity.Player;

import blackout.superseat.main.Main;

public class SPlayer {
	protected boolean schedulerActive;
	protected Player player;
	protected float rotation;
	
	public SPlayer(Player player) {
		this.schedulerActive = false;
		this.player = player;
	}
	
	public static SPlayer getSPlayer(Player p) {
		for (SPlayer sp : Main.sPlayers)
			if (p == sp.player)
				return (sp);
		return (null);
	}

	public boolean isSchedulerActive() {
		return schedulerActive;
	}

	public void setSchedulerActive(boolean schedulerActive) {
		this.schedulerActive = schedulerActive;
	}

	public Player getPlayer() {
		return player;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
