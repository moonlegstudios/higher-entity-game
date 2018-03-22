package net.moonlegstudios.higherentity.universalapplicationengine;

import net.moonlegstudios.higherentity.universalapplicationengine.debugmanager.DebugNotification;
import net.moonlegstudios.higherentity.universalapplicationengine.debugmanager.DebugError;
import net.moonlegstudios.higherentity.universalapplicationengine.debugmanager.DebugHandler;
import net.moonlegstudios.higherentity.universalapplicationengine.threadmanager.ThreadManager;

public interface UniversalApplicationEngine {

	/* accessible classes within same package */
	ThreadManager manager_threads = new ThreadManager ();
	InitializeUAE ua_engine = new InitializeUAE ();
	
	/* accessible classes within sub-packages *
	/* debug manager package */
	DebugHandler debug = new DebugHandler ();
	DebugError error = new DebugError ();
	DebugNotification notify = new DebugNotification ();
	
}
