package net.moonlegstudios.higherentity.universalapplicationengine.debugmanager;

import net.moonlegstudios.higherentity.universalapplicationengine.UniversalApplicationEngine;

public class DebugError implements UniversalApplicationEngine{

	/* error message collection registry */
	String[][] errorMessageRegistry = {
			
			/* error message guidelines - registry scanner skips index 0*/
			{"error-id", "error-message", "error-reason-hint", "error-severity"},
			
			{"init-uae-failed", "Universal Application Engine Initialization Failed", "BootOptions.enableApplicationEngine was set to false", "CRITICAL"},
			{"init-ege-failed", "Essence Game Engine Initialization Failed", "BootOptions.enableGameEngine was set to false", "CRITICAL"},
			{"init-mge-failed", "Membrane GUI Engine Initialization Failed", "BootOptions.enableApplicationEngine was set to false", "MINOR"},
			{"debug-messagetype-invalid", "Invalid argument given for reportDebugMessage (String messageType) in DebugHandler class in Debug Manager package", "Supported Message Types: error, notification", "MINOR"},
			
	};
	
	/* reference this method in code to easily implement a debug error message */
	public void reportError (String errorId) {
		
		/*executes verifyErrorId() method with applicable args */
		this.verifyErrorId(errorId);
		
	}
	
	/* checks the errorMessageRegistry[] array for a match in errorId */
	public void verifyErrorId (String errorId) {
		
		/* loops and scans through errorMessageRegistry[] array */
		for (int counter = 1; counter < errorMessageRegistry.length; counter ++) {
			
			/* found a match */
			if (errorId.equalsIgnoreCase(errorMessageRegistry[counter][0])) {
				
				/* executes buildErrorMessage() method with applicable args */
				this.buildErrorMessage(errorMessageRegistry[counter][1], errorMessageRegistry[counter][2], errorMessageRegistry[counter][3]);
				
			}
			
		}
		
	}
	
	/* builds the error message and dispatches the debug report */
	public void buildErrorMessage (String errorMessage, String errorHint, String errorSeverity) {
		
		/* builds the error message and stores it in message String */
		String message = "[" + errorSeverity + " ERROR] " + errorMessage + " \t HINT: " + errorHint;
		
		/* executes reportDebugMessage() method with applicable args */
		debug.reportDebugMessage("error", message);
	}
	
}
