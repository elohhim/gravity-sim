/**
 * 
 */
package pl.elohhim.git.gravitysim.model.primitives;

/**
 * @author Johhny
 * 
 */
public interface ICoordinateSystem
{
	/**
	 * @return Vector3D used to translate GlobalCS Zero to LocalCSZero
	 */
	abstract public Vector3D getCSZeroGlobalCSRadiusVector();
	
	/**
	 * calculates coordinates in GlobalCS using LocalCS
	 * @param a1 - first coordinate
	 * @param a2 - second coordinate
	 * @param a3 - third coordinate
	 * @return coordinates in GlobalCS as Vector3D
	 */
	abstract public Vector3D getCoorinatesInGlobalCS( double a1, double a2, double a3);
}
