/**
 * Trajectory.java
 */
package pl.elohhim.git.gravitysim.model.physics.kinematics;

import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public class CurvilinearMotion implements IMotion {
	
	private Path motionPath;
	
	private Vector3D velocity;
	
	private Vector3D acceleration;
	
	private Vector3D tangentialAcceleration;
	
	private Vector3D radiusAcceleration;

	
	public CurvilinearMotion( Vector3D velocity, Vector3D acceleration, double radiusOfCurvature ) {
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.motionPath = new Path( velocity.versor(), radiusOfCurvature );
	}
	
	/* (non-Javadoc)
	 * @see pl.elohhim.git.gravitysim.model.physics.kinematics.IMotion#iterateMotion(double, pl.elohhim.git.gravitysim.model.physics.Force)
	 */
	@Override
	public void iterateMotion( double timeTick, Vector3D acceleration ) {
		
		calculateVelocity( timeTick );
		
		this.acceleration = acceleration;
	}
		
	/**
	 * @param timeTick
	 */
	public void calculateVelocity( double timeTick ) {
		Vector3D deltaV = Vector3D.scaleVector( this.acceleration , timeTick );
		this.velocity = Vector3D.add( this.velocity, deltaV );
	}
	
	/* (non-Javadoc)
	 * @see pl.elohhim.git.gravitysim.model.physics.kinematics.IMotion#calculateDisplacement(double)
	 */
	@Override
	public Vector3D getDisplacement( double timeTick ) {
		//uniform motion
		Vector3D uniformDelta = Vector3D.scaleVector( this.velocity, timeTick );
		//accelerated motion
		Vector3D acceleratedDelta = Vector3D.scaleVector( this.acceleration, Math.pow( timeTick, 2.0 )/2 );
		return Vector3D.add( uniformDelta, acceleratedDelta );
	}
}
