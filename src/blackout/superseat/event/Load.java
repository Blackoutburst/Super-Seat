package blackout.superseat.event;

import java.io.File;
import java.io.IOException;

import blackout.superseat.utils.Config;

public class Load {
	
	/**
	 * Create important file on the plugin loading
	 * 
	 * Load all seat to RAM from the file
	 */
	public void execute() {
		try {
			Config.create();
			createFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Config.loadSeats();
	}
	
	/**
	 * Create all needed files if they don't exist
	 * Also create the plugin folder
	 * @throws IOException
	 */
	private void createFile() throws IOException {
		File folder = new File("plugins/SuperSeat");
		File seatFile = new File("plugins/SuperSeat/seats.yml");
		
		if (!folder.exists())
			folder.mkdirs();
		if (!seatFile.exists())
			seatFile.createNewFile();
	}
}
