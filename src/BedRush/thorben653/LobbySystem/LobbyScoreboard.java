package BedRush.thorben653.LobbySystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import BedRush.thorben653.main.BR;
import me.thorben653.methods.TimeString;

public class LobbyScoreboard {
	
	
	public LobbyScoreboard(){}
	


	String PREFIX = BR.prefix;
	
	
	public void sendScoreboard()
	{
		//TimeString.fromSecsTominsecsString(ZEIT);
		
		for(Player all: Bukkit.getOnlinePlayers())
		{
			ScoreboardManager sm = Bukkit.getScoreboardManager();
			Scoreboard board = sm.getNewScoreboard();
			Objective obj = board.registerNewObjective("aaa", "bbb");
			
			 obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			 obj.setDisplayName(PREFIX);
			 
			 obj.getScore("§7§l").setScore(0);
			 obj.getScore("§7Zeit:").setScore(2);
			 obj.getScore("§a"+TimeString.fromSecsTominsecsString(LobbyLogic.secs)).setScore(1);
			 obj.getScore("§8§l").setScore(3);
			 obj.getScore("§7Spieler:").setScore(5);
			 obj.getScore("§a"+Bukkit.getOnlinePlayers().size() + "/"+Bukkit.getMaxPlayers()).setScore(4);
			 obj.getScore("§9§l").setScore(6);
			 
			 all.setScoreboard(board);	 
		}
		
	}
	public void killBoard()
	{
		for(Player all: Bukkit.getOnlinePlayers())
		{
			ScoreboardManager sm = Bukkit.getScoreboardManager();
			Scoreboard reset = sm.getNewScoreboard();
			all.setScoreboard(reset);
		}
	}
	
}
