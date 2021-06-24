package blackout.superseat.event;

import org.bukkit.entity.ArmorStand;
import org.spigotmc.event.entity.EntityDismountEvent;

public class Dismount {
	
	/**
	 * Remove the ride armor stand
	 * used as a seat when we no longer use them
	 * @param event
	 */
	public void execute(EntityDismountEvent event) {
		if (event.getDismounted() instanceof ArmorStand && 
			event.getEntity().getName().equals("§7seat")) {
			event.getDismounted().remove();
		}
	}
}
