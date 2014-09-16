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
	
	public DrawPanel( Mockup mockup) {
		this.mockup = mockup;
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
        mockup = ( (AppFrame)parent ).getMockup();
        
        //drawing
        double scaleFactor = calculateScaleFactor( mockup );
        
        drawPhysicalObjects( g2d, scaleFactor);
	}
	private void drawPhysicalObjects(Graphics2D g2d, double scaleFactor) {
		Ellipse2D e;
		Line2D l;
		double X;
		double Y;
		for( PhysicalObjectMockup element : mockup.objectsMockup) {
			X = element.coordinates[0]*scaleFactor+this.getWidth()/2;
			Y = element.coordinates[1]*scaleFactor+this.getHeight()/2;
			
			e = new Ellipse2D.Double( X-5,Y-5,10,10);
			g2d.setColor( Color.red );
	    	g2d.fill(e);
	    	g2d.setColor( Color.black );
	    	g2d.draw(e);
			l = new Line2D.Double(X, Y, X+element.netForceVersor[0]*10, Y+element.netForceVersor[1]*10);
			g2d.setColor( Color.green );
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
