package pl.elohhim.git.gravitysim.view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawPanelMouseListener extends MouseAdapter implements MouseListener, MouseMotionListener {

	private Point drag1;
	private Point drag2;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
		    System.out.println("Mouse double clicked");
		    DrawPanel source = ( DrawPanel )e.getSource();
			source.setCoordinateSystemZero( new Point( source.getWidth()/2, source.getHeight()/2) );
			source.rescale( 0 );
			source.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed( MouseEvent e ) {
		System.out.println( "Mouse pressed" + e.getPoint() );
		this.drag1 = e.getPoint();
		this.drag2 = e.getPoint();
	}

	@Override
	public void mouseReleased( MouseEvent e ) {
		System.out.println( "Mouse released" + e.getPoint() );
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println( "Mouse dragged" + e.getPoint() );
		
		this.drag1 = this.drag2;
		this.drag2 = e.getPoint(); 
		
		DrawPanel source = ( DrawPanel )e.getSource();
		source.getCoordinateSystemZero().translate( drag2.x-drag1.x, drag2.y-drag1.y);
		source.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
	

}
