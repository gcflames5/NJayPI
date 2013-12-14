package net.njay.njaypi.Module.Modules;

import net.njay.njaypi.Map.MapVoter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author Nick
 */
public class VoteModule implements CommandExecutor{

	private MapVoter voter;
	
	private boolean showMapOptionsOnJoin = false;
	
	public VoteModule(MapVoter voter, String... commandNames){
		this.voter = voter;
		for (String command : commandNames)
			Bukkit.getPluginCommand(command).setExecutor(this);
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		return false;
	}
	
}
