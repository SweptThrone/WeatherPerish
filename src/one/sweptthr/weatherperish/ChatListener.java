package one.sweptthr.weatherperish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatListener implements Listener {

	private Main plugin;
	
	public ChatListener( Main plugin ) {
		this.plugin = plugin;
	}
	
	//i looked this up and people said to just use the old thing
	//the problem is that setStorm must be sync
	//but asyncplayerchat is async
	//screw it
	
	@EventHandler
	public void onPlayerChat( PlayerChatEvent event ) {
		if ( ( event.getMessage().equalsIgnoreCase( "no" ) || 
				event.getMessage().equalsIgnoreCase( "perish" ) ||
				event.getMessage().equalsIgnoreCase( "die" ) ) &&
				( event.getPlayer().getWorld().hasMetadata( "rainStart" ) &&
				System.currentTimeMillis() < event.getPlayer().getWorld().getMetadata( "rainStart" ).get(0).asLong() + 5000 ) ) {
			event.getPlayer().getWorld().setStorm( false );
			for ( Player ply : this.plugin.getServer().getOnlinePlayers() ) {
				ply.sendMessage( "§bVery well." );
			}
		}
	}
	
}
