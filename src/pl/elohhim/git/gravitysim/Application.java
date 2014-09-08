package pl.elohhim.git.gravitysim;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import pl.elohhim.git.gravitysim.controller.Controller;
import pl.elohhim.git.gravitysim.events.SimulationEvent;
import pl.elohhim.git.gravitysim.model.Model;
import pl.elohhim.git.gravitysim.view.View;

/**
 * Application.java
 */

/**
 * @author admin
 *
 */
public final class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			final Model model = new Model();
			final BlockingQueue<SimulationEvent> blockingQueue  = new LinkedBlockingQueue<SimulationEvent>();
			final View view = new View(blockingQueue, model.getMockup());
			final Controller controller = new Controller(view,model,blockingQueue);
			controller.work();
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}

}
