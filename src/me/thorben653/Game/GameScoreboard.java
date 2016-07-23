package me.thorben653.Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import BedRush.thorben653.main.BR;
import me.thorben653.methods.BedAPI;
import me.thorben653.methods.TeamLogic;

public class GameScoreboard {
	
	public GameScoreboard(){}
	
	public String blue;
	public String red;
	
    public String gewinnerTeam = " §cERROR";
	
		

    
    public void sendBoard()
    {
if(BedAPI.existBlueBed == true)
{
	blue = "§a§l✓ §bBlau §7"+TeamLogic.Blue.size();
}else{
	blue = "§c§l✖ §bBlau §7"+TeamLogic.Blue.size();
}
if(BedAPI.existRedBed == true)
{
	red = "§a§l✓ §cRot §7"+TeamLogic.Red.size();
}else{
	red = "§c§l✖ §cRot §7"+TeamLogic.Red.size();
}

if(BR.hasEnded == true)
{

	gewinnerTeam = winEvent.winner;
	ScoreboardManager sm = Bukkit.getScoreboardManager();  
	Scoreboard reset = sm.getNewScoreboard();
	Objective obr = reset.registerNewObjective("ccc", "ddd");
	obr.setDisplaySlot(DisplaySlot.SIDEBAR);
	obr.setDisplayName("§f§lGEWINNER");
	
	obr.getScore("§7§l").setScore(0);
	obr.getScore("§aGEWINNER: "+gewinnerTeam).setScore(1);
	obr.getScore("§8§l").setScore(2);
	
	for(Player all: Bukkit.getOnlinePlayers())
	{
		all.setScoreboard(reset);
	}
return;
}
ScoreboardManager sm1 = Bukkit.getScoreboardManager();
Scoreboard board = sm1.getNewScoreboard();
Objective obj = board.registerNewObjective("aaa", "bbb");

obj.setDisplaySlot(DisplaySlot.SIDEBAR);
obj.setDisplayName("§f§lBEDRUSH");

obj.getScore("§7§l").setScore(0);
obj.getScore(blue).setScore(1);
obj.getScore(red).setScore(2);
obj.getScore("§8§l").setScore(3);

    	for(Player all: Bukkit.getOnlinePlayers())
    	{
    		all.setScoreboard(board);
    	}
    }
    

	

}
