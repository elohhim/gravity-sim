package pl.elohhim.git.gravitysim;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import pl.elohhim.git.gravitysim.controller.Controller;
import pl.elohhim.git.gravitysim.controller.simulation.Simulation;
import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.view.View;

/**
 * Application.java
 */

/**
 * @author elohhim
 *
 */
public final class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			final BlockingQueue<ProgramEvent> blockingQueue  = new LinkedBlockingQueue<ProgramEvent>();
			final Simulation simulation = new Simulation( blockingQueue );
			final View view = new View( blockingQueue, simulation.getModel().getMockup() );
			final Controller controller = new Controller( view, simulation, blockingQueue );
			controller.work();
		}
		catch( Exception e ){
			e.printStackTrace();
			System.exit( 1 );
		}
	}

}
