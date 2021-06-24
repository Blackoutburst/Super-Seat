package blackout.superseat.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandSeatWand {
	
	/**
	 * Execute the command /seatwand
	 * @param sender
	 */
	public void run(CommandSender sender) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			giveWand(p);
		}
	}
	
	/**
	 * Give a custom blaze rod the player
	 * This blaze rod will server as a
	 * seat wand, the tool used to create and edit
	 * seats
	 * @param p
	 */
	private void giveWand(Player p) {
		ItemStack stack = new ItemStack(Material.BLAZE_ROD);
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		meta.setDisplayName("§6Seat wand");
		lore.add("§aRight click a block to create a seat");
		lore.add("§bLeft click a block to edit the seat orientation");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		
		p.getInventory().addItem(stack);
	}
}
