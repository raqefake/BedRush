package BedRush.thorben653.ItemDropper;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tier2 {
	public static ArrayList<ItemStack> items = new ArrayList<ItemStack>();
	public static void fill(){
		//Tier2
		
		//Goldschwer I
		ItemStack s = new ItemStack(Material.GOLD_SWORD, 1);
		ItemMeta sM = s.getItemMeta();
		sM.setDisplayName("§6Goldschwert I");
		s.setItemMeta(sM);
		s.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		items.add(s);  //1
		items.add(s);  //2
		items.add(s);  //3
		items.add(s);  //4
		items.add(s);  //5
		items.add(s);  //6
		
		//Goldschwert II
		ItemStack s2 = new ItemStack(Material.GOLD_SWORD, 1);
		ItemMeta s2M = s2.getItemMeta();
		s2M.setDisplayName("§6Goldschwert II");
		s2.setItemMeta(s2M);
		s2.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		s2.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		items.add(s2);  //1
		items.add(s2);  //2
		
		ItemStack trank = new ItemStack(Material.POTION, 1, (short) 8226);
		items.add(trank);  //1
		items.add(trank);  //2
		
		//Brustpanzer I
		ItemStack sw = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta swM = sw.getItemMeta();
		swM.setDisplayName("§6Brustpanzer I");
		sw.setItemMeta(swM);
		sw.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		items.add(sw);  //1
		items.add(sw);  //2
		items.add(sw);  //3
		items.add(sw);  //4
		items.add(sw);  //5
		items.add(sw);  //6
	
		//Brustpanzer II
		ItemStack sw2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta sw2M = sw2.getItemMeta();
		sw2M.setDisplayName("§6Brustpanzer II");
		sw2.setItemMeta(sw2M);
		sw2.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		sw2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		items.add(sw2);  //1
		items.add(sw2);  //2
		
		//Stein-Pickhacke
		ItemStack pickaxes = new ItemStack(Material.STONE_PICKAXE, 1);
		ItemMeta pickaxesM = pickaxes.getItemMeta();
		pickaxes.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		pickaxes.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
		items.add(pickaxes);  //1
		items.add(pickaxes);  //2
		items.add(pickaxes);  //3
		items.add(pickaxes);  //4
		items.add(pickaxes);  //5
		items.add(pickaxes);  //6
	}
}
