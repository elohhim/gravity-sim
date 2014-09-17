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

	public Vector3D() {
		this.setComponents(new double[3]);
		this.components[0] = 0;
		this.components[1] = 0;
		this.components[2] = 0;
	}
	/**
	 *
	 * @param a1 - first component
	 * @param a2 - second component
	 * @param a3 - third component
	 */
	public Vector3D( double a1, double a2, double a3) {
		this.setComponents(new double[3]);
		this.components[0] = a1;
		this.components[1] = a2;
		this.components[2] = a3;
	}

	@Override
	public String toString() {
		return new String("Vector: " + this.components[0] + "; " + this.components[1] + "; " + this.components[2]);
	}

	/**
	 * @return the components
	 */
	public double[] getComponents() {
		return this.components;
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
		Vector3D result = new Vector3D();
		for( int i = 0; i < 3; i++)
		{
			result.getComponents()[i] = first.getComponents()[i] + second.getComponents()[i];
		}
		return result;
	}

	public static Vector3D subtract( Vector3D first, Vector3D second) {
		Vector3D result = new Vector3D();
		for( int i = 0; i < 3; i++)
		{
			result.getComponents()[i] = first.getComponents()[i] - second.getComponents()[i];
		}
		return result;
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

	/**
	 *
	 * @param vector
	 * @param scalar
	 * @return
	 */
	public static Vector3D scaleVector(Vector3D vector, double scalar) {
		Vector3D result = new Vector3D();
		for(int i = 0; i<3 ; i++) {
			result.getComponents()[i] = vector.getComponents()[i] * scalar;
		}
		return result;
	}

	public Vector3D versor() {
		double factor = 1 / ( Math.sqrt( Math.pow(this.getComponents()[0], 2) +
				Math.pow(this.getComponents()[1], 2) +
				Math.pow(this.getComponents()[2], 2) ) );
		return scaleVector( this, factor);
	}

	public double value() {
		double sum = 0;
		for ( int i = 0; i<3; i++) {
			sum += Math.pow(this.getComponents()[i], 2.0);
		}
		return Math.sqrt(sum);
	}
}

