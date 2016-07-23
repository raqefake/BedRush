package BedRush.thorben653.LobbySystem;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import BedRush.thorben653.main.BR;
import me.thorben653.Game.startGame;
import me.thorben653.methods.Messages;

public class LobbyLogic {
	public static int secs;
	public static int tick = 0;
	
	public static void start(){
		secs = BR.cfg.getInt("secstoStart");
		
	tick = Bukkit.getScheduler().scheduleSyncRepeatingTask(BR.instance, new Runnable(){
		@Override
		public void run() {
			if(Bukkit.getOnlinePlayers().size() < BR.cfg.getInt("PlayersToStart")){
				if(secs < BR.cfg.getInt("secstoStart")){
				secs = BR.cfg.getInt("secstoStart");
				Bukkit.broadcastMessage(Messages.tofewplayer);
				}
				return;
			}
			
			secs--;
			
			//UpdateScoreboard
			BR.lobbyScoreboard.sendScoreboard();
			
			
			if(secs<=0){
				for(Player all : Bukkit.getOnlinePlayers())all.setLevel(0);
				Bukkit.getScheduler().cancelTask(tick);
				//Game Starts!
				startGame.start();
				
				
				//Kill Scoreboard
				BR.lobbyScoreboard.killBoard();
				BR.inSarting = false;
				return;
			}
			
			for(Player all : Bukkit.getOnlinePlayers()){
				all.setLevel(secs);
				if(secs == 60){
					all.sendMessage(Messages.secs.replace("%secs%", secs + ""));
					all.playSound(all.getLocation(), Sound.CHICKEN_EGG_POP, 1, 2);
				}if(secs == 30){
					all.sendMessage(Messages.secs.replace("%secs%", secs + ""));
					all.playSound(all.getLocation(), Sound.CHICKEN_EGG_POP, 1, 2);
				}if(secs == 15){
					all.sendMessage(Messages.secs.replace("%secs%", secs + ""));
					all.playSound(all.getLocation(), Sound.CHICKEN_EGG_POP, 1, 2);
				}if(secs == 10){
					all.sendMessage(Messages.secs.replace("%secs%", secs + ""));
					all.playSound(all.getLocation(), Sound.CHICKEN_EGG_POP, 1, 2);
				}if(secs == 5){
					all.sendMessage(Messages.secs.replace("%secs%", secs + ""));
					all.playSound(all.getLocation(), Sound.CHICKEN_EGG_POP, 1, 2);
				}if(secs <= 3){
					all.sendMessage(Messages.secs.replace("%secs%", secs + ""));
					all.playSound(all.getLocation(), Sound.CHICKEN_EGG_POP, 1, 2);
				}
			}
		}
	}, 20, 20);	
	}
}
