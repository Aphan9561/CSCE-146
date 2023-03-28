/*
 * Written by Anna Phan
 */
import java.awt.*;
import javax.swing.*;
public class Triangle extends Canvas
{
    public static final int SIZE = 500;

    public static void main(String[] arg)
    {
        JFrame frame = new JFrame("Triangle");
        frame.setSize(SIZE,SIZE);
        Triangle st = new Triangle();
        frame.add(st);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paint(Graphics g)
    {
        int height = (int) Math.round(SIZE*Math.sqrt(3)/2);

        Point p1 = new Point(0,height);//bottom
        Point p2 = new Point(SIZE/2,0);//point
        Point p3 = new Point(SIZE,height);//bottom right

        drawTri(6,g,p1,p2,p3);//6 is the number of recursions
    }
   
    public void drawTri(int d, Graphics g, Point p1, Point p2, Point p3)
    {
        if(d == 1)
        {
            int [] px = {p1.x, p2.x, p3.x};
            int [] py = {p1.y, p2.y, p3.y};
            g.setColor(Color.BLACK);
            g.fillPolygon(px, py, 3);
            g.setColor(Color.white);
        }
        else
        {
            // recursive case, split into 3 triangles
            Point p4 = midpoint(p1, p2);
            Point p5 = midpoint(p2, p3);
            Point p6 = midpoint(p1, p3);
            //recurse on 3 triangular areas
            drawTri(d-1,g,p1,p4,p6);
            drawTri(d-1,g,p4, p2, p5);
            drawTri(d-1, g, p6, p5, p3);
        }
    }
    public static Point midpoint(Point p1, Point p2)
    {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}
