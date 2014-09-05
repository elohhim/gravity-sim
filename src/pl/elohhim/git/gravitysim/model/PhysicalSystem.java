/**
 * PhysicalSystem.java
 */
package pl.elohhim.git.gravitysim.model;

import java.util.ArrayList;
import java.util.List;

import pl.elohhim.git.gravitysim.model.physics.gravitation.Gravitation;
import pl.elohhim.git.gravitysim.model.physics.gravitation.ParticleParticleGravitation;
import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public class PhysicalSystem {

	private List<PhysicalObject> objectList;
	
	private Gravitation gravitation;
	
	private static PhysicalConstants physicalConstants = new PhysicalConstants();
	
	/**
	 * default constructor
	 */
	public PhysicalSystem() {
		objectList = new ArrayList<PhysicalObject>();
		gravitation = new ParticleParticleGravitation();
	}
	
	public void populateSystem() {
		objectList.add( new PhysicalObject( 1, 1, 1, 2));
		objectList.add( new PhysicalObject( 0, 0, 0, 1));
	}
	
	/**
	 * 
	 */
	public void calculateGravityForces() {
		for( int i = 0; i < objectList.size() - 1; i++ ) {
			for( int j = i+1; j < objectList.size(); j++) {
				gravitation.gravitationalInteraction( objectList.get(i), objectList.get(j) );
			}
		}
	}
	
	public void calculateDisplacements( double timeTick) {
		for( PhysicalObject element : objectList) {
			element.calculateDisplacement(timeTick);
		}
	}
	
}
