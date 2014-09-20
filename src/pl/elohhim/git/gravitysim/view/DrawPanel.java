package pl.elohhim.git.gravitysim.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.concurrent.BlockingQueue;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.commons.PhysicalObjectMockup;
import pl.elohhim.git.gravitysim.events.ProgramEvent;


@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	@SuppressWarnings("unused")
	private BlockingQueue<ProgramEvent> blockingQueue;
	private Mockup mockup;
	private double baseScaleFactor;
	private double scaleFactor;
	private Point coordinateSystemZero;

	public DrawPanel( Mockup mockup, BlockingQueue<ProgramEvent> blockingQueue) {
		this.mockup = mockup;
		this.blockingQueue = blockingQueue;
		this.baseScaleFactor = 0;
		this.scaleFactor = 0;
		this.coordinateSystemZero = new Point(0,0);
		this.setVisible( true );
		DrawPanelMouseListener mouseListener = new DrawPanelMouseListener();
		this.addMouseListener( mouseListener );
		this.addMouseMotionListener( mouseListener );
	}

	public Point getCoordinateSystemZero() {
		return coordinateSystemZero;
	}

	public void setCoordinateSystemZero(Point coordinateSystemZero) {
		this.coordinateSystemZero = coordinateSystemZero;
	}

	@Override
	public void paintComponent( Graphics g )
	{
		//initialization
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//getting Mockup from ancestor
		Container parent = SwingUtilities.getAncestorOfClass(AppFrame.class, this);
		this.mockup = ( (AppFrame)parent ).getMockup();

		//drawing
		if( baseScaleFactor == 0 ) 
			this.baseScaleFactor = this.scaleFactor = calculateScaleFactor( this.mockup );
		if( coordinateSystemZero.equals( new Point(0,0) ) )
			this.coordinateSystemZero = new Point( this.getWidth()/2, this.getHeight()/2 );
		this.drawPhysicalObjects( g2d );
	}
	
	private void drawPhysicalObjects(Graphics2D g2d ) {
		Ellipse2D e;
		Line2D l;
		double X;
		double Y;
		double dotSize = 4;
		
		for( PhysicalObjectMockup element : this.mockup.objectsMockup) {
			X = element.coordinates[0]*this.scaleFactor+this.coordinateSystemZero.x;
			Y = element.coordinates[1]*this.scaleFactor+this.coordinateSystemZero.y;

			e = new Ellipse2D.Double( X-dotSize/2,Y-dotSize/2,dotSize,dotSize);
			g2d.setColor( Color.RED );
			//g2d.fill(e);
			g2d.setColor( Color.BLACK );
			g2d.draw(e);

			/*
			//Force
			l = new Line2D.Double(X, Y, X+element.netForceVersor[0]*20, Y+element.netForceVersor[1]*20);
			g2d.setColor( Color.GREEN );
			g2d.draw(l);
			//*/
			
			//Velocity
			l = new Line2D.Double( X, Y, X + element.velocityVersor[0]*10, Y + element.velocityVersor[1]*10);
			g2d.setColor( Color.BLUE );
			g2d.draw(l);
			//*/
			//Acceleration
			l = new Line2D.Double( X, Y, X + element.accelerationVersor[0]*10, Y + element.accelerationVersor[1]*10);
			g2d.setColor( Color.ORANGE);
			g2d.draw(l);
		}
	}

	private double calculateScaleFactor(Mockup mockup) {
		int widthInPixels = this.getWidth();
		int heightInPixels = this.getHeight();

		double[] maximumCoordinates = new double[3];

		for( PhysicalObjectMockup element : mockup.objectsMockup ) {
			for( int i = 0; i < 2; i++) {
				if( maximumCoordinates[i%3] < element.coordinates[i]) {
					maximumCoordinates[i%3] = element.coordinates[i];
				}
			}
		}

		double scaleFactor1 = (double) widthInPixels / ( 4*maximumCoordinates[0] );
		double scaleFactor2 = (double) heightInPixels / ( 4*maximumCoordinates[1] );
		return ( scaleFactor1<scaleFactor2 )?scaleFactor1:scaleFactor2;
	}
	
	/**
	 * setting scaleFactor = baseScaleFactor*2^exponent 
	 * @param exponent
	 */
	public void rescale( double exponent ) {
		this.scaleFactor = baseScaleFactor * Math.pow( 2.0, exponent );
	}
}
