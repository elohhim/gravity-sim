package pl.elohhim.git.gravitysim.events;

public class NextIterationEvent extends ProgramEvent{

	private static long iterationCounter = 0;

	private long iterationId;

	public NextIterationEvent() {
		super();
		this.setIterationId(NextIterationEvent.iterationCounter++);
	}

	/**
	 * @return the iterationCounter
	 */
	public static long getIterationCounter() {
		return iterationCounter;
	}

	/**
	 * @return the iterationId
	 */
	public long getIterationId() {
		return this.iterationId;
	}

	/**
	 * @param iterationId the iterationId to set
	 */
	public void setIterationId(long iterationId) {
		this.iterationId = iterationId;
	}
}
