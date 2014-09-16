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
	
	public Model( BlockingQueue<ProgramEvent> blockingQueue ) {
		this.blockingQueue = blockingQueue;
		
		physicalSystem = new PhysicalSystem();
		physicalSystem.populateSystem();
	}
	
	/**
	 * @return
	 */
	public Mockup getMockup() {
		ArrayList<String> names = physicalSystem.getNames();
		ArrayList<PhysicalObjectMockup> objects = physicalSystem.getObjectsMockups();
		return new Mockup( names, objects);
	}
	
	public void iterate( double timeTick) {
		physicalSystem.iterateTimeTick( timeTick);
		//blockingQueue.add( new NextIterationEvent(1) );
	}

}
