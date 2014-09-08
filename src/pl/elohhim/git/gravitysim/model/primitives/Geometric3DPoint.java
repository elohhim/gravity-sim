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
	

	/**
	 * @return the radiusVector
	 */
	public Vector3D getRadiusVector() {
		return new Vector3D( this.coordinates[0], this.coordinates[1], this.coordinates[2]);
	}

	/**
	 * @param radiusVector the radiusVector to set
	 */
	public void setRadiusVector(Vector3D radiusVector) {
		for( int i=0 ; i<3 ; i++) {
			this.setCoordinate(i, radiusVector.getComponents()[i]);
		}
	}

}
