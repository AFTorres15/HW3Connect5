package cs3331;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Class that acts as the Panel to display the model (board)
 * as a grid of 15 by 15 or 9 by 9.
 *
 * @author Edgar Padilla
 *
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel{

    /** Board model. */
    private Board board;
    private int grid; // size of grid

    /**
     * Creates an instance of this panel for the discs board.
     */
    public BoardPanel(Board board)
    {
        super(true);
        this.board = board;
        grid = this.board.size();
        setOpaque(true);
        setBackground(Color.CYAN);
    }
    public int setSize(int grid){ // set size 9 or 15
        return this.grid = grid;
    }

    /**
     * Draws the discs board by calling the paint method.
     */
    public void drawBoard()
    {
        repaint();
    }

    /**
     * Paints the discs board to the panel.
     */


    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        int size = 675; // multiple of 9 and 15
        int n = size / grid;
        for(int i = 0; i <= 15; i++)
        {
            //vertical lines
            g.drawLine(25 + i * n, 25, 25 + i * n, 700);
            //horizontal
            g.drawLine(25,25 + i * n , 700, 25 + i * n);
        }
    }

}