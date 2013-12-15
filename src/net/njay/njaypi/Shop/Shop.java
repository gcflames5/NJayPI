package net.njay.njaypi.Shop;

import java.util.List;

import net.njay.njaypi.Plugin.NJayPI;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * @author Nick & Jordan
 */
public class Shop implements Listener {

	private List<ShopItem> items;
	private String title = "Shop";
	private int inventorySize = 27;
	private Runnable onClick = new Runnable() {
		int a;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};
	
	public Shop(List<ShopItem> items){
		this.items = items;
		Bukkit.getPluginManager().registerEvents(this, NJayPI.getPlugin());
	}
	
	public Inventory generateShop() {
		Inventory inv = Bukkit.createInventory(null, inventorySize, title);
		for (int i = 0; i < items.size(); i++) {
			inv.addItem(items.get(0).getItem());
		}
		return inv;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		onClick.run();
	}
	
	public Shop(ShopItem... items){
		for (ShopItem item : items)
			this.items.add(item);
	}
	
	

	public void setOnClick(Runnable onClick) {
		this.onClick = onClick;
	}
	
}
