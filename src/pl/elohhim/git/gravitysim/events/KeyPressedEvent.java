package pl.elohhim.git.gravitysim.events;

public class KeyPressedEvent extends ProgramEvent {
	private int keyCode;
	
	public KeyPressedEvent( int keyCode )
	{
		super();
		this.setKeyCode(keyCode);
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}
	
	
}
