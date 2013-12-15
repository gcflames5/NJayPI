package net.njay.njaypi.Shop;

import java.util.List;

import net.njay.njaypi.Player.PlayerAttribute;

import org.bukkit.inventory.ItemStack;

/**
 * @author Nick & Jordan
 */
public class ShopItem {

	private ItemStack item, shopItem;
	private double price;
	private List<PlayerAttribute> requirements;
	
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public ItemStack getShopItem() {
		return shopItem;
	}
	public void setShopItem(ItemStack shopItem) {
		this.shopItem = shopItem;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<PlayerAttribute> getRequirements() {
		return requirements;
	}
	public void setRequirements(List<PlayerAttribute> requirements) {
		this.requirements = requirements;
	}
	
}
