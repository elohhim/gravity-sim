/**
 * IMotion.java
 */
package pl.elohhim.git.gravitysim.model.physics.kinematics;

import pl.elohhim.git.gravitysim.model.physics.Force;
import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public interface IMotion {
	public Vector3D getDisplacement( double timetick );
	
	public void iterateMotion( double timetick, Vector3D acceleration );
}
