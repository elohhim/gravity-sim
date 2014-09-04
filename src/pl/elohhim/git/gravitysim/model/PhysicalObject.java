/**
 * PhysicalObject.java
 */
package pl.elohhim.git.gravitysim.model;

import java.util.ArrayList;
import java.util.List;

import pl.elohhim.git.gravitysim.model.primitives.MaterialPoint;

/**
 * @author elohhim
 *
 */
public class PhysicalObject extends MaterialPoint {
	
	private static int counter = 1; 

	private String name;
	
	private List<Force> forces;
	/**
	 * 
	 */
	public PhysicalObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param aCoord1
	 * @param aCoord2
	 * @param aCoord3
	 * @param aMass
	 */
	public PhysicalObject(double aCoord1, double aCoord2, double aCoord3,
			double aMass) {
		super(aCoord1, aCoord2, aCoord3, aMass);
		setForces( new ArrayList<Force>() );
		setName( "obiekt_" + counter++ );
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

	/**
	 * @return the forces
	 */
	public List<Force> getForces() {
		return forces;
	}

	/**
	 * @param forces the forces to set
	 */
	public void setForces(List<Force> forces) {
		this.forces = forces;
	}
	
	/**
	 * @param force
	 */
	public void addForce( Force force) {
		getForces().add( force );
	}

	public void cleanForces() {
		getForces().clear();
	}
}
