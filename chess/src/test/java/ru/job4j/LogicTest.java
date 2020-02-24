package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.job4j.chess.Logic;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;

public class LogicTest {

    @Test
    public void checkWayWhenNoFigureInSourseCellThenFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G5));
        assertFalse(logic.move(Cell.C1, Cell.G5));
    }

    @Test
    public void checkWayWhenNoFigureInDestinationCellThenTrue() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertTrue(logic.move(Cell.C1, Cell.G5));
    }

    @Test
    public void checkWayWhenFigureInMiddleThenFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.E3));
        assertFalse(logic.move(Cell.C1, Cell.G5));
    }

    @Test
    public void checkWayWhenFigureInEndThenFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        assertFalse(logic.move(Cell.C1, Cell.G5));
    }

    @Test
    public void checkWayWhenNotDiagonalThenFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertFalse(logic.move(Cell.C1, Cell.G6));
    }
}
