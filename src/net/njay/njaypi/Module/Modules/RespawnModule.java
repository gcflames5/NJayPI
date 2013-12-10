package net.njay.njaypi.Module.Modules;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.njay.njaypi.Kit.Kit;
import net.njay.njaypi.Module.ListenerModule;
import net.njay.njaypi.Plugin.NJayPI;

/**
 * @author Nick
 */
public class RespawnModule extends ListenerModule{

	private Location respawnPoint;
	private Kit kit;
	private boolean applyKit = false;
	
	public void setApplyKit(boolean applyKit){
		this.applyKit = applyKit;
	}
	public boolean applyKit(){
		return this.applyKit;
	}
	public void setKit(Kit k){
		this.kit = k;
	}
	public Kit getKit(){
		return this.kit;
	}
	public void setRespawnPoint(Location loc){
		this.respawnPoint = loc;
	}
	public Location getRespawnPoint(){
		return this.respawnPoint;
	}
	
	public RespawnModule(){
		setEnabled(true);
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		delaySpawn(respawnPoint, e.getPlayer());
		if (applyKit)
			delayApplyKit(kit, e.getPlayer());
	}
	
	public void setEnabled(boolean enabled){
		if (enabled)
			Bukkit.getPluginManager().registerEvents(this, NJayPI.getPlugin());
		else
			HandlerList.unregisterAll(this);
		super.enabled = enabled;
	}
	
	private void delaySpawn(final Location loc, final Player p){
		Bukkit.getScheduler().scheduleSyncDelayedTask(NJayPI.getPlugin(), new Runnable(){
			public void run(){
				p.teleport(loc);
			}
		}, 1);
	}
	
	private void delayApplyKit(final Kit k, final Player p){
		Bukkit.getScheduler().scheduleSyncDelayedTask(NJayPI.getPlugin(), new Runnable(){
			public void run(){
				k.applyTo(true, p.getName());
			}
		}, 1);
	}
	
}
