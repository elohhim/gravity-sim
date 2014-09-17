/**
 * PhysicalObject.java
 */
package pl.elohhim.git.gravitysim.model.physics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import pl.elohhim.git.gravitysim.commons.PhysicalObjectMockup;
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

	private List<Force> gravityForces;

	private List<Force> staticForces;

	private Force netForce;

	private Vector3D velocity;

	private Vector3D acceleration;

	/**
	 * @param aCoord1
	 * @param aCoord2
	 * @param aCoord3
	 * @param aMass
	 */
	public PhysicalObject(double aCoord1, double aCoord2, double aCoord3,
			double aMass) {
		super(aCoord1, aCoord2, aCoord3, aMass);
		this.setGravityForces( new ArrayList<Force>() );
		this.setStaticForces( new ArrayList<Force>() );
		this.setNetForce( new Force(0,0,0) );
		this.setVelocity( new Vector3D() );
		this.setAcceleration( new Vector3D() );
		this.setId( counter++ );
		this.setName( "obiekt_" + this.id );
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
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
		return this.name;
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
	public List<Force> getGravityForces() {
		return this.gravityForces;
	}

	/**
	 * @param forces the forces to set
	 */
	public void setGravityForces(List<Force> forces) {
		this.gravityForces = forces;
	}

	/**
	 * @return the netForce
	 */
	public Force getNetForce() {
		return this.netForce;
	}

	/**
	 * @param force
	 */
	private void setNetForce(Force netForce) {
		this.netForce = netForce;
	}

	/**
	 * @return the velocity
	 */
	public Vector3D getVelocity() {
		return this.velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Vector3D velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the acceleration
	 */
	public Vector3D getAcceleration() {
		return this.acceleration;
	}

	/**
	 * @param acceleration the acceleration to set
	 */
	public void setAcceleration(Vector3D acceleration) {
		this.acceleration = acceleration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format( Locale.ENGLISH, "%n %s: %n C: \t %+08e \t %+08e %n V: \t %+08e \t %+08e %n A: \t %+08e \t %+08e %n NF: \t %+08e \t %+08e \t %+08e %n ",
						this.getName(),
						this.coordinates[0], this.coordinates[1],
						this.velocity.getComponents()[0], this.velocity.getComponents()[1],
						this.acceleration.getComponents()[0], this.acceleration.getComponents()[1],
						this.netForce.getComponents()[0], this.netForce.getComponents()[1], this.netForce.value());
	}
	/**
	 * @param gravityForce
	 */
	public void addGravityForce( Force gravityForce) {
		this.getGravityForces().add( gravityForce );
	}

	public void cleanGravityForces() {
		this.getGravityForces().clear();
	}

	public void iterateTimeTick( double timeTick) {
		this.moveObject( timeTick );
		this.calculateVelocity( timeTick );
		this.calculateAcceleration();
	}

	/**
	 *
	 * @param timeTick
	 */
	public void moveObject( double timeTick ) {
		this.setRadiusVector( Vector3D.add( this.getRadiusVector(), this.calculateDisplacement( timeTick ) ) );
	}

	/**
	 *
	 * @param timeTick
	 * @return
	 */
	public Vector3D calculateDisplacement( double timeTick ) {
		//uniform motion
		Vector3D uniformDelta = Vector3D.scaleVector( this.getVelocity(), timeTick );
		//accelerated motion
		Vector3D acceleratedDelta = Vector3D.scaleVector( this.getAcceleration(), Math.pow( timeTick, 2.0 )/2 );
		return Vector3D.add( uniformDelta, acceleratedDelta );

	}
	/**
	 * @param timeTick
	 */
	public void calculateVelocity( double timeTick ) {
		Vector3D deltaV = Vector3D.scaleVector( this.getAcceleration(), timeTick );
		this.setVelocity( Vector3D.add( this.velocity, deltaV ) );
	}

	/**
	 * @return
	 */
	private void calculateAcceleration() {
		this.calculateNetForce();
		this.setAcceleration( Vector3D.scaleVector( this.netForce, 1/this.getMass() ) );
	}

	/**
	 * @return
	 */
	private Force calculateNetForce() {
		// TODO::
		Vector3D netVector = new Vector3D();
		for( Force element : this.gravityForces) {
			netVector = Vector3D.add( netVector, element);
		}
		for( Force element : this.staticForces) {
			netVector = Vector3D.add( netVector, element);
		}

		this.netForce = new Force( netVector, "netForce");
		return this.netForce;
	}

	/**
	 * @return the staticForces
	 */
	public List<Force> getStaticForces() {
		return this.staticForces;
	}

	/**
	 * @param staticForces the staticForces to set
	 */
	public void setStaticForces(List<Force> staticForces) {
		this.staticForces = staticForces;
	}

	/**
	 * @return
	 */
	public PhysicalObjectMockup getMockup() {
		return new PhysicalObjectMockup(
				this.getCoordinates(),
				this.getNetForce().versor().getComponents(),
				this.getVelocity().versor().getComponents(),
				this.getAcceleration().versor().getComponents());
	}

	/**
	 *
	 */
	public void initiate() {
		this.calculateNetForce();
		this.calculateAcceleration();
	}
}
