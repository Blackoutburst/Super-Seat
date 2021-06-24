package blackout.superseat.event;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import blackout.superseat.main.Main;
import blackout.superseat.utils.SPlayer;
import blackout.superseat.utils.Utils;

public class Move {
	
	/**
	 * Remove potential missed armor stand when anyone move
	 * as if the player never dismount a seat but log off instead
	 * ghost armor stand might remain in the map preventing action
	 * such as placing block due to their presence
	 * 
	 * If we hold the seat wand we start a new scheduler for the player
	 * running every 2 tick to display particle around seat block
	 * @param event
	 */
	public void execute(PlayerMoveEvent event) {
		for (Entity e : event.getPlayer().getWorld().getEntities()) {
			if (e instanceof ArmorStand) {
				if (e.getName().equals("§7seat") && e.getPassengers().size() == 0) {
					e.remove();
				}
			}
		}
		
		if (Utils.isWand(event.getPlayer().getInventory())) {
			SPlayer sp = SPlayer.getSPlayer(event.getPlayer());
			
			if (!sp.isSchedulerActive()) {
				sp.setSchedulerActive(true);
				startTask(sp);
			}
		}
	}
	
	/**
	 * Starting a new scheduler for the player holding
	 * the seat wand, this scheduler is called every 2
	 * game tick to display particle around seat block
	 * 
	 * The scheduler is killed when the player stop holding 
	 * the seat wand
	 * @param sp
	 */
	private void startTask(SPlayer sp) {
		new BukkitRunnable(){
			@Override
			public void run(){
				if (!Utils.isWand(sp.getPlayer().getInventory())) {
					sp.setSchedulerActive(false);
					this.cancel();
				} else {
					Utils.spanwParticleCube(sp.getPlayer());
				}
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 0L, 2L);
	}
}
