package net.njay.njaypi.Module.Modules;

import java.util.ArrayList;

import net.njay.njaypi.Module.ListenerModule;
import net.njay.njaypi.Plugin.NJayPI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * @author Nick
 */
public class BlockBreakModule extends ListenerModule{

	private ArrayList<String> players = new ArrayList<String>();
	private ListMode listMode = ListMode.WHITELIST;
	private CheckMode checkMode = CheckMode.TOTAL;
	private ArrayList<Material> materialList = new ArrayList<Material>();
	private String message = "";
	private PluginMessageModule pmModule;
	//TODO: Decide whether or not to use regions from World Edit
	
	public BlockBreakModule(PluginMessageModule module){
		this.pmModule = module;
		setEnabled(true);
	}
	
	public void addPlayer(String playername){
		this.players.add(playername);
	}
	public void removePlayer(String playername){
		this.players.remove(playername);
	}
	public void setListMode(ListMode listMode){
		this.listMode = listMode;
	}
	public void setCheckMode(CheckMode checkMode){
		this.checkMode = checkMode;
	}
	public void setMaterialList(boolean clear, Material... materials){
		if (clear)
			this.materialList.clear();
		for (Material m : materials)
			this.materialList.add(m);
	}
	public void setMessage(String msg){
		this.message = msg;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		if (players.contains(e.getPlayer().getName())){
			if (checkMode == CheckMode.MATERIAL){
				if (listMode == ListMode.WHITELIST){
					if (!materialList.contains(e.getBlock().getType())){
						e.setCancelled(true);
						this.pmModule.send(e.getPlayer(), this.message);
					}
				}else if (listMode == ListMode.BLACKLIST){
					if (materialList.contains(e.getBlock().getType())){
						e.setCancelled(true);
						this.pmModule.send(e.getPlayer(), this.message);
					}
				}
			}else if (checkMode == CheckMode.REGION){
				
			}else if (checkMode == CheckMode.TOTAL){
				e.setCancelled(true);
				this.pmModule.send(e.getPlayer(), this.message);
			}
		}
	}
	
	public void setEnabled(boolean enabled){
		if (enabled)
			Bukkit.getPluginManager().registerEvents(this, NJayPI.getPlugin());
		else
			HandlerList.unregisterAll(this);
		super.enabled = enabled;
	}

	public enum ListMode{	BLACKLIST, WHITELIST;	}
	public enum CheckMode{	MATERIAL, REGION, TOTAL	}
	
}
