/**
 * Controller.java
 */
package pl.elohhim.git.gravitysim.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.events.NextIterationEvent;
import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.model.Model;
import pl.elohhim.git.gravitysim.view.View;

/**
 * @author elohhim
 *
 */
public class Controller {

	/** reference to View from MVC*/
	private final View view;
	/** reference to Model from MVC*/
	private final Model model;
	/**queue for ProgramEvent.*/
	private final BlockingQueue<ProgramEvent> blockingQueue;
	/**mapping of objects ProgramEvent to objects ProgramAction*/
	private final Map<Class<? extends ProgramEvent>, ProgramAction> eventActionMap;
	
	/**
	 * creates object of Controller type
	 * 
	 * @param view reference to view
	 * @param model reference to model
	 * @param blockingQueue reference to blockingQueue for communication
	 */
	public Controller(final View view, final  Model model, final BlockingQueue<ProgramEvent> blockingQueue) {
		this.view = view;
		this.model = model;
		this.blockingQueue = blockingQueue;
		eventActionMap = new HashMap<Class<? extends ProgramEvent>, ProgramAction>();
		fillEventActionMap();
	}
	
	/**
	 * infinite loop to intercept events from view
	 * <br> it takes events from blockingQueue and using eventActionMap 
	 * starts action handling this event
	 */
	public void work()
	{	
		
		while(true)
		{
			try
			{
				ProgramEvent event = blockingQueue.take();
				ProgramAction action = eventActionMap.get(event.getClass());
				action.go(event);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * fills container eventActionMap
	 */
	private void fillEventActionMap()
	{
		eventActionMap.put(NextIterationEvent.class, new ProgramAction()
		{
			public void go(ProgramEvent event)
			{
				NextIterationEvent nIE = (NextIterationEvent) event;
				System.out.println( "Iteration " + event.getId() );
				Mockup mockup = model.getMockup();
				for( int i = 0; i < mockup.names.size(); i++) {
					System.out.println( 
							mockup.names.get( i ) + 
							": " +
							mockup.coordinates.get( 3*i ) +
							" " +
							mockup.coordinates.get( 3*i+1) +
							" " +
							mockup.coordinates.get( 3*i + 2));
				}
				view.refresh( mockup );
				model.iterate( nIE.getTimePassed() );
			}
		});
	}//*/

}
