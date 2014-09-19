/**
 * Controller.java
 */
package pl.elohhim.git.gravitysim.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.controller.simulation.Simulation;
import pl.elohhim.git.gravitysim.controller.simulation.SimulationState;
import pl.elohhim.git.gravitysim.events.NextIterationEvent;
import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.events.ViewReadyEvent;
import pl.elohhim.git.gravitysim.events.ViewRefreshEvent;
import pl.elohhim.git.gravitysim.events.simulation.PauseSimulationEvent;
import pl.elohhim.git.gravitysim.events.simulation.ResumeSimulationEvent;
import pl.elohhim.git.gravitysim.events.simulation.StartSimulationEvent;
import pl.elohhim.git.gravitysim.events.simulation.StopSimulationEvent;
import pl.elohhim.git.gravitysim.model.physics.PhysicalObject;
import pl.elohhim.git.gravitysim.view.View;

/**
 * @author elohhim
 *
 */
public class Controller {

	/** reference to View from MVC*/
	private final View view;
	/** reference to Model from MVC*/
	private final Simulation simulation;
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
	public Controller(final View view, final  Simulation simulation, final BlockingQueue<ProgramEvent> blockingQueue) {
		this.view = view;
		this.simulation = simulation;
		this.blockingQueue = blockingQueue;
		this.eventActionMap = new HashMap<Class<? extends ProgramEvent>, ProgramAction>();
		this.fillEventActionMap();
	}

	/**
	 * infinite loop to intercept events from view
	 * <br> it takes events from blockingQueue and using eventActionMap
	 * starts action handling this event
	 * @throws InterruptedException
	 */
	public void work() throws InterruptedException
	{
		ProgramEvent event = null;
		while(true)
		{
			try
			{
				event = this.blockingQueue.take();
				ProgramAction action = this.eventActionMap.get(event.getClass());
				action.go(event);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * fills container eventActionMap
	 */
	private void fillEventActionMap()
	{
		this.eventActionMap.put( NextIterationEvent.class, new ProgramAction()
		{
			@Override
			public void go( ProgramEvent event )
			{
				NextIterationEvent nIE = (NextIterationEvent) event;
				if ( Controller.this.simulation.getState() == SimulationState.RUNNING) {
					//System.out.println( "Iteration " + event.getId() );
					Controller.this.simulation.iterate();
					Mockup mockup = Controller.this.simulation.getModel().getMockup();
					if (nIE.getIterationId() % 300 == 0) {
						Controller.this.blockingQueue.add(new ViewRefreshEvent(mockup));
						/*
						PhysicalObject element = simulation.getModel().getPhysicalSystem().getObjectsList().get(1);
						//for( PhysicalObject element : simulation.getModel().getPhysicalSystem().getObjectsList() )
							System.out.print( element );
						//*/
					}
					Controller.this.blockingQueue.add(new NextIterationEvent());
				} else {
					System.out.println( "Event: " + nIE.getId() + " is empty run." );
				}
			}
		});

		this.eventActionMap.put( ViewRefreshEvent.class, new ProgramAction()
		{
			@Override
			public void go( ProgramEvent event ) {
				ViewRefreshEvent vRE = ( ViewRefreshEvent ) event;
				Controller.this.view.refresh( vRE.mockup );
			}
		});

		this.eventActionMap.put( ViewReadyEvent.class, new ProgramAction() {

			@Override
			public void go( ProgramEvent event ) {
				@SuppressWarnings("unused")
				ViewReadyEvent vRE = ( ViewReadyEvent ) event;
			}
		});

		this.eventActionMap.put( StartSimulationEvent.class, new ProgramAction()
		{
			@Override
			public void go( ProgramEvent event ) {
				StartSimulationEvent sSE = ( StartSimulationEvent) event;

				Controller.this.simulation.setState( SimulationState.RUNNING );
				Controller.this.blockingQueue.add( new NextIterationEvent() );
			}
		});

		this.eventActionMap.put( PauseSimulationEvent.class, new ProgramAction() {

			@Override
			public void go( ProgramEvent event) {
				PauseSimulationEvent pSE = ( PauseSimulationEvent ) event;
				Controller.this.simulation.setState( SimulationState.PAUSED );
			}
		});

		this.eventActionMap.put( ResumeSimulationEvent.class, new ProgramAction() {

			@Override
			public void go( ProgramEvent event) {
				ResumeSimulationEvent rSE = ( ResumeSimulationEvent ) event;

				Controller.this.simulation.setState( SimulationState.RUNNING );
				Controller.this.blockingQueue.add( new NextIterationEvent() );
			}
		});

		this.eventActionMap.put( StopSimulationEvent.class, new ProgramAction() {

			@Override
			public void go( ProgramEvent event) {
				StopSimulationEvent sSE = ( StopSimulationEvent ) event;

				Controller.this.simulation.setState( SimulationState.STOPPED );
				Controller.this.simulation.reset();
				Controller.this.blockingQueue.add( new ViewRefreshEvent( Controller.this.simulation.getModel().getMockup() ) );
			}
		});
	}//*/

}
