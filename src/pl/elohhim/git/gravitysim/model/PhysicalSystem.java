/**
 * PhysicalSystem.java
 */
package pl.elohhim.git.gravitysim.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 *
 */
public class PhysicalSystem {

	private List<MaterialPoint> objectList;
	
	private PhysicalConstants physicalConstants;
	
	/**
	 * default constructor
	 */
	public PhysicalSystem() {
		objectList = new ArrayList<MaterialPoint>();
		physicalConstants = new PhysicalConstants();

	}
	
	public void populateSystem() {
		objectList.add( new MaterialPoint( 1, 1, 1, 2));
		objectList.add( new MaterialPoint( 0, 0, 0, 1));
	}
}
