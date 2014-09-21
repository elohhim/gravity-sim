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
	public Class<?> type;

	public PhysicalObjectMockup( double[] coordinates, double[] netForceVersor, double[] velocityVersor, double[] accelerationVersor, Class<?> type) {
		this.coordinates = coordinates;
		this.netForceVersor = netForceVersor;
		this.velocityVersor = velocityVersor;
		this.accelerationVersor = accelerationVersor;
		this.type = type;
	}
}
