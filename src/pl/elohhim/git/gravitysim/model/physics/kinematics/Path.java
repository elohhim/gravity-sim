/**
 * Path.java
 */
package pl.elohhim.git.gravitysim.model.physics.kinematics;

import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public class Path {
	
	private Vector3D versorTangent;
	private double radiusOfCurvature;
	
	public Path() {
		radiusOfCurvature = 0.0;
		versorTangent = new Vector3D( 0, 0, 0 );
	}
	
	public Path( Vector3D versorTangent, double radiusOfCurvature) {
		this.versorTangent = versorTangent;
		this.radiusOfCurvature = radiusOfCurvature;
	}
}
