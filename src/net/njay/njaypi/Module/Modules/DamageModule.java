package net.njay.njaypi.Module.Modules;

import java.util.ArrayList;
import java.util.List;

import net.njay.njaypi.Module.ListenerModule;
import net.njay.njaypi.Plugin.NJayPI;
import net.njay.njaypi.Team.Team;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

/**
 * @author Nick
 */
public class DamageModule extends ListenerModule{

	private List<Team> teams = new ArrayList<Team>();
	private List<String> players = new ArrayList<String>();
	private Mode mode = Mode.TEAM;
	
	private boolean allowFallDamage = true, allowTeamPvP = false, allowPlayersToHitMobs = false, 
			allowMobsToDamagePlayers = true, allowBurnDamage = true, allowDrownDamage = true;
	
	public DamageModule(){
		this.setEnabled(true);
	}
	
	public void addTeam(Team t){
		this.teams.add(t);
	}
	public void removeTeam(Team t){
		this.teams.remove(t);
	}
	public void addPlayer(String s){
		this.players.add(s);
	}
	public List<String> getPlayers(){
		return this.players;
	}
	public void removePlayer(String s){
		this.players.remove(s);
	}
	public void setMode(Mode mode){
		this.mode = mode;
	}
	public Mode getMode(){
		return this.mode;
	}
	public void allowFallDamage(boolean allowFallDamage){
		this.allowFallDamage = allowFallDamage;
	}
	public void allowTeamPvP(boolean allowTeamPvP){
		this.allowTeamPvP = allowTeamPvP;
	}
	public void allowPlayersToDamageMobs(boolean allowPlayersToDamageMobs){
		this.allowPlayersToHitMobs = allowPlayersToDamageMobs;
	}
	public void allowMobsToDamagePlayers(boolean allowMobsToDamagePlayers){
		this.allowMobsToDamagePlayers = allowMobsToDamagePlayers;
	}
	public void allowBurnDamage(boolean allowBurnDamage){
		this.allowBurnDamage = allowBurnDamage;
	}
	public void allowDrownDamage(boolean allowDrownDamage){
		this.allowDrownDamage = allowDrownDamage;
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if (this.mode == Mode.TEAM && e.getEntity() instanceof Player && !allowTeamPvP){
			Player damager = null;
			if (e.getDamager() instanceof Player){
				damager = (Player) e.getDamager();
			}else if (e.getDamager() instanceof Projectile){
				if (((Projectile)e.getDamager()).getShooter() instanceof Player){
					damager = (Player) ((Projectile)e.getDamager()).getShooter();
				}
			}
			if (damager != null){
				for (Team t : this.teams){
					if (t.getPlayers().contains(((Player)e.getEntity()).getName()) && t.getPlayers().contains(damager.getName())){
						e.setCancelled(true);
						break;
					}
				}
			}
		}
		if (!allowPlayersToHitMobs && !(e.getEntity() instanceof Player)){
			if (e.getDamager() instanceof Player)
				e.setCancelled(true);
			if (e.getDamager() instanceof Projectile && ((Projectile)e.getDamager()).getShooter() instanceof Player)
				e.setCancelled(true);
		}else if (!allowMobsToDamagePlayers && e.getEntity() instanceof Player && !(e.getDamager() instanceof Player)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		if (e.getEntity() instanceof Player){
			if (e.getCause() == DamageCause.FALL && !allowFallDamage){
				cancelEvent(e);
			}else if ((e.getCause() == DamageCause.FIRE || e.getCause() == DamageCause.FIRE_TICK) && !allowBurnDamage){
				cancelEvent(e);
			}else if (e.getCause() == DamageCause.DROWNING && !allowDrownDamage){
				cancelEvent(e);
			}
		}
	}
	
	private void cancelEvent(EntityDamageEvent e){
		if (this.mode == Mode.PLAYERS){
			e.setCancelled((players.contains(((Player)e.getEntity()).getName())) ? true : e.isCancelled());
		}else if (this.mode == Mode.TEAM){
			for (Team t : this.teams){
				if (t.getPlayers().contains(((Player)e.getEntity()).getName())){
					e.setCancelled(true);
					break;
				}
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
	
	public enum Mode { TEAM, PLAYERS };
	
}
