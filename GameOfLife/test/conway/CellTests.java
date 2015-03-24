package conway;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTests {
	
	@Test
	public void cellHasNeighbors() {
		Cell cell = new Cell();
		assertEquals(0, cell.getLiveNeighbors());
	}
	
	@Test
	public void cellHasLiveNeighborsItWasConstructedWith() {
		Cell cell = new Cell(247);
		assertEquals(247, cell.getLiveNeighbors());
	}
	
	@Test
	public void liveCellWillDieFromUnderpopulation() {
		Cell cell = new Cell(1);
		assertEquals(false, cell.shouldBeAliveNextTime());
	}
	
	@Test
	public void liveCellWillDieFromOvercrowding() {
		Cell cell = new Cell(4);
		assertEquals(false, cell.shouldBeAliveNextTime());
	}
	
	@Test
	public void liveCellWillSurviveThanksToUpAndComingNeighborhood() {
		Cell cell = new Cell(2);
		assertEquals(true, cell.shouldBeAliveNextTime());
	}

	@Test
	public void liveCellWillSurviveThanksToHappeningNeighborhood() {
		Cell cell = new Cell(3);
		assertEquals(true, cell.shouldBeAliveNextTime());
	}
	
	@Test
	public void deadCellWillUsuallyStayDead() {
		Cell cell = new Cell(2, false);
		assertEquals(false, cell.shouldBeAliveNextTime());
	}
	
	@Test
	public void deadCellComesToLifeThanksToReproduction() {
		Cell cell = new Cell(3, false);
		assertEquals(true, cell.shouldBeAliveNextTime());
	}
}
