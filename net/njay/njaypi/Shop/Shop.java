package net.njay.njaypi.Shop;

import java.util.List;

/**
 * @author Nick
 */
public class Shop {

	private List<ShopItem> items;
	
	public Shop(List<ShopItem> items){
		this.items = items;
	}
	
	public Shop(ShopItem... items){
		for (ShopItem item : items)
			this.items.add(item);
	}
	
}
