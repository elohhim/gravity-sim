/**
 * Simulation.java
 */
package pl.elohhim.git.gravitysim.controller.simulation;

import java.util.concurrent.BlockingQueue;

import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.model.Model;

/**
 * @author elohhim
 *
 */
public class Simulation {

	private BlockingQueue<ProgramEvent> blockingQueue;

	private Model model;

	private SimulationState state;

	/**
	 * iteration timeTick [ s ]
	 */
	private double timeTick;

	public Simulation( BlockingQueue<ProgramEvent> blockingQueue ) {
		this.blockingQueue = blockingQueue;
		this.model = new Model( blockingQueue );
		this.state = SimulationState.STOPPED;
		this.timeTick = 10;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the state
	 */
	public SimulationState getState() {
		return this.state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(SimulationState state) {
		this.state = state;
	}

	public void iterate() {
		this.model.iterate( this.timeTick );

	}

	/**
	 *
	 */
	public void reset() {
		this.model = new Model( this.blockingQueue );
	}
}
