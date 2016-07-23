package me.thorben653.methods;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import BedRush.thorben653.main.BR;

public class TeamLogic implements Listener {
	public static ArrayList<Player> Red = new ArrayList<Player>();
	public static ArrayList<Player> Blue = new ArrayList<Player>();
	
	public static ItemStack getItem(){
		ItemStack i = new ItemStack(Material.BED);
		ItemMeta m = i.getItemMeta();
		m.addEnchant(Enchantment.DURABILITY, 1, true);
		m.setDisplayName("§bTeamauswahl");
		i.setItemMeta(m);
		return i;
	}	
	
	public static void openmenu(Player p){
		Inventory i = Bukkit.createInventory(p, 9,"§9§lTeams");
		
		ItemStack red = new ItemStack(Material.WOOL,1,(byte)14);
		ItemStack blue = new ItemStack(Material.WOOL,1, (byte)3);
		ItemStack rdm = new ItemStack(Material.CHEST,1);
		ItemMeta redM = red.getItemMeta();
		ItemMeta blueM = blue.getItemMeta();
		ItemMeta rdmM = rdm.getItemMeta();
		redM.setDisplayName("§cTeam Rot");
		blueM.setDisplayName("§bTeam Blau");
		rdmM.setDisplayName("§7Zufälliges Team");
		red.setItemMeta(redM);
		blue.setItemMeta(blueM);
		rdm.setItemMeta(rdmM);
		
		i.setItem(0, red);
		i.setItem(8, blue);
		i.setItem(4, rdm);
		
		
		p.openInventory(i);
	}
	
	@EventHandler
	public void oninvClick(InventoryClickEvent e){
		if(e.getCurrentItem() == null)return;
		if(!e.getInventory().getName().equalsIgnoreCase("§9§lTeams"))return;
		e.setCancelled(true);
		if(e.getCurrentItem() == null)return;
		Player p = (Player) e.getWhoClicked();
		
		ItemStack red = new ItemStack(Material.WOOL,1,(byte)14);
		ItemStack blue = new ItemStack(Material.WOOL,1, (byte)3);
		ItemStack rdm = new ItemStack(Material.CHEST,1);
		ItemMeta redM = red.getItemMeta();
		ItemMeta blueM = blue.getItemMeta();
		ItemMeta rdmM = rdm.getItemMeta();
		redM.setDisplayName("§cTeam Rot");
		blueM.setDisplayName("§bTeam Blau");
		rdmM.setDisplayName("§7Zufälliges Team");
		red.setItemMeta(redM);
		blue.setItemMeta(blueM);
		rdm.setItemMeta(rdmM);
		
		if(e.getCurrentItem().equals(rdm)){
			rndTeam(p);
		}
		
		if(e.getCurrentItem().equals(red)){
			p.closeInventory();
			//ist bereits in dem Team?
			if(Red.contains(p)){
				p.sendMessage(Messages.alreadyinTeam + Messages.red + "§c!");
				setHelmet(p);
				return;
			}
			
			Red.remove(p);
			Blue.remove(p);
			//Umgehe Div by 0 err
			if(Red.size() == 0){
				Red.add(p);
				p.sendMessage(Messages.joinedTeam + Messages.red + "§7!");
				setHelmet(p);
				return;
			}
			//70% darf ein Team Maximal ausmachen...
			if(100 * Red.size() / Bukkit.getOnlinePlayers().size() > 40){
				p.sendMessage(Messages.redisfull);
				p.sendMessage(Messages.joinedTeam + Messages.blue + "§7!");
				Blue.add(p);
				setHelmet(p);
				return;
			}
			
			//Ist Team voll?
			if(Red.size() >= BR.cfg.getInt("Teamsize")){
				p.sendMessage(Messages.redisfull);
				p.sendMessage(Messages.joinedTeam + Messages.blue + "§7!");
				Blue.add(p);
				setHelmet(p);
				return;
			}
			
			Red.add(p);
			p.sendMessage(Messages.joinedTeam + Messages.red + "§7!");
			setHelmet(p);
		}
		
		if(e.getCurrentItem().equals(blue)){
			p.closeInventory();
			//ist bereits in dem Team?
			if(Blue.contains(p)){
				p.sendMessage(Messages.alreadyinTeam + Messages.blue + "§c!");
				setHelmet(p);
				return;
			}
			
			Red.remove(p);
			Blue.remove(p);
			//Umgehe Div by 0 err
			if(Blue.size() == 0){
				Blue.add(p);
				p.sendMessage(Messages.joinedTeam + Messages.blue + "§7!");
				setHelmet(p);
				return;
			}
			//70% darf ein Team Maximal ausmachen...
			if(100 * Blue.size() / Bukkit.getOnlinePlayers().size() > 40){
				p.sendMessage(Messages.blueisfull);
				Red.add(p);
				p.sendMessage(Messages.joinedTeam + Messages.red + "§7!");
				setHelmet(p);
				return;
			}
			
			//ist Team voll?
			if(Blue.size() >= BR.cfg.getInt("Teamsize")){
				p.sendMessage(Messages.blueisfull);
				Red.add(p);
				p.sendMessage(Messages.joinedTeam + Messages.red + "§7!");
				setHelmet(p);
				return;
			}
			
			Blue.add(p);
			p.sendMessage(Messages.joinedTeam + Messages.blue + "§7!");
			setHelmet(p);
		}
	}
	
	
	public static void rndTeam(Player p){
		Red.remove(p);
		Blue.remove(p);
		if(Red.size() > Blue.size()){
			Blue.add(p);
			p.sendMessage(Messages.joinedTeam + Messages.blue + "§7!");
			setHelmet(p);
			return;
		}
		if(Blue.size() > Red.size()){
			Red.add(p);
			p.sendMessage(Messages.joinedTeam + Messages.red + "§7!");
			setHelmet(p);
			return;
		}
		
		//Real Random
		int c = 0 + (int)(Math.random() * 2);
		if(c == 1){
			Red.add(p);
			p.sendMessage(Messages.joinedTeam + Messages.red + "§7!");
			setHelmet(p);
		}else if(c == 0){
			Blue.add(p);
			p.sendMessage(Messages.joinedTeam + Messages.blue + "§7!");
			setHelmet(p);
		}
	}
	
	public static void setHelmet(Player p){
		ItemStack i = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta itemMeta = (LeatherArmorMeta)i.getItemMeta();
		
		if(Red.contains(p)){
		     itemMeta.setColor(Color.fromRGB(255, 0, 0));
	         i.setItemMeta(itemMeta);
		}else if(Blue.contains(p)){
		     itemMeta.setColor(Color.fromRGB(0, 0, 255));
	         i.setItemMeta(itemMeta);
		}else{
		     itemMeta.setColor(Color.fromRGB(255, 255, 255));
	         i.setItemMeta(itemMeta);
		}
		
		ItemMeta m = i.getItemMeta();
		m.setDisplayName("§7Bulletproof");
		m.addEnchant(Enchantment.DURABILITY, 10, true);
		m.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		i.setItemMeta(m);
		p.getInventory().setHelmet(i);
	}
	
}
