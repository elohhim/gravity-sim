/**
 * Force.java
 */
package pl.elohhim.git.gravitysim.model;

import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public class Force extends Vector3D {

	private String name;
	/**
	 * @param a1
	 * @param a2
	 * @param a3
	 */
	public Force(double a1, double a2, double a3) {
		super(a1, a2, a3);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param scaleVector
	 * @param name2
	 */
	public Force(Vector3D vector, String name) {
		this.setComponents( vector.getComponents());
		this.setName(name);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
