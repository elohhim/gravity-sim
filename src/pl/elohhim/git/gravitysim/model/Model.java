/**
 * Model.java
 */
package pl.elohhim.git.gravitysim.model;

import java.util.ArrayList;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.model.physics.PhysicalSystem;

/**
 * @author admin
 *
 */
public class Model {

	private PhysicalSystem physicalSystem;
	
	public Model() {
		physicalSystem = new PhysicalSystem();
		physicalSystem.populateSystem();
	}
	
	/**
	 * @return
	 */
	public Mockup getMockup() {
		ArrayList<Double> coords = physicalSystem.getCoords();
		ArrayList<String> names = physicalSystem.getNames();
		return new Mockup( names, coords);
	}
	
	public void iterate( double timeTick) {
		physicalSystem.iterateTimeTick( timeTick);
	}

}
