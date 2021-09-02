package blackout.superseat.event;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import blackout.superseat.main.Main;
import blackout.superseat.utils.Config;
import blackout.superseat.utils.SPlayer;
import blackout.superseat.utils.Seat;
import blackout.superseat.utils.Utils;

public class PlayerInteract {
	
	/**
	 * Check if we are right clicking a block
	 * using the seat wand or not
	 * 
	 * Right clicking using the seat wand will create or
	 * destroy a seat while right clicking a block
	 * defined as a seat without the wand will make
	 * the player ride the seat
	 * @param event
	 */
	public void execute(PlayerInteractEvent event) {
		if (Utils.isWand(event.getPlayer().getInventory()) &&
			event.getHand() == EquipmentSlot.HAND &&
			event.getAction() == Action.RIGHT_CLICK_BLOCK)
			setSeat(event);
		
		if (!Utils.isWand(event.getPlayer().getInventory()) &&
			event.getHand() == EquipmentSlot.HAND && 
			event.getAction() == Action.RIGHT_CLICK_BLOCK)
			sit(event);
	}
	
	/**
	 * Create a seat from the block clicked using the
	 * seat wand, if a seat is already defined on this block
	 * the seat will be destroyed instead
	 * @param event
	 */
	private void setSeat(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Block b = event.getClickedBlock();
		
		if (b == null) return;
		
		if (!Utils.isSeat(b.getLocation())) {
			SPlayer sp = SPlayer.getSPlayer(p);
			Seat s = new Seat(UUID.randomUUID(), b.getLocation(), sp.getRotation());
			Main.seats.add(s);
			Config.saveSeat(s);
			Utils.spanwParticleCubeCustom(b, p, Particle.VILLAGER_HAPPY);
			p.sendMessage("§aBlock "+b.getType()+" is now a seat");
		} else {
			Seat s = Utils.getSeat(b.getLocation());
			Main.seats.remove(s);
			Config.deleteSeat(s);
			Utils.spanwParticleCubeCustom(b, p, Particle.FLAME);
			p.sendMessage("§cBlock "+b.getType()+" is no longer a seat");
		}
		event.setCancelled(true);
	}
	
	/**
	 * When clicking a seat
	 * 
	 * Summon an invisible armor stand with a custom name
	 * for future deletion,
	 * 
	 * This armor stand is then teleported to the right angle
	 * and the player who clicked this seat will ride the armor stand
	 * to make him sit
	 * @param event
	 */
	private void sit(PlayerInteractEvent event) {
		if (event.getPlayer().isInsideVehicle()) return;

		Block b = event.getClickedBlock();
		
		if (b == null) return;
		if (Utils.isSeat(b.getLocation())) {
			Seat s = Utils.getSeat(b.getLocation());
			Location seatLoc = s.getLocation().clone();
			
			seatLoc.setX(seatLoc.getX() + 0.5f);
			seatLoc.setY(seatLoc.getY() - Config.seatHeight);
			seatLoc.setZ(seatLoc.getZ() + 0.5f);
			
			ArmorStand a = event.getPlayer().getWorld()
			.spawn(new Location(event.getPlayer().getWorld(), seatLoc.getX(), seatLoc.getY(), seatLoc.getZ(), s.getRotation(), 0), ArmorStand.class);   
			a.setCustomName("§7seat");
			a.setCustomNameVisible(false);
			a.setGravity(false);
			a.setVisible(false);
			a.addPassenger(event.getPlayer());
		}
	}
}
