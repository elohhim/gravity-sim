/**
 * AppFrame.java
 */
package pl.elohhim.git.gravitysim.view;

import java.awt.BorderLayout;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.events.ProgramEvent;

/**
 * @author elohhim
 *
 */
@SuppressWarnings("serial")
public class AppFrame extends JFrame {
	private BlockingQueue<ProgramEvent> blockingQueue;
	private Mockup mockup;
	private DrawPanel drawPanel;

	public AppFrame(BlockingQueue<ProgramEvent> blockingQueue, Mockup mockup) {
		this.blockingQueue = blockingQueue;
		this.mockup = mockup;
		this.initialize();
	}

	private void initialize()
	{
		this.setBounds(100, 100, 800, 600);
		//this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout( new BorderLayout() );
		this.setVisible( true );

		this.drawPanel = new DrawPanel( this.mockup, blockingQueue );
		this.add( drawPanel );
		/*this.addKeyListener( new KeyAdapter() {
			@Override
			public void keyPressed( KeyEvent e ) {
				blockingQueue.add( new KeyPressedEvent( e.getKeyCode()) );
			}
		});*/
		
		ScaleToolbar scalePlayer = new ScaleToolbar( this.blockingQueue );
		this.add( scalePlayer, BorderLayout.EAST );
		
		SimulationPlayer player = new SimulationPlayer( this.blockingQueue );
		this.add( player, BorderLayout.PAGE_END);
	}

	public Mockup getMockup() {
		return this.mockup;
	}

	public void setMockup(Mockup mockup) {
		this.mockup = mockup;
	}

	public void rescaleDrawPanel( double scaleExponent ) {
			this.drawPanel.rescale( scaleExponent );	
	}
}
