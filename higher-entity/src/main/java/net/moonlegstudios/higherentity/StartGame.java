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
	
	public void start (Stage stage) {}
	
	public static void main (String[] args) {
		
		/* loads universal application engine first */
		if (enableApplicationEngine) {
			
			ua_engine.initUAE();
			
			/* loads essence game engine second */
			if (enableGameEngine) {
				
				eg_engine.initEGE();
				
				/* loads membrane gui engine last */
				if (enableGuiEngine) {
					
					mg_engine.initMGE();
				
				/* enableGuiEngine = false */
				} else {
					
					error.reportError("init-mge-failed");
					notify.reportNotification("enabled-no-gui-mode");
					
				}
				
			/* enableGameEngine = false */
			} else {
				
				error.reportError("init-ege-failed");
				
			}
			
		/* enableApplicationEngine = false */
		} else {
			
			error.reportError("init-ege-failed");
			
		}
		
	}
	
}
