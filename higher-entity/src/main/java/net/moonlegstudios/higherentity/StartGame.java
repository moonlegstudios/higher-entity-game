package net.moonlegstudios.higherentity;

import net.moonlegstudios.higherentity.essencegameengine.EssenceGameEngine;
import net.moonlegstudios.higherentity.membraneguiengine.MembraneGuiEngine;
import net.moonlegstudios.higherentity.universalapplicationengine.BootOptions;
import net.moonlegstudios.higherentity.universalapplicationengine.UniversalApplicationEngine;

public class StartGame implements BootOptions, EssenceGameEngine, MembraneGuiEngine, UniversalApplicationEngine {
	
	
	public static void main (String[] args) {
		
		notify.reportNotification("program-launching");
		
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
