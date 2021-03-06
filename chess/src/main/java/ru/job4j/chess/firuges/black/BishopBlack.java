package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            /*throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", source, dest)
            );*/
            //System.out.println("Не диагональ!");
            return new Cell[] {source};
        } else {

            int size = Math.abs(dest.x - source.x);
            Cell[] steps = new Cell[size];
            int deltaX = 0;
            int deltaY = 0;
            if (size != 0) {
                deltaX = (dest.x - source.x) / size;
                deltaY = (dest.y - source.y) / size;
            }
            for (int index = 0; index < size; index++) {
                int x = source.x + (deltaX * (index + 1));
                int y = source.y + (deltaY * (index + 1));
                steps[index] = Cell.findBy(x, y);
            }
            return steps;
        }
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x = Math.abs(source.x - dest.x);
        int y = Math.abs(source.y - dest.y);
        return x == y;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
