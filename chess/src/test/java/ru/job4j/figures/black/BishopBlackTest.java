package ru.job4j.figures.black;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void whenCreatedInPositionA1ThenReturnPositionA1() {
        Cell expected = Cell.A1;
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell result = bishop.position();
        assertThat(result, is(expected));
    }

    @Test
    public void whenBishopIsCopiedToPositionG5ThenPositionG5() {
        Cell expected = Cell.G5;
        BishopBlack start = new BishopBlack(Cell.C1);
        Figure dest = start.copy(Cell.G5);
        Cell result = dest.position();
        assertThat(result, is(expected));
    }

    @Test
    public void whenBishopWayC1G5ThenReturnD2E3F4G5() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(bishop.position(), Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalStateException.class)
    public void whenIsNotDiagonalThenAnException() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(bishop.position(), Cell.G6);
    }
}
