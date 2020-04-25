package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO);
    }
    public boolean isWin(Predicate<Figure3T> predicate) {
        Predicate<Integer> row = r -> fillBy(predicate, r, 0, 0, 1);
        Predicate<Integer> column = c -> fillBy(predicate,0, c, 1, 0);
        return fillBy(predicate, 0, 0, 1, 1) ||
                fillBy(predicate, table.length - 1, 0, -1, 1) ||
               IntStream.range(0, table.length - 1)
                       .anyMatch(i -> (row.test(i) || column.test(i)));
    }

    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays :: stream)
                .anyMatch(a -> !a.hasMarkX() && !a.hasMarkO());
    }
}
