package blackout.superseat.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.event.entity.EntityDismountEvent;

import blackout.superseat.commands.CommandsManager;
import blackout.superseat.event.BlockBreak;
import blackout.superseat.event.Dismount;
import blackout.superseat.event.Join;
import blackout.superseat.event.Leave;
import blackout.superseat.event.Load;
import blackout.superseat.event.Move;
import blackout.superseat.event.PlayerInteract;
import blackout.superseat.utils.SPlayer;
import blackout.superseat.utils.Seat;

public class Main extends JavaPlugin implements Listener {

	public static List<Seat> seats = new ArrayList<Seat>();
	public static List<SPlayer> sPlayers = new ArrayList<SPlayer>();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		new Load().execute();
	}
	
	@EventHandler
	public void onBlockDamageEvent(BlockBreakEvent event) {
		new BlockBreak().execute(event);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		new PlayerInteract().execute(event);
	}
	
	@EventHandler
	public void onDismountEvent(EntityDismountEvent event) {
		new Dismount().execute(event);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		new Join().execute(event);
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		new Leave().execute(event);
	}
	
	@EventHandler
	public void onMoveEvent(PlayerMoveEvent event) {
		new Move().execute(event);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		new CommandsManager().execute(sender, command, label, args);
		return true;
	}
}
