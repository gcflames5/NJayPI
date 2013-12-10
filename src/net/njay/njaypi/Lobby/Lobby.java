package net.njay.njaypi.Lobby;

import java.util.ArrayList;

import net.njay.njaypi.Kit.Kit;
import net.njay.njaypi.Module.Modules.BlockBreakModule;
import net.njay.njaypi.Module.Modules.DamageModule;
import net.njay.njaypi.Module.Modules.PluginMessageModule;
import net.njay.njaypi.Module.Modules.RespawnModule;

import org.bukkit.Location;

/**
 * @author Nick
 */
public class Lobby {
	private ArrayList<String> players = new ArrayList<String>();
	private Location spawn;
	private boolean respawnOnDeath = true, allowFlight = false, 
			exitOnTeleport = true, enterOnJoin = true, allowBlockBreaking = false;
	private boolean applyKit = false;
	private Kit kit;
	
	private BlockBreakModule bbm;
	private RespawnModule rpm;
	private DamageModule dmgm;
	private PluginMessageModule pmm;
	
	public Lobby(Location spawn, PluginMessageModule module){
		this.pmm = module;
		this.bbm = new BlockBreakModule(this.pmm);
		this.rpm = new RespawnModule();
		this.dmgm = new DamageModule();
		this.spawn = spawn;
	}
	public void setRespawnOnDeath(boolean rod){
		this.respawnOnDeath = rod;
		update();
	}
	public void setAllowFlight(boolean af){
		this.allowFlight = af;
		update();
	}
	public void setExitOnTeleport(boolean eot){
		this.exitOnTeleport = eot;
		update();
	}
	public void setEnterOnJoin(boolean eoj){
		this.enterOnJoin = eoj;
		update();
	}
	public void setApplyKit(boolean apk){
		this.applyKit = apk;
		update();
	}
	public void setKit(Kit k){
		this.kit = k;
		update();
	}

	private void update(){
		if (allowBlockBreaking)
			if (bbm.enabled())
				bbm.setEnabled(false);
		else{
			if (!bbm.enabled())
				bbm.setEnabled(true);
			bbm.setCheckMode(BlockBreakModule.CheckMode.TOTAL);
		}
		
		if (respawnOnDeath){
			if (!rpm.enabled())
				rpm.setEnabled(true);
			rpm.setRespawnPoint(spawn);
			rpm.setApplyKit(this.applyKit);
			rpm.setKit(this.kit);
		}else{
			if (rpm.enabled())
				rpm.setEnabled(false);
		}
		
		this.dmgm.setMode(DamageModule.Mode.PLAYERS);
		for (String s : players){
			if (!this.dmgm.getPlayers().contains(s))
				this.dmgm.addPlayer(s);
		}
		this.dmgm.allowBurnDamage(false);
		this.dmgm.allowDrownDamage(false);
		this.dmgm.allowFallDamage(false);
		this.dmgm.allowMobsToDamagePlayers(false);
		this.dmgm.allowPlayersToDamageMobs(false);
		this.dmgm.allowPlayersToDamageMobs(true);
	}
	
}
