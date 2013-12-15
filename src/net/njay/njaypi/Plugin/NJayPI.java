<<<<<<< HEAD
package net.njay.njaypi.Plugin;

import net.njay.njaypi.Config.APIConfig;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Nick
 */
public class NJayPI extends JavaPlugin{  

	private static Plugin plugin;
	private final static String apiVersion = "0.0.1 Alpha";
	private static APIConfig config;
	/*private static String art = " 		 _   _      _             _____ _____ \n"+
								" 		| \\ | |    | |           |  __ |_   _|\n"+
								" 		|  \\| |    | | __ _ _   _| |__) || |  \n"+
								" 		| . ` |_   | |/ _` | | | |  ___/ | |  \n"+
								" 		| |\\  | |__| | (_| | |_| | |    _| |_ \n"+
								" 		|_| \\_|\\____/ \\__,_|\\__, |_|   |_____|\n"+
								" 		                     __/ |            \n"+
								" 		                    |___/             \n";*/
	private static String art = " _____            _     _          _   _   _    ___            ______ _____ \n"+
"|  ___|          | |   | |        | | | \\ | |  |_  |           | ___ \\_   _|\n"+
"| |__ _ __   __ _| |__ | | ___  __| | |  \\| |    | | __ _ _   _| |_/ / | |  \n"+
"|  __| '_ \\ / _` | '_ \\| |/ _ \\/ _` | | . ` |    | |/ _` | | | |  __/  | |  \n"+
"| |__| | | | (_| | |_) | |  __/ (_| | | |\\  |/\\__/ / (_| | |_| | |    _| |_ \n"+
"\\____/_| |_|\\__,_|_.__/|_|\\___|\\__,_| \\_| \\_/\\____/ \\__,_|\\__, \\_|    \\___/ \n"+
"                                                           __/ |            \n"+
"                                                          |___/             ";

	
	public static void init(Plugin plugin){
		NJayPI.plugin = plugin;
		System.out.println("Enabling NJayPI version " + apiVersion + "\n" + art);
	}
	
	public static Plugin getPlugin(){
		if (plugin == null) {
			Bukkit.getLogger().warning("NJayPi has not been initialized!");
			for (StackTraceElement l : Thread.currentThread().getStackTrace()) {System.out.println(l);};
		}
		return plugin;			
	}
	
	public static APIConfig getAPIConfig(){
		return config;
	}
	
}
=======
package net.njay.njaypi.Plugin;

import net.njay.njaypi.Config.APIConfig;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Nick
 */
public class NJayPI extends JavaPlugin{  

	private static Plugin plugin;
	private final static String apiVersion = "0.0.1 Alpha";
	private static APIConfig config;
	/*private static String art = " 		 _   _      _             _____ _____ \n"+
								" 		| \\ | |    | |           |  __ |_   _|\n"+
								" 		|  \\| |    | | __ _ _   _| |__) || |  \n"+
								" 		| . ` |_   | |/ _` | | | |  ___/ | |  \n"+
								" 		| |\\  | |__| | (_| | |_| | |    _| |_ \n"+
								" 		|_| \\_|\\____/ \\__,_|\\__, |_|   |_____|\n"+
								" 		                     __/ |            \n"+
								" 		                    |___/             \n";*/
	private static String art = " _____            _     _          _   _   _    ___            ______ _____ \n"+
"|  ___|          | |   | |        | | | \\ | |  |_  |           | ___ \\_   _|\n"+
"| |__ _ __   __ _| |__ | | ___  __| | |  \\| |    | | __ _ _   _| |_/ / | |  \n"+
"|  __| '_ \\ / _` | '_ \\| |/ _ \\/ _` | | . ` |    | |/ _` | | | |  __/  | |  \n"+
"| |__| | | | (_| | |_) | |  __/ (_| | | |\\  |/\\__/ / (_| | |_| | |    _| |_ \n"+
"\\____/_| |_|\\__,_|_.__/|_|\\___|\\__,_| \\_| \\_/\\____/ \\__,_|\\__, \\_|    \\___/ \n"+
"                                                           __/ |            \n"+
"                                                          |___/             ";

	
	public static void init(Plugin plugin){
		NJayPI.plugin = plugin;
		System.out.println("Enabling NJayPI version " + apiVersion + "\n" + art);
	}
	
	public static Plugin getPlugin(){
		if (plugin == null) {
			Bukkit.getLogger().warning("NJayPi has not been initialized!");
			for (StackTraceElement l : Thread.currentThread().getStackTrace()) {System.out.println(l);};
		}
		return plugin;			
	}
	
	public static APIConfig getAPIConfig(){
		return config;
	}
	
}
>>>>>>> 273ffa5f27a0d87a92b6373cdad0d660d96a2f31
