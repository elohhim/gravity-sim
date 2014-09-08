package pl.elohhim.git.gravitysim.events;

public class NextIterationEvent extends ProgramEvent{
		
	private static int iterationCounter = 0;
	
	private double timePassed;
	
	public NextIterationEvent( double timePassed) {
		NextIterationEvent.iterationCounter++;
		this.timePassed = timePassed;
	}

	/**
	 * @return the iterationCounter
	 */
	public static int getIterationCounter() {
		return iterationCounter;
	}

	/**
	 * @return the timePassed
	 */
	public double getTimePassed() {
		return timePassed;
	}
}
