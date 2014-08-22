package pl.elohhim.git.gravitysim.model.primitives;

/**
 * represents point in Cartesian coordinate system
 * @author elohhim
 *
 */
public class GeometricPoint {
	
	protected double[] coordinates;
	
	/**
	 * 
	 * @param dimensions - quantity of dimensions
	 */
	public GeometricPoint( int dimensions ) {
		setCoordinates(new double[dimensions]);
	}
	
	/**
	 * @return the coordinates
	 */
	public double[] getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}
	
	public double getCoordinate( int which) {
		return coordinates[which];
	}
	
	public void setCoordinate( int which, double coordinate) {
		coordinates[which] = coordinate;
	}
}
