package BedRush.thorben653.ItemDropper;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tier1 {
	public static ArrayList<ItemStack> items = new ArrayList<ItemStack>();
	public static void fill(){
		
		//Tier1
		
		//Sandstein
		ItemStack stone = new ItemStack(Material.SANDSTONE, 4);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);
		items.add(stone);

		ItemStack web = new ItemStack(Material.WEB, 2);
		items.add(web);
		items.add(web);
		
		ItemStack end = new ItemStack(Material.ENDER_STONE, 2);
		items.add(end);
		items.add(end);
		
		//Holz-Spitzhacke
		ItemStack pickaxe = new ItemStack(Material.WOOD_PICKAXE, 1);
		ItemMeta pickaxeM = pickaxe.getItemMeta();
		pickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
		items.add(pickaxe);
		items.add(pickaxe);
		items.add(pickaxe);

		//Knockback Stick
		ItemStack stick = new ItemStack(Material.STICK, 1);
		ItemMeta stickM = stick.getItemMeta();
		stickM.setDisplayName("§bKnockback Stick");
		stick.setItemMeta(stickM);
		stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		items.add(stick);
		items.add(stick);
		items.add(stick);
		items.add(stick);
	}
}
