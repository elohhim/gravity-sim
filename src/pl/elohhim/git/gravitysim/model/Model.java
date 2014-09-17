/**
 * Model.java
 */
package pl.elohhim.git.gravitysim.model;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.commons.PhysicalObjectMockup;
import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.model.physics.PhysicalSystem;

/**
 * @author elohhim
 *
 */
public class Model {

	private final BlockingQueue<ProgramEvent> blockingQueue;

	private PhysicalSystem physicalSystem;

	/**
	 * @return the physicalSystem
	 */
	public PhysicalSystem getPhysicalSystem() {
		return this.physicalSystem;
	}

	public Model( BlockingQueue<ProgramEvent> blockingQueue ) {
		this.blockingQueue = blockingQueue;

		this.physicalSystem = new PhysicalSystem();
		this.physicalSystem.populateSystem();
	}

	/**
	 * @return
	 */
	public Mockup getMockup() {
		ArrayList<String> names = this.physicalSystem.getNames();
		ArrayList<PhysicalObjectMockup> objects = this.physicalSystem.getObjectsMockups();
		return new Mockup( names, objects);
	}

	public void iterate( double timeTick) {
		this.physicalSystem.iterateTimeTick( timeTick);
		//blockingQueue.add( new NextIterationEvent(1) );
	}

}
