package me.thorben653.methods;

import javax.security.auth.Destroyable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Bed;

import com.avaje.ebeaninternal.server.type.BeanToDbMap;

import BedRush.thorben653.main.BR;
import net.minecraft.server.v1_8_R3.BlockBed;

public class BedAPI implements Listener {
	
	public static boolean existBlueBed;
	public static boolean existRedBed;
	
	
	//  *******************************
	//  *   Don't Forget to register  *
	//  *   listeners in Main class!  *
	//  *******************************
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		
		
		if(e.getBlock().getType() == Material.BED_BLOCK){
			e.setCancelled(true);
			
			Bed b = (Bed) e.getBlock().getState().getData();
			if(b.isHeadOfBed()){
				Location BedTile = e.getBlock().getLocation().add(b.getFacing().getOppositeFace().getModX(), 0, b.getFacing().getOppositeFace().getModZ());
				
				bedBreak(e.getBlock(), e.getPlayer(), e, BedTile);
			}else{
				Location BedTile = e.getBlock().getLocation().add(b.getFacing().getModX(), 0, b.getFacing().getModZ());


				
				//BedTile ist der Body
				bedBreak(BedTile.getBlock(), e.getPlayer(), e, BedTile);
			}
		}
	}
	
	public static void bedBreak(Block BedBody, Player destoyer, BlockBreakEvent e, Location otherTile){
		World bw = Bukkit.getWorld(BR.lcfg.getString("Bedbody.blue.world"));
		double bx = BR.lcfg.getDouble("Bedbody.blue.x");
		double by = BR.lcfg.getDouble("Bedbody.blue.y");
		double bz = BR.lcfg.getDouble("Bedbody.blue.z");
		Location bluebed = new Location(bw,bx,by,bz); 
		
		World rw = Bukkit.getWorld(BR.lcfg.getString("Bedbody.red.world"));
		double rx = BR.lcfg.getDouble("Bedbody.red.x");
		double ry = BR.lcfg.getDouble("Bedbody.red.y");
		double rz = BR.lcfg.getDouble("Bedbody.red.z");
		Location redbed = new Location(rw,rx,ry,rz); 
		
		if(BedBody.getLocation().distance(redbed) <= 1){
			if(TeamLogic.Red.contains(destoyer)){
				destoyer.sendMessage(Messages.ownBed);
				return;
			}
			//Rotes Bet ist abgebaut
			Bukkit.broadcastMessage(Messages.destroyBed.replace("%team%", "§cRot").replaceAll("%player%", destoyer.getName()));
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.WITHER_DEATH, 1, 1);
			}
			existRedBed = false;
			
			//Remove Bed
			if(((Bed)e.getBlock().getState().getData()).isHeadOfBed()){
			otherTile.getBlock().setType(Material.AIR);
			e.getBlock().setType(Material.AIR);
			}else{
				e.getBlock().setType(Material.AIR);
				otherTile.getBlock().setType(Material.AIR);
			}
			
			//Update Scoreboard
			BR.gameScoreboard.sendBoard();
			
			
		}else if(BedBody.getLocation().distance(bluebed) <= 1){
			if(TeamLogic.Blue.contains(destoyer)){
				destoyer.sendMessage(Messages.ownBed);
				return;
			}
			//Blaues Bet ist abgebaut
			Bukkit.broadcastMessage(Messages.destroyBed.replace("%team%", "§bBlau").replaceAll("%player%", destoyer.getName()));
			for(Player all : Bukkit.getOnlinePlayers()){
				all.playSound(all.getLocation(), Sound.WITHER_DEATH, 1, 1);
			}
			existBlueBed = false;
			
			//Remove Bed
			if(((Bed)e.getBlock().getState().getData()).isHeadOfBed()){
			otherTile.getBlock().setType(Material.AIR);
			e.getBlock().setType(Material.AIR);
			}else{
				e.getBlock().setType(Material.AIR);
				otherTile.getBlock().setType(Material.AIR);
			}
			
			//Update Scoreboard
			BR.gameScoreboard.sendBoard();
			
		}else{
			destoyer.sendMessage("Nope :P Du darfst keine Betten von dem Land äthiopien abrupfen!");
		}
	}
}
