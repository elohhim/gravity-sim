/**
 * 
 */
package pl.elohhim.git.gravitysim.model.physics.spaceObjects;

import java.util.ArrayList;
import java.util.List;

import pl.elohhim.git.gravitysim.model.physics.PhysicalObject;

/**
 * @author johnny
 *
 */
public class Planet extends PhysicalObject {
	
	private List<Satelite> satelites;
	
	public Planet( double aCoord1, double aCoord2, double aCoord3, double aMass, String name ) {
		super( aCoord1, aCoord2, aCoord3, aMass, name);
		this.satelites = new ArrayList<Satelite>();
	}

}
