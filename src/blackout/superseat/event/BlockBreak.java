package blackout.superseat.event;

import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

import blackout.superseat.main.Main;
import blackout.superseat.utils.Config;
import blackout.superseat.utils.SPlayer;
import blackout.superseat.utils.Seat;
import blackout.superseat.utils.Utils;

public class BlockBreak {
	
	/**
	 * Execute action when breaking a block
	 * 
	 * If the player is holding the seat wand,
	 * we change the seat rotation by 45°
	 * and save it in the file and set it as the
	 * new player default seat rotation
	 * 
	 * If we broke a seat block the seat is destroyed
	 * and removed from the save file to prevent
	 * unreachable seat placed on air
	 * @param event
	 */
	public void execute(BlockBreakEvent event) {
		Player p = event.getPlayer();
		Block b = event.getBlock();
		
		if (Utils.isWand(event.getPlayer().getInventory())) {
			event.setCancelled(true);
			if (Utils.isSeat(b.getLocation())) {
				Seat s = Utils.getSeat(b.getLocation());
				SPlayer sp = SPlayer.getSPlayer(p);
				s.setRotation(s.getRotation() + 45);
				if (s.getRotation() >= 360)
					s.setRotation(0);
				sp.setRotation(s.getRotation());
				Config.saveSeat(s);
				p.sendMessage("§bSeat rotation set to "+s.getRotation()+"°");
			}
		}
		
		if (Utils.isSeat(b.getLocation()) && !event.isCancelled()) {
			Seat s = Utils.getSeat(b.getLocation());
			Main.seats.remove(s);
			Config.deleteSeat(s);
			p.sendMessage("§cBlock "+b.getType()+" is no longer a seat");
			Utils.spanwParticleCubeCustom(b, p, Particle.FLAME);
		}
	}
}
