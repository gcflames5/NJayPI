package net.njay.njaypi.Config;

import net.njay.njaypi.Kit.Kit;
import net.njay.njaypi.Player.PlayerAttribute;
import net.njay.njaypi.Util.ColorParser;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

/**
 * @author Nick
 */
public class KitConfig extends APIConfig{

	private YamlConfiguration config;
	
	public KitConfig(YamlConfiguration config){
		this.config = config;
	}
	
	public Kit parseKit(String path){
		String displayName;
		PlayerAttribute[] attributesReq = new PlayerAttribute[config.getString(path+"AttributesReq").split(",").length]; int index = 0;
		ItemStack[] inventory, armor;
		displayName = ColorParser.parse(config.getString(path+".DisplayName"));
		for (String attrib : config.getString(path+".AttributesReq").split(","))
			attributesReq[index++] = new PlayerAttribute(attrib, 0);
		ItemListConfig itemParser = new ItemListConfig(config);
		inventory = itemParser.parseItemConfig(path+".InvSlots");
		armor = itemParser.parseItemConfig(path+".ArmorSlots");
		return new Kit(displayName, armor, inventory);
	}
}
