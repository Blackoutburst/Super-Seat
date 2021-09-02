package blackout.superseat.utils;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import blackout.superseat.main.Main;

public class Config {
	
	public static int particleRenderDistance = 20;
	public static float seatHeight = 1.1f;
	
	/**
	 * Create configuration file with default value
	 * 
	 * Load the configuration file if the file already exist
	 * @throws IOException
	 */
	public static void create() throws IOException {
		File configFile = new File("plugins/SuperSeat/config.yml");
		
		if (!configFile.exists()) {
			configFile.createNewFile();
			YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
			
			config.set("particle-render-distance", 20);
			config.set("seat-height", 1.1f);
			config.save(configFile);
		} else {
			load();
		}
	}
	
	/**
	 * Load the configuration file
	 */
	public static void load() {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/SuperSeat/config.yml"));
		
		particleRenderDistance = config.getInt("particle-render-distance");
		seatHeight = (float) config.getDouble("seat-height");
	}
	
	/**
	 * Load every seat into the memory from the save file
	 */
	public static void loadSeats() {
		YamlConfiguration seatsFile = YamlConfiguration.loadConfiguration(new File("plugins/SuperSeat/seats.yml"));
		
		if (seatsFile.getConfigurationSection("seats") == null) return;
		
		Set<String> seat = seatsFile.getConfigurationSection("seats").getKeys(false);
		
		for (String s : seat) {
			UUID uuid = UUID.fromString(s);
			World world = Bukkit.getWorld(seatsFile.getString("seats."+s+".location.world"));
			double x = seatsFile.getDouble("seats."+s+".location.x");
			double y = seatsFile.getDouble("seats."+s+".location.y");
			double z = seatsFile.getDouble("seats."+s+".location.z");
			float rotation = (float)(seatsFile.getDouble("seats."+s+".rotation"));
			
			Location loc = new Location(world, x, y, z);
			
			Main.seats.add(new Seat(uuid, loc, rotation));
		}
		
	}
	
	/**
	 * Save a seat in the save file
	 * @param s
	 */
	public static void saveSeat(Seat s) {
		YamlConfiguration seatsFile = YamlConfiguration.loadConfiguration(new File("plugins/SuperSeat/seats.yml"));
		
		seatsFile.set("seats."+s.getUUID().toString()+".location.world", s.getLocation().getWorld().getName());
		seatsFile.set("seats."+s.getUUID().toString()+".location.x", s.getLocation().getX());
		seatsFile.set("seats."+s.getUUID().toString()+".location.y", s.getLocation().getBlockY());
		seatsFile.set("seats."+s.getUUID().toString()+".location.z", s.getLocation().getBlockZ());
		seatsFile.set("seats."+s.getUUID().toString()+".rotation", s.getRotation());
		
		try {
			seatsFile.save(new File("plugins/SuperSeat/seats.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delete a seat from the save file
	 * @param s
	 */
	public static void deleteSeat(Seat s) {
		YamlConfiguration seatsFile = YamlConfiguration.loadConfiguration(new File("plugins/SuperSeat/seats.yml"));
		
		seatsFile.set("seats."+s.getUUID().toString(), null);
		
		try {
			seatsFile.save(new File("plugins/SuperSeat/seats.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
