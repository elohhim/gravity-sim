package pl.elohhim.git.gravitysim.events.view;

import pl.elohhim.git.gravitysim.events.ProgramEvent;

public class ViewRescaleEvent extends ProgramEvent {
	public double scaleExponent;
	
	public ViewRescaleEvent( double scaleExponent ) {
		this.scaleExponent = scaleExponent;		
	}
}
