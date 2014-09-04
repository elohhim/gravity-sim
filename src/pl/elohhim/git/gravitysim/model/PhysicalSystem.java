/**
 * PhysicalSystem.java
 */
package pl.elohhim.git.gravitysim.model;

import java.util.ArrayList;
import java.util.List;

import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public class PhysicalSystem {

	private List<PhysicalObject> objectList;
	
	private static PhysicalConstants physicalConstants = new PhysicalConstants();
	
	/**
	 * default constructor
	 */
	public PhysicalSystem() {
		objectList = new ArrayList<PhysicalObject>();
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
				gravitationalInteraction( objectList.get(i), objectList.get(j) );
			}
		}
	}

	/**
	 * @param object1
	 * @param object2
	 */
	private void gravitationalInteraction(PhysicalObject object1, PhysicalObject object2) {
		//calculating distance between objects
		Vector3D distance = Vector3D.subtract(object2.getRadiusVector(), object1.getRadiusVector());
		
		//calculating gravity force
		double gravityNumerator = physicalConstants.gravitationalConstant * object1.getMass() * object2.getMass();
		double gravityDenominator = Math.pow( distance.value(), 2.0);
		double gravityValue = gravityDenominator / gravityNumerator;
		
		//adding interaction to 1st object
		String name12 = object1.getName() + "_" + object2.getName();
		Force interaction12 = new Force( Vector3D.scaleVector( distance.versor(), gravityValue), name12);
		object1.addForce(interaction12);
		
		//adding interaction to 2nd object
		String name21 = object1.getName() + "-" + object2.getName();
		Force interaction21 = new Force( Vector3D.scaleVector( distance.versor(), -gravityValue), name21);
		object2.addForce(interaction21);
	}
}
