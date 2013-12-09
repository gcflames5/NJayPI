package net.njay.njaypi.Kit;

import net.njay.njaypi.Player.NJayPlayer;
import net.njay.njaypi.Player.PlayerAttribute;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

/**
 * @author Nick
 */
public class Kit {

	private String displayName;
	private ItemStack[] armor;
	private ItemStack[] inventory;
	private PotionEffect[] effects;
	
	private PlayerAttribute[] attributesRequired;
	
	public Kit(String displayName, ItemStack[] armor, ItemStack[] inventory, PotionEffect... effects){
		this.displayName = displayName;
		this.armor = armor;
		this.inventory = inventory;
		this.effects = effects;
	}
	
	public void setArmor(ItemStack[] armor){
		this.armor = armor;
	}
	public ItemStack[] getArmor(){
		return this.armor;
	}
	public void setInventory(ItemStack[] inventory){
		this.inventory = inventory;
	}
	public ItemStack[] getInventory(){
		return this.inventory;
	}
	public void setEffects(PotionEffect[] effects){
		this.effects = effects;
	}
	public PotionEffect[] getEffects(){
		return this.effects;
	}
	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}
	public String getDisplayName(){
		return this.displayName;
	}
	public void setAttributesRequired(PlayerAttribute[] attribs){
		this.attributesRequired = attribs;
	}
	public PlayerAttribute[] getRequiredAttributes(){
		return this.attributesRequired;
	}
	public boolean hasRequiredAttributes(NJayPlayer player){
		for (PlayerAttribute attrib : getRequiredAttributes()){
			if (!player.getAttributeList().hasAttribute(attrib.getName()))
				return false;
		}
		return true;
	}
	
	@SuppressWarnings("deprecation") //Because shut up, no... I DON'T CARE I'M DOING IT ANYWAY
	public void applyTo(boolean overrideExisting, String playerName){
		Player player = Bukkit.getPlayer(playerName);
		if (overrideExisting){
			player.getInventory().setArmorContents(getArmor());
			player.getInventory().setContents(getInventory());
		}else{
			ItemStack[] toBeSet_arm = new ItemStack[player.getInventory().getArmorContents().length];
			for (int i = 0; i < player.getInventory().getArmorContents().length - 1; i++){
				if (player.getInventory().getArmorContents()[i] != null)
					toBeSet_arm[i] = player.getInventory().getArmorContents()[i];
				else
					toBeSet_arm[i] = getArmor()[i];
			}
			ItemStack[] toBeSet_inv = new ItemStack[player.getInventory().getContents().length];
			for (int i = 0; i < player.getInventory().getContents().length - 1; i++){
				if (player.getInventory().getContents()[i] != null)
					toBeSet_inv[i] = player.getInventory().getContents()[i];
				else
					toBeSet_inv[i] = getInventory()[i];
			}
			player.getInventory().setArmorContents(toBeSet_arm);
			player.getInventory().setContents(toBeSet_inv);
		}
		
		for (PotionEffect peff : getEffects()){
			player.addPotionEffect(peff);
		}
		player.updateInventory();
	}
	
}
