package blackout.superseat.utils;

import java.util.UUID;

import org.bukkit.Location;

public class Seat {
	protected UUID uuid;
	protected Location location;
	protected float rotation;
	
	public Seat(UUID uuid, Location location, float rotation) {
		this.uuid = uuid;
		this.location = location;
		this.rotation = rotation;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public UUID getUUID() {
		return uuid;
	}
	
}
