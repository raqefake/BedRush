package me.thorben653.Game;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import BedRush.ragemc.workspace.effects.random.EffectSheduler;
import BedRush.thorben653.ItemDropper.Ticker;
import BedRush.thorben653.main.BR;
import me.thorben653.methods.Messages;
import me.thorben653.methods.StatsAPI;
import me.thorben653.methods.TeamLogic;
import net.minecraft.server.v1_8_R3.Scoreboard;

public class startGame {
	public static void start(){
		
		//Setzte übrige Player in Teams
		 for(Player all : Bukkit.getOnlinePlayers()){
			 if(!TeamLogic.Blue.contains(all)){
				 if(!TeamLogic.Red.contains(all)){
					 all.sendMessage(Messages.noTeam);
				 TeamLogic.rndTeam(all);
				 }
			 }
			 
			 //Adde allen ein Runde in Stats 
			 StatsAPI.addRoundPlayed(all);
			 
		 }

		 for(Player all : Bukkit.getOnlinePlayers()){
			//Message
		     all.sendMessage(Messages.gameStart);
		 
		    //GameRound
		    respawn.first(all);
		 }
		 
		 //Starte ItemSpawner
		 Ticker.startItemDropper();
		 
		 
		 //Gib interacts Frei!
		 BR.hasStarted = true;
		 
		 //Sende Scoreboard
		 Bukkit.getScheduler().runTaskLater(BR.instance, new Runnable() {
			
			@Override
			public void run() {
				 BR.gameScoreboard.sendBoard();		
			}
		}, 80);
		 
		 //Aktiviere Random Reffect Sheduler
		 EffectSheduler.Start();
	}
}
