/**
 * PhysicalObjectMockup.java
 */
package pl.elohhim.git.gravitysim.commons;

/**
 * @author elohhim
 *
 */
public class PhysicalObjectMockup {
	public double[] coordinates;
	public double[] netForceVersor;
	
	public PhysicalObjectMockup( double[] coordinates, double[] netForceVersor) {
		this.coordinates = coordinates;
		this.netForceVersor = netForceVersor;
	}	
}
