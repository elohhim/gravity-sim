package pl.elohhim.git.gravitysim.model.primitives;



/**
 * material point in 3D Cartesian CS
 * @author elohhim
 *
 */
public class MaterialPoint extends Geometric3DPoint {

	private double mass;
	private Vector3D speed;


	/**
	 * default constructor
	 */
	public MaterialPoint() {
		super( 0, 0, 0);
		this.mass = 1.0;
		this.setSpeed(new Vector3D( 0, 0, 0));
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
		this.mass = aMass;
		this.setSpeed(new Vector3D( 0, 0, 0));
	}

	/**
	 * @return the mass
	 */
	public double getMass() {
		return this.mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/**
	 * @return the speed
	 */
	public Vector3D getSpeed() {
		return this.speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(Vector3D speed) {
		this.speed = speed;
	}

}
