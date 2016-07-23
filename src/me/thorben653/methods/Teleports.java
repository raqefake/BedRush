package me.thorben653.methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import BedRush.thorben653.main.BR;

public class Teleports {
	public static void Lobby(Player p){
		if(!BR.lcfg.contains("Lobby.world")){
			p.sendMessage("§cEs wurde keine Lobby gefunden!");
			return;
		}

		World w = Bukkit.getWorld(BR.lcfg.getString("Lobby.world"));
		double x = BR.lcfg.getDouble("Lobby.x");
		double y = BR.lcfg.getDouble("Lobby.y");
		double z = BR.lcfg.getDouble("Lobby.z");
		double yaw = BR.lcfg.getDouble("Lobby.yaw");
		double pitch = BR.lcfg.getDouble("Lobby.pitch");
		Location l = new Location(w,x,y,z,(float)yaw,(float)pitch);
		p.teleport(l);
	}
	
	public static void game(Player p){
		String i;
		
		if(TeamLogic.Blue.contains(p)){
			i = "blue";
		}else if(TeamLogic.Red.contains(p)){
			i = "red";
		}else{
			p.sendMessage("Ein Kritischer Fehler ist Aufgetreten in classe 'teleports' in Zeile 49!");
			return;
		}
		
		Location l;
		World w = Bukkit.getWorld(BR.lcfg.getString("Spawn. " + i + ".world"));
		double x = BR.lcfg.getDouble("Spawn. " + i + ".x");
		double y = BR.lcfg.getDouble("Spawn. " + i + ".y");
		double z = BR.lcfg.getDouble("Spawn. " + i + ".z");
		double yaw = BR.lcfg.getDouble("Spawn. " + i + ".yaw");
		double pitch = BR.lcfg.getDouble("Spawn. " + i + ".pitch");
		
		l = new Location(w,x,y,z,(float)yaw,(float)pitch);
		p.teleport(l);
	}

}
