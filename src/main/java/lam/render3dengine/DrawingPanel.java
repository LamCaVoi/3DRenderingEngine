/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lam.render3dengine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author THU VIEN
 */
public class DrawingPanel extends JPanel {

    Image image;

    public DrawingPanel() {
        image = new ImageIcon("C://Users//THU VIEN//Downloads//8a40b173245689.5c24c61757a18.jpg").getImage();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

//        g2d.setColor(Color.red);
//        Rectangle2D rect = new Rectangle2D.Double(100,100,150,200);
//        g2d.fill(rect);
//        
//        g2d.setColor(Color.CYAN);
//        g2d.fillOval(200, 200, 150, 150);
//        
//        g2d.setColor(Color.LIGHT_GRAY);
//        Path2D polygon = new Path2D.Double();
//        polygon.moveTo(150  , 200);
//        polygon.lineTo(300, 250);
//        polygon.lineTo(121, 030);
//        polygon.lineTo(250, 250);
//        polygon.closePath();
//        g2d.fill(polygon);
//        
//        g2d.setStroke(new BasicStroke(5));
//        g2d.setColor(Color.GREEN);
//        g2d.drawLine(0, 0 , 500, 500);
//        
//        g2d.setColor(Color.ORANGE);
//        g2d.drawLine(0, 0 , 500, 500);
//
//        String myStr = "I can Do the 3d rendering engine now!!! :D";
//        g2d.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 50));
//        g2d.drawString(myStr, 100, 250);
//
//        g2d.drawImage(image, 0, 0, 1280, 720, this);
        List<Triangle> tris = new ArrayList<Triangle>();
        tris.add(new Triangle(new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(-100, 100, -100), Color.WHITE));
        tris.add(new Triangle(new Vertex(100, 100, 100),
                      new Vertex(-100, -100, 100),
                      new Vertex(100, -100, -100), Color.RED));
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                      new Vertex(100, -100, -100),
                      new Vertex(100, 100, 100), Color.BLUE));
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                      new Vertex(100, -100, -100),
                      new Vertex(-100, -100, 100), Color.GREEN));
        
        g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
        
        g2d.setColor(Color.white);
        for (Triangle t: tris){
            Path2D polygon = new Path2D.Double();
            polygon.moveTo(t.v1.x, t.v1.y);
            polygon.lineTo(t.v2.x, t.v2.y);
            polygon.lineTo(t.v3.x, t.v3.y);
            polygon.lineTo(t.v3.x, t.v3.y);
            polygon.closePath();
            g2d.draw(polygon);
        }
        
    }
}

class Vertex {

    double x;
    double y;
    double z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Triangle {

    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;

    public Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }

}
