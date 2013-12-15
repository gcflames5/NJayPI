package net.njay.njaypi.Testing;

import org.bukkit.plugin.java.JavaPlugin;


//This is a class so we can export the API as a Plugin for testing.
//Will be removed on release
public class Main extends JavaPlugin {
	public void onEnable() {
		System.out.println("Enabled");
	}
}
