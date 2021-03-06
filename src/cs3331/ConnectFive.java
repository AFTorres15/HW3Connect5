package cs3331;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import static javax.swing.JOptionPane.CLOSED_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;


/**
 * Frame class for the graphical user interface of connect five.
 * Controller for handling events that affect the model and the view.
 *
 * @author Edgar Padilla
 */
@SuppressWarnings("serial")
public class ConnectFive extends JFrame {

    /**
     * Board model
     */
    private Board board;
    /**
     * Label containing message to user
     */
    private JLabel message;
    /**
     * Panel for the board to be displayed on the GUI
     * frame.
     */
    private BoardPanel boardPanel;
    private int squareSize = 15;

    // player1 is true, player2 is false
    private boolean turn = true;

    /**
     * Constructor that initializes and adds all the components of the frame
     * including anonymous classes for the handlers.
     */
    public ConnectFive() {
        setTitle("Connect Five");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        createGUI(15);

        setVisible(true);
        pack();
    }

    public ConnectFive(int size) {
        super();
        createGUI(size);
        squareSize = size;
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createGUI(int size) {
        //adding buttons (top)
        JPanel boardSizePanel = new JPanel(new FlowLayout());
        JButton largeBoard = new JButton("Board Size (15x15)");
        JButton smallBoard = new JButton("Board Size (9x9)");
        for (JButton button : new JButton[]{largeBoard, smallBoard}) {
            button.setFocusPainted(false);
            button.addActionListener(e -> {
                int ans;
                message.setText((e.getSource() == largeBoard ? "15" : "9"));
                if (e.getSource() == largeBoard) {
                    ans = JOptionPane.showConfirmDialog(this, "Start NEW GAME?");
                    switch (ans){
                        case NO_OPTION:

                        case YES_OPTION:
                            this.dispose();
                            new ConnectFive(15);
                    }

                } else {
                    JOptionPane.showConfirmDialog(this, "Start NEW GAME?");
                    this.dispose();
                    new ConnectFive(9);

                }
            });
            boardSizePanel.add(button);
        }
        getContentPane().add(boardSizePanel, BorderLayout.NORTH);

        //create Board GUI instance (center)
        getContentPane().add(boardPan(size), BorderLayout.CENTER);


        //creating message label (bottom)
        getContentPane().add(statusPanel(), BorderLayout.SOUTH);


        // Handler for user input when placing a disc on the grid.
        //anonymous class declaration (MouseAdapter is not a functional interface, we cannot use lambda expression)(need to do it the old way)
        boardPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int x = locateXY(e.getX());
                int y = locateXY(e.getY());
                message.setText("X: " + x + " " + "Y: " + y);
                passCoordinates(x, y);
                repaint();

            }//end mouse pressed
        });
    }

    private void passCoordinates(int x, int y) {
            try {

                if (turn) {
                    message.setText("Player 2's turn");
                    board.addDisc(x - 1, y - 1, 1);
                    turn = false;
                } else {
                    message.setText("Player 1's turn");
                    board.addDisc(x - 1, y - 1, 2);
                    turn = true;
                }
            } catch (PlayerWonException ex1) {
                if (turn) {
                    boardPanel.setVisible(false);
                    message.setText("PLAYER 1 IS THE WINNER!");
                } else {
                    message.setText("PLAYER 2 IS THE WINNER");
                    boardPanel.setVisible(false);
                }
            } catch (InValidDiskPositionException ex1) {
                message.setText("INVALID PLACEMENT: ALREADY OCCUPIED");

            } catch (Exception ex1) {
                System.out.println("Something else went wrong");
            }
    }

    private int locateXY(int x) {
        int pxlsize = 675;
        int gridSize = squareSize;
        int distance = pxlsize / gridSize;
        if (x > 25) {
            x = x - 25; // since we start at 25 we remove 25 in the calculations
        }
        int result = (int) Math.round(x / distance);
        return result + 1;
    }

    private BoardPanel boardPan(int size) {
        board = new Board(size);
        boardPanel = new BoardPanel(board);
        boardPanel.setPreferredSize(new Dimension(725, 725));
        return boardPanel;
    }

    private JPanel statusPanel() {
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Color.DARK_GRAY);
        statusPanel.setPreferredSize(new Dimension(650, 50));
        message = new JLabel("Welcome to Connect Five");
        message.setForeground(Color.WHITE);
        message.setFont(new Font(message.getName(), Font.BOLD, 26));
        statusPanel.add(message);

        return statusPanel;
    }

    /**
     * Initializes the frame for the GUI and starts the application.
     */
    public static void main(String[] args) {
        new ConnectFive();
    }
}