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
	public double[] velocityVersor;
	public double[] accelerationVersor;

	public PhysicalObjectMockup( double[] coordinates, double[] netForceVersor, double[] velocityVersor, double[] accelerationVersor) {
		this.coordinates = coordinates;
		this.netForceVersor = netForceVersor;
		this.velocityVersor = velocityVersor;
		this.accelerationVersor = accelerationVersor;
	}
}
