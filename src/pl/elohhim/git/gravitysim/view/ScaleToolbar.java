package pl.elohhim.git.gravitysim.view;

import java.util.concurrent.BlockingQueue;

import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pl.elohhim.git.gravitysim.events.ProgramEvent;
import pl.elohhim.git.gravitysim.events.view.ViewRescaleEvent;

/**
 * @author elohhim
 *
 */
@SuppressWarnings("serial")
public class ScaleToolbar extends JSlider {

	private BlockingQueue< ProgramEvent > blockingQueue;

	public BlockingQueue<ProgramEvent> getBlockingQueue() {
		return blockingQueue;
	}

	public ScaleToolbar( BlockingQueue< ProgramEvent > blockingQueue ) {
		super(SwingConstants.VERTICAL, -100, 100, 0);
		this.setMajorTickSpacing(50);
		this.setMinorTickSpacing(10);
		this.setPaintTicks( true );
		this.setPaintLabels( true );
		this.blockingQueue = blockingQueue;
		this.addChangeListener( new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				ScaleToolbar source = ( ScaleToolbar )e.getSource();
			    if ( !source.getValueIsAdjusting() ) {
			    	source.getBlockingQueue().add( new ViewRescaleEvent( ( double )source.getValue()/10 ) );
			    }
			}
		});
	}
}
