/**
 * Vector3D.java
 */
package pl.elohhim.git.gravitysim.model.primitives;

/**
 * @author elohhim
 *
 */
public class Vector3D {

	private double[] components;
	
	/**
	 * default constructor
	 * @param a1 - first component
	 * @param a2 - second component
	 * @param a3 - third component
	 */
	public Vector3D( double a1, double a2, double a3) {
		setComponents(new double[3]);
		components[0] = a1;
		components[1] = a2;
		components[2] = a3;
	}
		
	/**
	 * @return the components
	 */
	public double[] getComponents() {
		return components;
	}
	/**
	 * @param components the components to set
	 */
	public void setComponents(double[] components) {
		this.components = components;
	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return 
	 */
	public static Vector3D add( Vector3D first, Vector3D second)
	{
		double result[] = new double[3];
		for( int i = 0; i < 3; i++)
		{
			result[i] = first.getComponents()[i] + second.getComponents()[i];
		}
		
		return new Vector3D( result[0], result[1], result[2]);
	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return 
	 */
	public static Vector3D scalarProduct(Vector3D first, Vector3D second){
		double result[] = new double[3];
		for( int i = 0; i < 3; i++)
		{
			result[i] = first.getComponents()[i] * second.getComponents()[i];
		}
		
		return new Vector3D( result[0], result[1], result[2]);
	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Vector3D vectorProduct(Vector3D first, Vector3D second){
		return new Vector3D( 
				first.getComponents()[1]*second.getComponents()[2] + first.getComponents()[2]*second.getComponents()[1],
				first.getComponents()[2]*second.getComponents()[0] + first.getComponents()[0]*second.getComponents()[2],
				first.getComponents()[0]*second.getComponents()[1] + first.getComponents()[1]*second.getComponents()[0]
				);
	}
}
