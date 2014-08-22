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
		coordinates = new double[3];
		
		coordinates[0] = 0.0;
		coordinates[1] = 0.0;
		coordinates[2] = 0.0;
	}
	
	/**
	 * 
	 * @param aDimensions - quantity of dimensions
	 */
	public GeometricPoint( int aDimensions ) {
		setCoordinates(new double[aDimensions]);
	}
	
	/**
	 * 3D point constructor
	 * @param aCoord1
	 * @param aCoord2
	 * @param aCoord3
	 */
	public GeometricPoint( double aCoord1, double aCoord2, double aCoord3 )	{
		coordinates = new double[3];
		coordinates[0] = aCoord1;
		coordinates[1] = aCoord2;
		coordinates[2] = aCoord3;
		
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
