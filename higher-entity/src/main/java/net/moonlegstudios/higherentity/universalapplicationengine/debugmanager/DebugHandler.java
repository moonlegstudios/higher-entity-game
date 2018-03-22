package net.moonlegstudios.higherentity.universalapplicationengine.debugmanager;

import net.moonlegstudios.higherentity.universalapplicationengine.BootOptions;
import net.moonlegstudios.higherentity.universalapplicationengine.UniversalApplicationEngine;

public class DebugHandler implements BootOptions, UniversalApplicationEngine {
	
	public void reportDebugMessage (String messageType, String debugMessage) {
		
		/* delivers the debug message to the appropriate console */
		if (gui) {
			
			/* TODO: Implement GUI console debug dispatching */
			
		/* prints the debug message to the java console */
		} else {
			
			/* tests the debug report to see if it's an error or a notification */
			if (messageType.equalsIgnoreCase("error")) {
				
				/* prints the error message */
				System.out.println (debugMessage);
				
				/* TODO: Implement extra features for 'error' debug message type */
				
			} else if (messageType.equalsIgnoreCase("notification")) {
				
				/* prints the notification messages */
				System.out.println (debugMessage);
				
				/* TODO: Implement extra features for 'notification' debug message type */
				
			/* the wrong messageType String was given */
			} else {
				
				error.reportError("debug-messagetype-invalid");
				
				
			}
			
		}
		
	}
	
}
