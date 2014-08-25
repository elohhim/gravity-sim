/**
 * Vector3D.java
 */
package pl.elohhim.git.gravitysim.model.primitives;

/**
 * @author elohhim
 *
 */
public class Vector3D {

	private double[] components;
	/**
	 * default constructor
	 */
	public Vector3D( double a1, double a2, double a3) {
		setComponents(new double[3]);
		components[0] = a1;
		components[0] = a2;
		components[0] = a3;
	}
	/**
	 * @return the components
	 */
	public double[] getComponents() {
		return components;
	}
	/**
	 * @param components the components to set
	 */
	public void setComponents(double[] components) {
		this.components = components;
	}

}
