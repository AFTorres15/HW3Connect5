package cs3331;

import java.awt.*;
import java.awt.geom.Ellipse2D;

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
        // for 15x15 distance in-between lines is 45px
        // for 9x9 its 75px
        for(int i = 0; i <= 15; i++)
        {
            //vertical lines
            // starts at 25px
            g.drawLine(25 + i * n, 25, 25 + i * n, 700);
            //horizontal
            g.drawLine(25,25 + i * n , 700, 25 + i * n);
        }

//        int squareSize = board.size();
//        int pxlsize = 675;
//        int gridSize = squareSize;
//        int distance = pxlsize/squareSize;
        int pxlTotal = 675;
        int temp = pxlTotal / grid;
        int discPxl;
        if (grid == 9) {
            discPxl = 75;
        } else{
            discPxl = 45;
        }

        Graphics2D g22d = (Graphics2D) g;
        for (int i = 0; i < board.size() ; i++) {

            for (int j = 0; j < board.size() ; j++) {

                if (board.getTiles(i, j) != null && board.getTiles(i, j).getPlayer() == 1) {
                    Ellipse2D.Double circle = new Ellipse2D.Double(i*temp+25, j*temp + 25, discPxl,discPxl);
                    g22d.setPaint(Color.RED);
                    g22d.fill(circle);
                } else if(board.getTiles(i, j) != null && board.getTiles(i, j).getPlayer() == 2) {
                    Ellipse2D.Double circle = new Ellipse2D.Double(i*temp+25, j*temp+25, discPxl,discPxl);
                    g22d.setPaint(Color.BLACK);
                    g22d.fill(circle);
                }
            }
        }
    }

}