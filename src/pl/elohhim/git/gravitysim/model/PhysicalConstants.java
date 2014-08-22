/**
 * PhysicalConstants.java
 */
package pl.elohhim.git.gravitysim.model;

/**
 * parameters describing universe physics
 * preferably use SI, but there is no units at all
 * @author admin
 *
 */
public class PhysicalConstants {

	public double gravitationalConstant;
	
	/**
	 * default constructor
	 */
	public PhysicalConstants() {
		gravitationalConstant = Math.pow( 6.67384*10, -11.0);
	}
		
}
