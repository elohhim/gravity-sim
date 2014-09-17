/**
 * Gravitation.java
 */
package pl.elohhim.git.gravitysim.model.physics.gravitation;

import pl.elohhim.git.gravitysim.model.physics.Force;
import pl.elohhim.git.gravitysim.model.physics.PhysicalObject;

/**
 * @author elohhim
 *
 */
public interface IGravitation {

	/**
	 * adding gravitational interaction between two PhysicalObjects
	 * @param object1
	 * @param object2
	 */
	public abstract Force gravitationalInteraction(PhysicalObject object1, PhysicalObject object2);

	/**
	 * returns value of gravitational constant
	 * @return gravitationalConstant
	 */
	public abstract double getGravitationalConstant();

	/**
	 * enables setting value of gravitational constant
	 * @param gravitationalConstant
	 */
	public abstract void setGravitationalConstant( double gravitationalConstant );

}
