package net.njay.njaypi.Logger;

import java.util.logging.Level;

import org.bukkit.Bukkit;

/**
 * @author Nick
 */
public class Logger {
	private static void log(String msg, Level level){
		Bukkit.getLogger().log(level, "[NJay]" + msg);
	}
	
	public static void info(String msg){
		log(msg, Level.INFO);
	}

}
