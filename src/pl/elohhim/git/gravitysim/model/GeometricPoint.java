package pl.elohhim.git.gravitysim.model;

/**
 * represents point in Cartesian coordinate system
 * @author elohhim
 *
 */
public class GeometricPoint {
	
	private double[] coordinates;
	
	/**
	 * default constructor, creating point in 3D
	 */
	public GeometricPoint() {
		setCoordinates(new double[3]);
	}
	
	/**
	 * 
	 * @param aDimensions - quantity of dimensions
	 */
	public GeometricPoint( int aDimensions ) {
		setCoordinates(new double[aDimensions]);
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
	
	
}
