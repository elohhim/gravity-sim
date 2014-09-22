/**
 * 
 */
package pl.elohhim.git.gravitysim.model.primitives;

/**
 * @author Johhny
 *
 */
public class CarthesianCoordinateSystem implements ICoordinateSystem
{
	private Vector3D cSZeroPoint; 

	/* (non-Javadoc)
	 * @see pl.elohhim.git.gravitysim.model.primitives.ICoordinateSystem#getCSZeroGlobalCSRadiusVector()
	 */
	@Override
	public Vector3D getCSZeroGlobalCSRadiusVector()
	{
		return this.cSZeroPoint;
	}

	/* (non-Javadoc)
	 * @see pl.elohhim.git.gravitysim.model.primitives.ICoordinateSystem#getCoorinatesInGlobalCS(double, double, double)
	 */
	@Override
	public Vector3D getCoorinatesInGlobalCS(double a1, double a2, double a3)
	{
		return Vector3D.add( cSZeroPoint, new Vector3D( a1, a2, a3) );
	}

}
