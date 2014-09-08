/**
 * ParticleParticleGravitation.java
 */
package pl.elohhim.git.gravitysim.model.physics.gravitation;

import pl.elohhim.git.gravitysim.model.physics.Force;
import pl.elohhim.git.gravitysim.model.physics.PhysicalObject;
import pl.elohhim.git.gravitysim.model.primitives.Vector3D;

/**
 * @author elohhim
 *
 */
public final class ParticleParticleGravitation implements IGravitation {

	private static double gravitationalConstant = Math.pow( 6.67384*10, -11.0);
	/* (non-Javadoc)
	 * @see pl.elohhim.git.gravitysim.model.physics.Gravitation#gravitationalInteraction(pl.elohhim.git.gravitysim.model.PhysicalObject, pl.elohhim.git.gravitysim.model.PhysicalObject)
	 */
	@Override
	public void gravitationalInteraction(PhysicalObject object1,
			PhysicalObject object2) {
		//calculating distance between objects
		Vector3D distance = Vector3D.subtract(object2.getRadiusVector(), object1.getRadiusVector());
		
		//calculating gravity force
		double gravityNumerator = ParticleParticleGravitation.gravitationalConstant * object1.getMass() * object2.getMass();
		double gravityDenominator = Math.pow( distance.value(), 2.0);
		double gravityValue = gravityDenominator / gravityNumerator;
				
		//adding interaction to 1st object
		String name12 = object1.getName() + "_" + object2.getName();
		Force interaction12 = new Force( Vector3D.scaleVector( distance.versor(), gravityValue), name12);
		object1.addForce(interaction12);
				
		//adding interaction to 2nd object
		String name21 = object1.getName() + "-" + object2.getName();
		Force interaction21 = new Force( Vector3D.scaleVector( distance.versor(), -gravityValue), name21);
		object2.addForce(interaction21);

	}

	/* (non-Javadoc)
	 * @see pl.elohhim.git.gravitysim.model.physics.Gravitation#getGravitationalConstant()
	 */
	@Override
	public double getGravitationalConstant() {
		return gravitationalConstant;
	}

	/* (non-Javadoc)
	 * @see pl.elohhim.git.gravitysim.model.physics.Gravitation#setGravitationalConstant(double)
	 */
	@Override
	public void setGravitationalConstant(double gravitationalConstant) {
		ParticleParticleGravitation.gravitationalConstant = gravitationalConstant;
	}

}
