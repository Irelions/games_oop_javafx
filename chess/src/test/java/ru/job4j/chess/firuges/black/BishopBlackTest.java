package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.beans.BeanInfo;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertEquals(bishopBlack.position(), Cell.A1);
    }

    @Test
    public void testCopy() {
        Figure bishopBlack1 = new BishopBlack(Cell.A1);
        Figure bishopBlack2 = bishopBlack1.copy(Cell.A2);
        assertEquals(bishopBlack2.position(), Cell.A2);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] arrayWay = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] arrayTrue = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(arrayWay, arrayTrue);
    }

    @Test
    public void testIsDiagonal() {
        boolean chek;
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        chek = bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertEquals(chek, true);
    }
}