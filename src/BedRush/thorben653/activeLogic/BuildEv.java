package BedRush.thorben653.activeLogic;

import java.util.ArrayList;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import BedRush.thorben653.main.BR;

public class BuildEv {
	public static ArrayList<Location> blocks = new ArrayList<Location>();
	
	//BreakBlock
	public static void Break(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE)return;
		if(e.getBlock().getType() == Material.BED_BLOCK)return;
		
		if(BR.hasStarted == false || BR.hasEnded == true){
			e.setCancelled(true);
			return;
		}
		
		if(e.getBlock().getType() == Material.BED_BLOCK)
		{
			blocks.add(e.getBlock().getLocation());
		}
		
		if(blocks.contains(e.getBlock().getLocation())){
			return;
		}
		
		//Setze gecancelled
		e.setCancelled(true);
		e.getPlayer().updateInventory();
	}
	
	//PlaceBlock
	public static void Place(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE)return;
		
		if(BR.hasStarted == false || BR.hasEnded == true){
			e.setCancelled(true);
			return;
		}

			blocks.add(e.getBlock().getLocation());
	}
}
