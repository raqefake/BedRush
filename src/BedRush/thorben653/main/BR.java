package BedRush.thorben653.main;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.material.Bed;
import org.bukkit.plugin.java.JavaPlugin;

import BedRush.ragemc.workspace.effects.random.EffectManager;
import BedRush.ragemc.workspace.effects.random.Effects;
import BedRush.ragemc.workspace.map.Map;
import BedRush.thorben653.LobbySystem.LobbyLogic;
import BedRush.thorben653.LobbySystem.LobbyScoreboard;
import BedRush.thorben653.activeLogic.BuildEv;
import BedRush.thorben653.listeners.BukkitListener;
import BedRush.thorben653.listeners.ChatManager;
import BedRush.thorben653.listeners.DeathManager;
import me.thorben653.Game.GameScoreboard;
import me.thorben653.methods.BedAPI;
import me.thorben653.methods.Messages;
import me.thorben653.methods.TeamLogic;
import net.minecraft.server.v1_8_R3.Blocks;

public class BR extends JavaPlugin{
	public static BR instance;
	public static EffectManager effectManager;
	public static Effects effects;
	public static LobbyScoreboard lobbyScoreboard;
	public static GameScoreboard gameScoreboard;
	public static Map worldCreator;
	
	public static boolean hasStarted;
	public static boolean hasEnded;
	public static boolean inSarting;
	public static String databaseURL = "http://guulehahn.eu"; 
	
	public static File lfile = new File("plugins/BedRush", "locations.yml");
	public static FileConfiguration lcfg = YamlConfiguration.loadConfiguration(lfile);
	
	public static File file = new File("plugins/BedRush", "Config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static String prefix = "§7» §6BedRush§8: §7";
	
	
	public void onEnable(){
		System.out.println("Starting BedRush by Thorben653YT & RageMC...");
		
		instance = this;
		inSarting = true;
		Messages.fill();


		effectManager = new EffectManager();
		lobbyScoreboard = new LobbyScoreboard();
		gameScoreboard = new GameScoreboard();
		worldCreator = new Map();
		

		
		hasStarted = false;
		
		  getServer().getPluginManager().registerEvents(new BukkitListener(), this); 
		  getServer().getPluginManager().registerEvents(new TeamLogic(), this); 
		  getServer().getPluginManager().registerEvents(new DeathManager(), this); 
		  getServer().getPluginManager().registerEvents(new BedAPI(), this); 
		  getServer().getPluginManager().registerEvents(new ChatManager(), this); 
		  this.getCommand("setLobby").setExecutor(new CMDs());
		  this.getCommand("setBlueSpawn").setExecutor(new CMDs());
		  this.getCommand("setRedSpawn").setExecutor(new CMDs());
		  this.getCommand("start").setExecutor(new CMDs());
		  this.getCommand("addSpawner").setExecutor(new CMDs());
		  this.getCommand("setbluebedbody").setExecutor(new CMDs());
		  this.getCommand("setredbedbody").setExecutor(new CMDs());
		  this.getCommand("stats").setExecutor(new CMDs());
		  
		  if(!cfg.contains("secstostart")){
			  cfg.set("Teamsize", 4);
			  cfg.set("PlayersToStart", 2);
			  cfg.set("secstoStart", 60);
				try {cfg.save(file);} catch (IOException e) {}
		  }
		  
			for(World w : Bukkit.getWorlds()){
				w.setTime(26000);
				w.setGameRuleValue("keepInventory", "false");
				w.setGameRuleValue("doDaylightCycle", "false");
				w.setGameRuleValue("doFireTick", "false");
				w.setGameRuleValue("doMobSpawning", "false");
				w.setAutoSave(false);
					for(Entity e : w.getEntities()){
						e.remove();
					}
			}
			
			BedAPI.existBlueBed = true;
			BedAPI.existRedBed = true;
			gameScoreboard.blue = "§a§l✓ §bBlau";
			gameScoreboard.red = "§a§l✓ §cRot";
			
		  LobbyLogic.start();
		
		System.out.println("BedRush started!");
	}
	
	public void onDisable(){
		 System.exit(0);
		 System.exit(1);
		
	}

	
}
