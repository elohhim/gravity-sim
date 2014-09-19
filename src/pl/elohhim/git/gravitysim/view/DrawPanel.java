package pl.elohhim.git.gravitysim.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pl.elohhim.git.gravitysim.commons.Mockup;
import pl.elohhim.git.gravitysim.commons.PhysicalObjectMockup;


@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	private Mockup mockup;
	private double scaleFactor;

	public DrawPanel( Mockup mockup) {
		this.mockup = mockup;
		this.scaleFactor = 0;
		this.setVisible( true );
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
		if( scaleFactor == 0 ) 
			this.scaleFactor = calculateScaleFactor( this.mockup );
		this.drawPhysicalObjects( g2d );
	}
	
	private void drawPhysicalObjects(Graphics2D g2d ) {
		Ellipse2D e;
		Line2D l;
		double X;
		double Y;
		double dotSize = 4;
		
		for( PhysicalObjectMockup element : this.mockup.objectsMockup) {
			X = element.coordinates[0]*this.scaleFactor+this.getWidth()/2;
			Y = element.coordinates[1]*this.scaleFactor+this.getHeight()/2;

			e = new Ellipse2D.Double( X-dotSize/2,Y-dotSize/2,dotSize,dotSize);
			g2d.setColor( Color.RED );
			g2d.fill(e);
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

		double scaleFactor1 = (double) widthInPixels / ( 10*maximumCoordinates[0] );
		double scaleFactor2 = (double) heightInPixels / ( 10*maximumCoordinates[1] );
		return ( scaleFactor1<scaleFactor2 )?scaleFactor1:scaleFactor2;
	}
}
