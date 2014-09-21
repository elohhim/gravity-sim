/**
 * PhysicalSystem.java
 */
package pl.elohhim.git.gravitysim.model.physics;

import java.util.ArrayList;
import java.util.List;

import pl.elohhim.git.gravitysim.commons.PhysicalObjectMockup;
import pl.elohhim.git.gravitysim.model.physics.gravitation.IGravitation;
import pl.elohhim.git.gravitysim.model.physics.gravitation.ParticleParticleGravitation;
import pl.elohhim.git.gravitysim.model.physics.spaceObjects.Planet;
import pl.elohhim.git.gravitysim.model.physics.spaceObjects.Satelite;
import pl.elohhim.git.gravitysim.model.physics.spaceObjects.Star;
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
		this.objectList = new ArrayList<PhysicalObject>();
		this.gravitation = new ParticleParticleGravitation();
	}

	public void populateSystem() {
		Star sun = new Star(0,0,0,1.98855e30, "Sun");
		this.objectList.add( sun );
		Planet earth = new Planet(149600e6,0,0,5.9736e24, "Earth");
		earth.setName("Ziemia");
		earth.setVelocity( new Vector3D(0, 29.783e3, 0) );
		this.objectList.add( earth);
		Satelite moon = new Satelite( 149600e6 ,384400e3, 0, 7.347673e22, "Moon");
		moon.setName("Ksiezyc");
		moon.setVelocity( new Vector3D(1.022e3, 29.783e3, 0));
		this.objectList.add( moon);
		for( PhysicalObject element : this.getObjectsList() ) {
			this.calculateGravityForces();
			element.initiate();
		}
	}

	public void iterateTimeTick( double timeTick) {
		this.calculateGravityForces();
		for( PhysicalObject element : this.objectList) {
			element.iterateTimeTick(timeTick);
		}
	}
	/**
	 *
	 */
	public void calculateGravityForces() {
		// cleaning
		for( PhysicalObject element : this.objectList) {
			element.cleanGravityForces();
		}
		for( int i = 0; i < this.objectList.size() - 1; i++ ) {
			for( int j = i+1; j < this.objectList.size(); j++) {
				this.gravitation.gravitationalInteraction( this.objectList.get(i), this.objectList.get(j) );
			}
		}
	}

	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for ( PhysicalObject element : this.objectList) {
			names.add(element.getName() );
		}
		return names;
	}

	/**
	 * @return
	 */
	public ArrayList<PhysicalObjectMockup> getObjectsMockups() {
		ArrayList<PhysicalObjectMockup> mockupsList = new ArrayList<PhysicalObjectMockup>();
		for( PhysicalObject element : this.objectList) {
			mockupsList.add( element.getMockup() );
		}
		return mockupsList;
	}

	/**
	 * @return
	 */
	public  List<PhysicalObject> getObjectsList() {
		return this.objectList;
	}

}
