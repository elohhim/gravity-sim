package pl.elohhim.git.gravitysim.events;

public class NextIterationEvent extends ProgramEvent{
		
	private static long iterationCounter = 0;
	
	private long iterationId;
	
	private double timePassed;
	
	public NextIterationEvent( double timePassed) {
		super();
		setIterationId(NextIterationEvent.iterationCounter++);
		this.timePassed = timePassed;
	}

	/**
	 * @return the iterationCounter
	 */
	public static long getIterationCounter() {
		return iterationCounter;
	}

	/**
	 * @return the timePassed
	 */
	public double getTimePassed() {
		return timePassed;
	}

	/**
	 * @return the iterationId
	 */
	public long getIterationId() {
		return iterationId;
	}

	/**
	 * @param iterationId the iterationId to set
	 */
	public void setIterationId(long iterationId) {
		this.iterationId = iterationId;
	}
}
