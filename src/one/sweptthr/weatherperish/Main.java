package one.sweptthr.weatherperish;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getLogger().info( "Event listener registered." );
		getServer().getPluginManager().registerEvents( new WeatherListener( this ), this );
		getServer().getPluginManager().registerEvents( new ChatListener( this ), this );
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Disabled successfully!");
	}
	
}
