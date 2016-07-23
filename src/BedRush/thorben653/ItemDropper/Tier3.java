package BedRush.thorben653.ItemDropper;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tier3 {
	public static ArrayList<ItemStack> items = new ArrayList<ItemStack>();
	public static void fill(){
		//Tier 3
		
		//Eisenschwert
		ItemStack s3 = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta s3M = s3.getItemMeta();
		s3M.setDisplayName("§6Eisenschwert");
		s3.setItemMeta(s3M);
		s3.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		s3.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		items.add(s3);  //1
		items.add(s3);  //2
		
		//Pfeile
		ItemStack arrow = new ItemStack(Material.ARROW, 4);
		items.add(arrow); //1
		items.add(arrow); //2
		items.add(arrow); //3
		
		//Bogen
		ItemStack b = new ItemStack(Material.BOW, 1);
		ItemMeta bM = b.getItemMeta();
		bM.setDisplayName("§6Bogen");
		b.setItemMeta(bM);
		b.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		items.add(b);  //1
	}

}
