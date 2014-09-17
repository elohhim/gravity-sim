package pl.elohhim.git.gravitysim.events;

import pl.elohhim.git.gravitysim.commons.Mockup;

public class ViewRefreshEvent extends ProgramEvent {

	public Mockup mockup;

	public ViewRefreshEvent( Mockup mockup )
	{
		super();
		this.mockup = mockup;
	}
}
