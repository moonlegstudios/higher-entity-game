package net.moonlegstudios.higherentity;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import net.moonlegstudios.higherentity.essencegameengine.EssenceGameEngine;
import net.moonlegstudios.higherentity.membraneguiengine.MembraneGuiEngine;
import net.moonlegstudios.higherentity.universalapplicationengine.UniversalApplicationEngine;
import net.moonlegstudios.higherentity.universalapplicationengine.BootOptions;

public class StartGame extends Application implements BootOptions, EssenceGameEngine, MembraneGuiEngine, UniversalApplicationEngine {

	Scene scene;
	Parent root;
	
	public void start (Stage stage) {
		
		
		
	}
	
	public static void main (String[] args) {
		
		/* loads universal application engine first */
		if (enableApplicationEngine) {
			
			UniversalApplicationEngine.initializeUAE();
			
			/* loads essence game engine second */
			if (enableGameEngine) {
				
				EssenceGameEngine.initializeEGE();
				
				/* loads membrane gui engine last */
				if (enableGuiEngine) {
					
					MembraneGuiEngine.initializeMGE();
				
				/* enableGuiEngine = false */
				} else {
					
					/* TODO: Add error message - MGE did not initialize, launching in console mode */
					
				}
				
			/* enableGameEngine = false */
			} else {
				
				/* TODO: Add error message - EGE did not initialize, cannot launch program - reason: enableGameEngine = false - severity: critical */
				
			}
			
		/* enableApplicationEngine = false */
		} else {
			
			/* TODO: Add error message - UAE did not initialize, cannot launch program - reason: enableApplicationEngine = false - severity: critical */
			
		}
		
	}
	
}
