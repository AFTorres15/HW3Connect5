package cs3331;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Class that acts as the Panel to display the model (board) as a grid of 15 by 15.
 *
 * @author Edgar Padilla
 *
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel{

    /** Board model. */
    private Board board;

    /**
     * Creates an instance of this panel for the discs board.
     */
    public BoardPanel(Board board)
    {
        super(true);
        this.board = board;
        setOpaque(true);
        setBackground(Color.CYAN);
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

        for(int i = 0; i <= 15; i++)
        {
            //vertical lines
            g.drawLine(25 + i * 40, 25, 25 + i * 40, 625);
            //horizontal
            g.drawLine(25,25 + i * 40 , 625, 25 + i * 40);
        }
    }
}