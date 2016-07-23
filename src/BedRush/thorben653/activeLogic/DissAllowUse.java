package BedRush.thorben653.activeLogic;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import BedRush.thorben653.main.BR;
import me.thorben653.methods.TeamLogic;

public class DissAllowUse {
	
	public static void onInteract(PlayerInteractEvent e){
		if( e.getPlayer().getGameMode() == GameMode.CREATIVE)return;
		if(BR.hasStarted == false || BR.hasEnded == true){
			e.setCancelled(true);
		}
		
		if(e.getItem() == null)return;
		
		if(e.getItem().equals(TeamLogic.getItem())){
			TeamLogic.openmenu(e.getPlayer());
		}
	}
	
	public static void onDrop(PlayerDropItemEvent e){
		if(BR.hasStarted == false || BR.hasEnded == true){
			e.setCancelled(true);
		}
	}
	
	public static void onInventory(InventoryClickEvent e){
		try{
		if(BR.hasStarted == false || BR.hasEnded == true){
			if(e.getWhoClicked().getGameMode() == GameMode.CREATIVE)return;
			e.setCancelled(true);
		}
		if(e.getCurrentItem().getType() == Material.LEATHER_HELMET)e.setCancelled(true);
		}catch(NullPointerException ex){
			return;
		}
	}
	
	public static void onHangingBreak(HangingBreakByEntityEvent e){
		e.setCancelled(true);
	}
	
	public static void onVehicleBreak(VehicleDestroyEvent e){
		e.setCancelled(true);
	}
	
	
	
}
