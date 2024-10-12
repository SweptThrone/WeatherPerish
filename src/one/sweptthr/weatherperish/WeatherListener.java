package one.sweptthr.weatherperish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class WeatherListener implements Listener {

	private Main plugin;
	
	public WeatherListener( Main plugin ) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onWeatherChanged( WeatherChangeEvent event ) {
		if ( event.toWeatherState() ) {
			event.getWorld().setMetadata( "rainStart", new FixedMetadataValue( this.plugin, System.currentTimeMillis() ) );
		}
	}
	
}
