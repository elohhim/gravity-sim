/**
 * View.java
 */
package pl.elohhim.git.gravitysim.view;

import java.util.concurrent.BlockingQueue;

import javax.swing.SwingUtilities;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.events.SimulationEvent;

/**
 * @author elohhim
 *
 */
public class View {

	private final BlockingQueue<SimulationEvent> blockingQueue;
	
	private AppFrame frame;
		
	/**
	 * Creates new View
	 * 
	 * @param blockingQueue - queue for communication with controller
	 * @param mockup - lightweight representation of model
	 */
	public View(final BlockingQueue<SimulationEvent> blockingQueue, final Mockup mockup){
		this.blockingQueue = blockingQueue;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame = new AppFrame();
				refresh( mockup );
			}
		});
	}
	
	/**
	 * Refreshing view based on Mockup provided from Model 
	 * 
	 * @param mockup - lightweight representation of model
	 */
	public void refresh(final Mockup mockup){
		SwingUtilities.invokeLater(new Runnable() {		
			@Override
			public void run() {
				frame.setSize( 200, 200);
				frame.setVisible(true);
			}
		});
	}

}
