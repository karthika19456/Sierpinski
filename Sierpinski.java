import java.awt.*;
import javax.swing.*;

public class Sierpinski extends Canvas
{
    public int n;
    public static int size;

    public void sier(Graphics g, int n, int lx, int ly, int tx, int ty, int rx, int ry) 
    {
        int p1x, p1y, p2x, p2y, p3x, p3y;
        if (n == 0)
            return;
        else {
            p1x = (lx + tx)/2;
            p1y = (ly + ty)/2;
            p2x = tx;
            p2y = ly;
            p3x = (tx + rx)/2;
            p3y = (ty + ry)/2;

            g.drawLine(p1x, p1y, p2x, p2y);
            g.drawLine(p2x, p2y, p3x, p3y);
            g.drawLine(p1x, p1y, p3x, p3y);

        }

        int l1x = lx;
        int l1y = ly;
        int t1x = p1x;
        int t1y = p1y;
        int r1x = tx;
        int r1y = p2y;
        int l2x = p1x;
        int l2y = p1y;
        int t2x = p2x;
        int t2y = ty;
        int r2x = p3x;
        int r2y = p3y;
        int l3x = p2x;
        int l3y = p2y;
        int t3x = p3x;
        int t3y = p3y;
        int r3x = rx;
        int r3y = ry;

        sier(g, n-1, l1x, l1y, t1x, t1y, r1x, r1y);
        sier(g, n-1, l2x, l2y, t2x, t2y, r2x, r2y);
        sier(g, n-1, l3x, l3y, t3x, t3y, r3x, r3y);
    
    }

    public void paint(Graphics g)
    {
        g.drawLine(0, 700, 350, 94);
        g.drawLine(350, 94, 700, 700);
        g.drawLine(0, 700, 700, 700);
        
        sier(g, n, 0, 700, 350, 94, 700, 700);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sierpinski drawing = new Sierpinski();
        drawing.n = Integer.parseInt(args[0]);
        drawing.size = 700;
        drawing.setSize(drawing.size, drawing.size);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }
}