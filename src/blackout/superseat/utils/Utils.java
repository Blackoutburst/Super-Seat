package blackout.superseat.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import blackout.superseat.main.Main;

public class Utils {
	
	/**
	 * Spawn a cube of particle on a specified location
	 * @param b
	 * @param p
	 * @param part
	 */
	public static void spanwParticleCubeCustom(Block b, Player p, Particle part) {
		final float nb = 0.2f;
		double x = b.getX();
		double y = b.getY();
		double z = b.getZ();
		
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x + i, y, z, 0, 0, 0, 0, null);
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y + i, z, 0, 0, 0, 0, null);
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y, z + i, 0, 0, 0, 0, null);
		
		x = b.getX() + 1;
		y = b.getY() + 1;
		z = b.getZ() + 1;
		
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x - i, y, z, 0, 0, 0, 0, null);
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y - i, z, 0, 0, 0, 0, null);
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y, z - i, 0, 0, 0, 0, null);
		
		x = b.getX() + 1;
		y = b.getY() + 1;
		z = b.getZ();
		
		for (float i = 0; i < 1; i += 0.2f)
			p.spawnParticle(part, x - i, y, z, 0, 0, 0, 0, null);
		for (float i = 0; i < 1; i += 0.2f)
			p.spawnParticle(part, x, y - i, z, 0, 0, 0, 0, null);
		
		x = b.getX() + 1;
		y = b.getY();
		z = b.getZ() + 1;
		
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x - i, y, z, 0, 0, 0, 0, null);
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y, z - 1, 0, 0, 0, 0, null);
		
		x = b.getX();
		y = b.getY() + 1;
		z = b.getZ() + 1;
		
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y - i, z, 0, 0, 0, 0, null);
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y, z - 1, 0, 0, 0, 0, null);
		
		x = b.getX() + 1;
		y = b.getY();
		z = b.getZ();
		
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y, z + i, 0, 0, 0, 0, null);
		
		x = b.getX();
		y = b.getY() + 1;
		z = b.getZ();
		
		for (float i = 0; i < 1; i += nb)
			p.spawnParticle(part, x, y, z + i, 0, 0, 0, 0, null);
	}
	
	/**
	 * Spawn a cube of particle on every seat
	 * if the seat wand is held by a player and
	 * the player is within a distance x determined by
	 * the configuration file
	 * @param p
	 */
	public static void spanwParticleCube(Player p) {
		for (Seat s : Main.seats) {
			
			if (Math.sqrt(Math.pow(s.getLocation().getX() - p.getLocation().getX(), 2) + 
				Math.pow(s.getLocation().getY() - p.getLocation().getY(), 2) + 
				Math.pow(s.getLocation().getZ() - p.getLocation().getZ(), 2)) > Config.particleRenderDistance)
				continue;
			
			
			final Particle part = Particle.CRIT;
			final float nb = 0.2f;
			double x = s.getLocation().getX();
			double y = s.getLocation().getY();
			double z = s.getLocation().getZ();
			
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x + i, y, z, 0, 0, 0, 0, null);
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y + i, z, 0, 0, 0, 0, null);
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y, z + i, 0, 0, 0, 0, null);
			
			x = s.getLocation().getX() + 1;
			y = s.getLocation().getY() + 1;
			z = s.getLocation().getZ() + 1;
			
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x - i, y, z, 0, 0, 0, 0, null);
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y - i, z, 0, 0, 0, 0, null);
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y, z - i, 0, 0, 0, 0, null);
			
			x = s.getLocation().getX() + 1;
			y = s.getLocation().getY() + 1;
			z = s.getLocation().getZ();
			
			for (float i = 0; i < 1; i += 0.2f)
				p.spawnParticle(part, x - i, y, z, 0, 0, 0, 0, null);
			for (float i = 0; i < 1; i += 0.2f)
				p.spawnParticle(part, x, y - i, z, 0, 0, 0, 0, null);
			
			x = s.getLocation().getX() + 1;
			y = s.getLocation().getY();
			z = s.getLocation().getZ() + 1;
			
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x - i, y, z, 0, 0, 0, 0, null);
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y, z - 1, 0, 0, 0, 0, null);
			
			x = s.getLocation().getX();
			y = s.getLocation().getY() + 1;
			z = s.getLocation().getZ() + 1;
			
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y - i, z, 0, 0, 0, 0, null);
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y, z - 1, 0, 0, 0, 0, null);
			
			x = s.getLocation().getX() + 1;
			y = s.getLocation().getY();
			z = s.getLocation().getZ();
			
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y, z + i, 0, 0, 0, 0, null);
			
			x = s.getLocation().getX();
			y = s.getLocation().getY() + 1;
			z = s.getLocation().getZ();
			
			for (float i = 0; i < 1; i += nb)
				p.spawnParticle(part, x, y, z + i, 0, 0, 0, 0, null);
			spanwRotationLine(s, p);
		}
	}
	
	/**
	 * Draw a white particle line on seat
	 * to represent the seat orientation
	 * if a player hold the seat wand
	 * @param s
	 * @param p
	 */
	public static void spanwRotationLine(Seat s, Player p) {
		final Particle part = Particle.CRIT_MAGIC;
		final float nb = 0.1f;
		double x = s.getLocation().getX();
		double y = s.getLocation().getY();
		double z = s.getLocation().getZ();
		
		switch ((int)(s.getRotation())) {
			case 0:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x + 0.5f, y + 1, z + i + 0.5f, 0, 0, 0, 0, null);
			break;
			case 45:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x - i + 0.5f, y + 1, z + i + 0.5f, 0, 0, 0, 0, null);
			break;
			case 90:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x - i + 0.5f, y + 1, z + 0.5f, 0, 0, 0, 0, null);
			break;
			case 135:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x - i + 0.5f, y + 1, z - i + 0.5f, 0, 0, 0, 0, null);
			break;
			case 180:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x + 0.5f, y + 1, z - i + 0.5f, 0, 0, 0, 0, null);
			break;
			case 225:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x + i + 0.5f, y + 1, z - i + 0.5f, 0, 0, 0, 0, null);
			break;
			case 270:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x + i + 0.5f, y + 1, z + 0.5f, 0, 0, 0, 0, null);
			break;
			case 315:
				for (float i = 0; i < 0.5f; i += nb)
					p.spawnParticle(part, x + i + 0.5f, y + 1, z + i + 0.5f, 0, 0, 0, 0, null);
			break;
		}
	}
	
	/**
	 * Check is a block is a seat
	 * @param loc
	 * @return
	 */
	public static boolean isSeat(Location loc) {
		for (Seat l : Main.seats) {
			if (l.getLocation().getX() == loc.getX() &&
				l.getLocation().getY() == loc.getY() &&
				l.getLocation().getZ() == loc.getZ()) {
				return (true);
			}
		}
		return (false);
	}
	
	/**
	 * Get a seat from the seat list using his location
	 * @param loc
	 * @return
	 */
	public static Seat getSeat(Location loc) {
		for (Seat l : Main.seats) {
			if (l.getLocation().getX() == loc.getX() &&
				l.getLocation().getY() == loc.getY() &&
				l.getLocation().getZ() == loc.getZ()) {
				return (l);
			}
		}
		return (null);
	}
	
	/**
	 * Check if the player is holding the seat wand
	 * @param inv
	 * @return
	 */
	public static boolean isWand(PlayerInventory inv) {
		ItemStack item = inv.getItemInMainHand();
		
		if (item.getType() == Material.BLAZE_ROD &&
			item.getItemMeta().getDisplayName()
			.equals("§6Seat wand")) {
			return true;
		}
		return false;
	}
}
