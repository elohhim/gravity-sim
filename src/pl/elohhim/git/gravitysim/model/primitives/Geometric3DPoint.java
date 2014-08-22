/**
 * Geometric3DPoint.java
 */
package pl.elohhim.git.gravitysim.model.primitives;

/**
 * @author admin
 *
 */
public class Geometric3DPoint extends GeometricPoint {

	/**
	 * @param dimensions
	 */
	public Geometric3DPoint( double coord1, double coord2, double coord3) {
		super(3);
		this.coordinates[0] = coord1;
		this.coordinates[1] = coord2;
		this.coordinates[2] = coord3;	
	}

}
