package pl.elohhim.git.gravitysim.model.physics.spaceObjects;

import java.util.ArrayList;
import java.util.List;

import pl.elohhim.git.gravitysim.model.physics.PhysicalObject;

public class Star extends PhysicalObject {
	
	private List<Planet> planets;

	public Star(double aCoord1, double aCoord2, double aCoord3, double aMass,
			String name) {
		super(aCoord1, aCoord2, aCoord3, aMass, name);
		this.planets = new ArrayList<Planet>();
	}

}
