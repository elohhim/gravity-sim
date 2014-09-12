package pl.elohhim.git.gravitysim.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pl.elohhim.git.gravitysim.commons.Mockup;


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
		List<Double> coordinates = this.mockup.coordinates;
		Ellipse2D e;
		double X;
		double Y;
		for( int i = 0; i < coordinates.size(); i+=3 ){
			X = coordinates.get(i);
			Y = coordinates.get(i+1);
			e = new Ellipse2D.Double( X*scaleFactor+this.getWidth()/2,Y*scaleFactor+this.getHeight()/2,10,10);
			g2d.setColor( Color.red );
	    	g2d.fill(e);
	    	g2d.setColor( Color.black);
	    	g2d.draw(e);
		}
	}

	private double calculateScaleFactor(Mockup mockup) {
        int widthInPixels = this.getWidth();
		int heightInPixels = this.getHeight();
		
		double[] maximumCoordinates = new double[3];
		
		for(int i=0; i < mockup.coordinates.size(); i++) {
			if ( mockup.coordinates.get(i) >= maximumCoordinates[i%3])
				maximumCoordinates[i%3] = mockup.coordinates.get(i);
		}
		System.out.println( maximumCoordinates.toString());
		
		double scaleFactor1 = (double) widthInPixels / ( 4*maximumCoordinates[0] );
		double scaleFactor2 = (double) heightInPixels / ( 4*maximumCoordinates[1] );
		return ( scaleFactor1<scaleFactor2 )?scaleFactor1:scaleFactor2;
	}
}
