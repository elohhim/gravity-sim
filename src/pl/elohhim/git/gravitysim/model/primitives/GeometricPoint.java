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
		this.setCoordinates(new double[dimensions]);
	}

	/**
	 * @return the coordinates
	 */
	public double[] getCoordinates() {
		return this.coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

	public double getCoordinate( int which) {
		return this.coordinates[which];
	}

	public void setCoordinate( int which, double coordinate) {
		this.coordinates[which] = coordinate;
	}
}
