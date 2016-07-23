package BedRush.thorben653.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.world.WorldSaveEvent;

import BedRush.ragemc.workspace.map.Map;
import BedRush.thorben653.activeLogic.BuildEv;
import BedRush.thorben653.activeLogic.DamageEv;
import BedRush.thorben653.activeLogic.DissAllowUse;
import BedRush.thorben653.activeLogic.JoinEv;
import BedRush.thorben653.activeLogic.PingEv;
import BedRush.thorben653.activeLogic.QuitEv;

public class BukkitListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		BuildEv.Break(e);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		BuildEv.Place(e);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		DamageEv.damage(e);
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e){
		DamageEv.damagebyEntity(e);
	}
	
	@EventHandler
	public void onQuitEvent(PlayerQuitEvent e){
		QuitEv.quit(e);
	}
	
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent e){
		JoinEv.join(e);
	}
	
	@EventHandler
	public void onInteractEvent(PlayerInteractEvent e){
		DissAllowUse.onInteract(e);
	}
	
	@EventHandler
	public void onInteractEvent(PlayerDropItemEvent e){
		DissAllowUse.onDrop(e);
	}
	
	@EventHandler
	public void onHangingBreakEvent(HangingBreakByEntityEvent e){
		DissAllowUse.onHangingBreak(e);
	}
	
	@EventHandler
	public void onVehicleEvent(VehicleDestroyEvent e){
		DissAllowUse.onVehicleBreak(e);
	}
	
	@EventHandler
	public void onInventory(InventoryClickEvent e){
		DissAllowUse.onInventory(e);
	}
	
	@EventHandler
	public void onWorldSave(WorldSaveEvent e){
    System.exit(0);
	}
	@EventHandler
	public void onUpdate(ServerListPingEvent e)
	{
		PingEv.Pingev(e);
	}
}
