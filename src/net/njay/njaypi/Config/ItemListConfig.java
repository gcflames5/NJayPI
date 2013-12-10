package net.njay.njaypi.Config;

import java.util.ArrayList;
import java.util.List;

import net.njay.njaypi.Util.ColorParser;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author Nick
 */
public class ItemListConfig {

	private YamlConfiguration config;
	
	public ItemListConfig(YamlConfiguration config){
		this.config = config;
	}
	
	public ItemStack[] parseItemString(String rawList){
		String[] items = rawList.split(",");
		ItemStack[] returnList = new ItemStack[items.length]; int index = 0;
		for (String s : items){
			returnList[index++] = parseItem(s);
		}
		return returnList;
	}
	
	@SuppressWarnings("deprecation")
	private ItemStack parseItem(String rawData){
		String[] attrib = rawData.split(":");
		int itemId = 0, amount = 0;
		short damageVal = 0;
		String displayName = "";
		List<String> lore = new ArrayList<String>();
		for (String s : attrib){
			String f = s.replaceAll("@.", "");
			switch(s.charAt(0) + "" + s.charAt(1)){
				case "@i":
					itemId = Integer.valueOf(f);
					break;
				case "@d":
					damageVal = Short.valueOf(f);
					break;
				case "@a":
					amount = Integer.valueOf(f);
					break;
				case "@n":
					displayName = ColorParser.parse(f);
					break;
				case "@l":
					lore.add(ColorParser.parse(f));
					break;
			}
		}
		ItemStack item = new ItemStack(itemId, amount, damageVal);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack[] parseItemConfig(String path){
		return parseItemString(config.getString(path));
	}
	
	
}
