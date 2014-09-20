/**
 * View.java
 */
package pl.elohhim.git.gravitysim.view;

import java.util.concurrent.BlockingQueue;

import javax.swing.SwingUtilities;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.events.view.ViewReadyEvent;

/**
 * @author elohhim
 *
 */
public class View {

	private final BlockingQueue<ProgramEvent> blockingQueue;

	private AppFrame frame;

	/**
	 * Creates new View
	 *
	 * @param blockingQueue - queue for communication with controller
	 * @param mockup - lightweight representation of model
	 */
	public View(final BlockingQueue<ProgramEvent> blockingQueue, final Mockup mockup){
		this.blockingQueue = blockingQueue;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				View.this.frame = new AppFrame(blockingQueue, mockup);
				View.this.frame.setVisible(true);
				blockingQueue.add( new ViewReadyEvent() );
			}
		});
	}

	/**
	 * Refreshing view based on Mockup provided from Model
	 *
	 * @param mockup - lightweight representation of model
	 */
	public void refresh(final Mockup mockup) {
		try {
			this.frame.setMockup(mockup);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		this.frame.repaint();
	}

	public void rescaleDrawPanel( double scaleExponent ) {
		this.frame.rescaleDrawPanel( scaleExponent );
	}

}
