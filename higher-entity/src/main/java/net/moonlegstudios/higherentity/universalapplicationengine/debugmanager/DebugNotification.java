package net.moonlegstudios.higherentity.universalapplicationengine.debugmanager;

import net.moonlegstudios.higherentity.HigherEntity;
import net.moonlegstudios.higherentity.universalapplicationengine.UniversalApplicationEngine;

public class DebugNotification implements UniversalApplicationEngine, HigherEntity {

	/* notification message collection registry */
	public String[][] notificationMessageRegistry = {
			
			/* notification message guidelines - registry scanner skips index 0 */
			{"notification-id", "notification-message"},
			
			{"enabled-no-gui-mode", "NO-GUI Mode has been enabled, all program output will be displayed inside the console IDE - some features will be disabled"},
			{"init-uae", "Universal Application engine is now initializing..."},
			{"init-mge", "Membran GUI engine is now initializing..."},
			{"init-ege", "Essence Game Engine is now intializing..."},
			{"program-launching", "Launching Program\n\n" + appTitle + "\n" + appDescription + "\n" + appVersion + " - " + updateTitle + "\n" + appAuthor + "\n" + copyright + "\n---"},
			
	};
	
	/* use this method in code to quickly implement a debug notification message */
	public void reportNotification (String notificationId) {
		
		/* executes verifyNotificationId() method with applicable args */
		this.verifyNotificationId(notificationId);
		
	}
	
	/* checks the notificationMessageRegsitry[] array for a match in notificationId */
	private void verifyNotificationId (String notificationId) {
		
		/* loops and scans through the notificationMessageRegsitry[] */
		for (int counter = 1; counter < notificationMessageRegistry.length; counter ++) {
			
			/* found a match */
			if (notificationId.equalsIgnoreCase(notificationMessageRegistry[counter][0])) {
				
				/* executes buildNotification() method with applicable args */
				this.buildNotificationMessage(notificationMessageRegistry[counter][1]);
				
			}
			
		}
		
	}
	
	
	/* builds the notification message and dispatches the debug report */
	private void buildNotificationMessage (String notificationMessage) {
		
		/* builds the error message and stores it in message String */
		String message = "[NOTIFICATION] " + notificationMessage.trim();
		
		/* executes reportDebugMessage() method with applicable args */
		debug.reportDebugMessage("notification", message);
		
	}
	
}
