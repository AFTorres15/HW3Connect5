package cs3331;

import org.junit.Before;

import static org.junit.Assert.*;

public class BoardTest {

    private Board tmpBoard;
    private Player p1,p2;

    @Before
    public void setUp() throws Exception {
        tmpBoard= new Board(9);
        p1= new Player(1,'1');
        p2= new Player(2,'2');
    }

    @org.junit.Test
    public void addDisc() throws Exception {
        tmpBoard.addDisc(0,0,p1);
        assertEquals(p1,tmpBoard.getPlayer(0,0));
        assertNotEquals(p2,tmpBoard.getPlayer(0,0));
    }

    @org.junit.Test
    public void size() {
        assertEquals(9,tmpBoard.size());
        assertNotEquals(15,tmpBoard.size());
        tmpBoard=new Board(15);
        assertEquals(15,tmpBoard.size());
        assertNotEquals(9,tmpBoard.size());
    }

    @org.junit.Test
    public void checkForWin() {
    }
}