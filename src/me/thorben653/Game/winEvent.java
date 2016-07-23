package me.thorben653.Game;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import BedRush.ragemc.workspace.effects.random.EffectSheduler;
import BedRush.thorben653.main.BR;
import me.thorben653.methods.Messages;
import me.thorben653.methods.TeamLogic;
import me.thorben653.methods.Teleports;
import me.thorben653.methods.firework;

public class winEvent {
	
	
	public static String winner;
    static Color color;
	
	
	public static void CheckFor(){
		
		
		if(TeamLogic.Red.size() <= 0){
			winner = "§cRot";
			color = Color.RED;
			
			for(Player all : TeamLogic.Red){
				firework.random(all);
			}
		}else if (TeamLogic.Blue.size() <=0){
			winner = "§bBlau";
			color = Color.BLUE;
			
			for(Player all : TeamLogic.Blue){
				firework.random(all);
			}
		}else{
			return;
		}
		
		Bukkit.broadcastMessage("§a§k==================================");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(Messages.winTeam.replace("%team%", winner));
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage("§a§k==================================");
		
		
		
		
		for(final Player all: Bukkit.getOnlinePlayers())
		{
			Teleports.Lobby(all);
			all.getInventory().clear();
			Bukkit.getScheduler().runTaskLater(BR.instance, new Runnable() {
				
				@Override
				public void run() {
					Firework firework = all.getWorld().spawn(all.getLocation(), Firework.class);
					FireworkEffect fireworkEffect = FireworkEffect.builder()
							.withColor(color)
							.flicker(true)
							.trail(true)
						    .withFade(Color.GREEN)
						    .with(FireworkEffect.Type.CREEPER)
						    .build();
					
					FireworkMeta meta = firework.getFireworkMeta();
					meta.addEffect(fireworkEffect);
					meta.setPower(3);
					all.playSound(all.getLocation(), Sound.FIREWORK_BLAST2, 1, 1);			
				}
			}, 20);		
		}
		
		
		EffectSheduler.Stop();
		BR.hasEnded = true;
		
		
		
		//Update Scoreboard
		BR.gameScoreboard.sendBoard();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.sendMessage(Messages.serverStop.replace("%time%", "15"));
				}
				
			}
		}, 20 * 5);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.sendMessage(Messages.serverStop.replace("%time%", "10"));
				}
				
			}
		}, 20 * 10);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.sendMessage(Messages.serverStop.replace("%time%", "5"));
				}
				
			}
		}, 20 * 15);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.sendMessage(Messages.serverStop.replace("%time%", "3"));
				}
				
			}
		}, 20 * 17);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.sendMessage(Messages.serverStop.replace("%time%", "2"));
				}
				
			}
		}, 20 * 18);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.sendMessage(Messages.serverStop.replace("%time%", "1"));
				}
				
			}
		}, 20 * 19);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(BR.instance, new Runnable(){
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					all.kickPlayer("§cServer ist Restarting!");
				}
				
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
				
			}
		}, 20 * 20);
		
		
		
		
	}

}
