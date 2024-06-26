package gc;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class YX extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Drawing the graph background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Setting up the axes
        g.setColor(Color.BLACK);
        // Y-axis
        g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        // X-axis
        g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);

        // Labeling Axes
        g.drawString("Y", getWidth()/2 + 5, 15);
        g.drawString("X", getWidth() - 15, getHeight()/2 - 5);

        // Drawing the graph (solid line example)
        g.setColor(Color.BLUE);
        int prevX = getWidth()/2;
        int prevY = getHeight()/2;
        for (int i = -getWidth()/2; i < getWidth()/2; i++) {
            int x = i + getWidth()/2; // Adjusting the origin
            int y = -i + getHeight()/2; // Example formula: y = -x (and adjusting the origin)
            g.drawLine(prevX, prevY, x, y);
            prevX = x;
            prevY = y;
        }

        // Labeling the graph with the formula
        g.setColor(Color.RED);
        g.drawString("y = x", 20, 20);
    }



    public static void main() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graph of Y = X");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.getContentPane().add(new YX());
            frame.setPreferredSize(new Dimension(400, 400));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
