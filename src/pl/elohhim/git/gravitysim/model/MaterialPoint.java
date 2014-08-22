package pl.elohhim.git.gravitysim.model;


/**
 * @author elohhim
 *
 */
public class MaterialPoint extends GeometricPoint {

	private double mass;
	
	/**
	 * default constructor
	 */
	public MaterialPoint() {
		super();
		mass = 1.0;
	}
	
	/**
	 * 3D constructor
	 * @param aCoord1
	 * @param aCoord2
	 * @param aCoord3
	 * @param mass
	 */
	public MaterialPoint( double aCoord1, double aCoord2, double aCoord3, double aMass ) {
		super( aCoord1, aCoord2, aCoord3);
		mass = aMass;
	}
	
	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}
	
}
