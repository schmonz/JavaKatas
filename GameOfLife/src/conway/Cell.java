package conway;

public class Cell {
	private int liveNeighbors = 0;
	private boolean isAlive = true;

	public Cell(int liveNeighbors) {
		this.liveNeighbors = liveNeighbors;
	}

	public Cell() {}

	public Cell(int liveNeighbors, boolean isAlive) {
		this.liveNeighbors = liveNeighbors;
		this.isAlive = isAlive;
	}
	
	public boolean shouldBeAliveNextTime() {
		if (isAlive) {
			return (2 <= liveNeighbors && liveNeighbors <= 3);
		} else {
			return (3 == liveNeighbors);
		}
	}
	
	public int getLiveNeighbors() {
		return liveNeighbors;
	}

}
