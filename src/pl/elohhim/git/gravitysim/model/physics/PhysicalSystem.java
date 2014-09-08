/**
 * PhysicalSystem.java
 */
package pl.elohhim.git.gravitysim.model.physics;

import java.util.ArrayList;
import java.util.List;

import pl.elohhim.git.gravitysim.model.physics.gravitation.IGravitation;
import pl.elohhim.git.gravitysim.model.physics.gravitation.ParticleParticleGravitation;
import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public class PhysicalSystem {

	private List<PhysicalObject> objectList;
	
	private IGravitation gravitation;
	
	/**
	 * default constructor
	 */
	public PhysicalSystem() {
		objectList = new ArrayList<PhysicalObject>();
		gravitation = new ParticleParticleGravitation();
	}
	
	public void populateSystem() {
		PhysicalObject p1 = new PhysicalObject(0,0,0,2000);
		p1.setVelocity( new Vector3D(0,0,0));
		p1.getStaticForces().add( new Force(10,0,0));
		objectList.add( p1);
		//objectList.add( new PhysicalObject( 0, 0, 0, 1000));
	}
	
	public void iterateTimeTick( double timeTick) {
		// cleaning
		for( PhysicalObject element : objectList) {
			element.cleanForces();
		}
		
		calculateGravityForces();
		
		moveObjects(timeTick);
	}
	/**
	 * 
	 */
	public void calculateGravityForces() {
		for( int i = 0; i < objectList.size() - 1; i++ ) {
			for( int j = i+1; j < objectList.size(); j++) {
				gravitation.gravitationalInteraction( objectList.get(i), objectList.get(j) );
				System.out.println("Added interaction: " + i + "-" + j );
			}
		}
	}
	
	public void moveObjects( double timeTick) {
		for( PhysicalObject element : objectList) {
			element.moveObject(timeTick);
		}
	}

	public ArrayList<Double> getCoords() {
		ArrayList<Double> coords = new ArrayList<Double>();
		for ( PhysicalObject element : objectList) {
			coords.add(element.getCoordinate(0) );
			coords.add(element.getCoordinate(1) );
			coords.add(element.getCoordinate(2) );
		}
		return coords;
	}

	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for ( PhysicalObject element : objectList) {
			names.add(element.getName() );
		}
		return names;
	}
	
}
