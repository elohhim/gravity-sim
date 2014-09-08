/**
 * PhysicalObject.java
 */
package pl.elohhim.git.gravitysim.model.physics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.elohhim.git.gravitysim.model.primitives.MaterialPoint;
import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public class PhysicalObject extends MaterialPoint {
	
	private static int counter = 1;
	
	private int id;

	private String name;
	
	private List<Force> forces;
	
	private List<Force> staticForces;
	
	private Vector3D velocity;
	
	/**
	 * 
	 */
	public PhysicalObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param aCoord1
	 * @param aCoord2
	 * @param aCoord3
	 * @param aMass
	 */
	public PhysicalObject(double aCoord1, double aCoord2, double aCoord3,
			double aMass) {
		super(aCoord1, aCoord2, aCoord3, aMass);
		setForces( new ArrayList<Force>() );
		setStaticForces( new ArrayList<Force>() );
		setVelocity( new Vector3D());
		setId( counter++ );
		setName( "obiekt_" + this.id );
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the forces
	 */
	public List<Force> getForces() {
		return forces;
	}

	/**
	 * @param forces the forces to set
	 */
	public void setForces(List<Force> forces) {
		this.forces = forces;
	}
	
	/**
	 * @return the velocity
	 */
	public Vector3D getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Vector3D velocity) {
		this.velocity = velocity;
	}

	/**
	 * @param force
	 */
	public void addForce( Force force) {
		getForces().add( force );
	}

	public void cleanForces() {
		getForces().clear();
	}

	/**
	 * 
	 * @param timeTick
	 */
	public void moveObject( double timeTick) {
		this.setRadiusVector( Vector3D.add(this.getRadiusVector(), this.calculateDisplacement(timeTick)));
	}
	
	/**
	 * 
	 * @param timeTick
	 * @return
	 */
	public Vector3D calculateDisplacement( double timeTick) {
		calculateVelocity(timeTick);
		Vector3D delta = Vector3D.scaleVector( getVelocity(), timeTick);
		return delta;
	}
	/**
	 * @param timeTick
	 */
	public void calculateVelocity(double timeTick) {
		Vector3D acceleration = calculateAcceleration();
		Vector3D delta = Vector3D.scaleVector(acceleration, timeTick);
		setVelocity( Vector3D.add(velocity, delta));
	}

	/**
	 * @return
	 */
	private Vector3D calculateAcceleration() {
		Force netForce = calculateNetForce();
		return Vector3D.scaleVector(netForce, 1/getMass());
	}

	/**
	 * @return
	 */
	private Force calculateNetForce() {
		// TODO::
		Vector3D netVector = new Vector3D();
		for( Force element : forces) {
			netVector = Vector3D.add( netVector, element);
		}
		for( Force element : staticForces) {
			netVector = Vector3D.add( netVector, element);
		}
		
		return new Force( netVector, "netForce");
	}

	/**
	 * @return the staticForces
	 */
	public List<Force> getStaticForces() {
		return staticForces;
	}

	/**
	 * @param staticForces the staticForces to set
	 */
	public void setStaticForces(List<Force> staticForces) {
		this.staticForces = staticForces;
	}
}
