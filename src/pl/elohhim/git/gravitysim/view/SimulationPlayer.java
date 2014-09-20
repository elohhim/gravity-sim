/**
 * SimulationPlayer.java
 */
package pl.elohhim.git.gravitysim.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.events.simulation.PauseSimulationEvent;
import pl.elohhim.git.gravitysim.events.simulation.ResumeSimulationEvent;
import pl.elohhim.git.gravitysim.events.simulation.StartSimulationEvent;
import pl.elohhim.git.gravitysim.events.simulation.StopSimulationEvent;

/**
 * @author elohhim
 *
 */
@SuppressWarnings("serial")
public class SimulationPlayer extends JToolBar {

	@SuppressWarnings("unused")
	private BlockingQueue<ProgramEvent> blockingQueue;

	public SimulationPlayer( final BlockingQueue<ProgramEvent> blockingQueue ) {

		this.blockingQueue = blockingQueue;

		final JButton playButton = new JButton( "play | >" );
		playButton.setEnabled( true );

		final JButton stopButton = new JButton( "stop [  ]" );
		stopButton.setEnabled( false );

		final JToggleButton pauseButton = new JToggleButton( "pause | |" );
		pauseButton.setEnabled( false );

		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				blockingQueue.add( new StartSimulationEvent() );
				playButton.setEnabled( false );
				stopButton.setEnabled( true );
				pauseButton.setEnabled( true );
				System.out.println("STARTING SIMULATION");
			}
		});

		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				blockingQueue.add( new StopSimulationEvent() );
				playButton.setEnabled( true );
				stopButton.setEnabled( false );
				pauseButton.setSelected( false );
				pauseButton.setEnabled( false );
				System.out.println("STOPPING SIMULATION");
			}
		});

		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if ( pauseButton.isSelected() ) {
					blockingQueue.add( new PauseSimulationEvent() );
					System.out.println("PAUSING SIMULATION");
				} else {
					blockingQueue.add( new ResumeSimulationEvent() );
					System.out.println("RESUMING SIMULATION");
				}
			}
		});

		this.add( playButton );
		this.add( pauseButton );
		this.add( stopButton );
	}

}
