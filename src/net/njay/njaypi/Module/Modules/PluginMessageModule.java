package net.njay.njaypi.Module.Modules;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.njay.njaypi.Module.Module;
import net.njay.njaypi.Team.Team;

/**
 * @author Nick
 */
public class PluginMessageModule extends Module{

	private String prefix = "";
	private boolean enablePrefix = true;
	private boolean sendNull = false;
	
	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
	public String getPrefix(){
		return this.prefix;
	}
	public void setPrefixEnabled(boolean enabled){
		this.enablePrefix = enabled;
	}
	public boolean prefixEnabled(){
		return this.enablePrefix;
	}

	public void send(String playername, String msg){
		if (!sendNull){
			if (msg != null && msg != "")
				Bukkit.getPlayer(playername).sendMessage(formatMsg(msg));
		}else
			Bukkit.getPlayer(playername).sendMessage(formatMsg(msg));
	}
	public void send(Player p, String msg){
		send(p.getName(), msg);
	}
	public void send(Team t, String msg){
		for (String p : t.getPlayers())
			send(p, msg);
	}
	public void sendAll(String msg){
		for (Player p : Bukkit.getOnlinePlayers())
			send(p, msg);
	}
	public String formatMsg(String msg){
		if (enablePrefix){
			return this.prefix + " " + msg;
		}else
			return msg;
	}
}
