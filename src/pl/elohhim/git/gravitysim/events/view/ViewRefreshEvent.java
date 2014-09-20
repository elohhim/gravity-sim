package pl.elohhim.git.gravitysim.events.view;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.events.ProgramEvent;

public class ViewRefreshEvent extends ProgramEvent {

	public Mockup mockup;

	public ViewRefreshEvent( Mockup mockup )
	{
		super();
		this.mockup = mockup;
	}
}
