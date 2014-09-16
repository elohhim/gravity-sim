/**
 * SimulationPlayer.java
 */
package pl.elohhim.git.gravitysim.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JToolBar;

import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.events.StartSimulationEvent;

/**
 * @author elohhim
 *
 */
@SuppressWarnings("serial")
public class SimulationPlayer extends JToolBar {
	
	private BlockingQueue<ProgramEvent> blockingQueue;

	public SimulationPlayer( final BlockingQueue<ProgramEvent> blockingQueue ) {
		
		this.blockingQueue = blockingQueue;
		
		JButton playButton = new JButton( "play |>" );
		
		playButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e)
            {
                blockingQueue.add( new StartSimulationEvent() );
                System.out.println("You clicked the button");
            }
        });      
		
		JButton pauseButton = new JButton( "pause ||" );
		
		this.add(playButton);
		this.add(pauseButton);
	}

}
