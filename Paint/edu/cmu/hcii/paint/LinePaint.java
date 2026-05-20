package edu.cmu.hcii.paint;

import java.awt.*;

public class LinePaint extends PaintObject {

    Point[] points;
    
    public LinePaint() {
     
    }
    
    public double getStartX() { return points[0].getX(); }
    public double getStartY() { return points[0].getY(); }
    public double getEndX() { return points[points.length - 1].getX(); }
    public double getEndY() { return points[points.length - 1].getY(); }
    
    public void define(Point[] points) {
        
        this.points = points;
        
    }
    
    public Rectangle getBoundingBox() {
        
		int minX = (int)Math.min(points[0].getX(), points[points.length - 1].getX());
		int minY = (int)Math.min(points[0].getY(), points[points.length - 1].getY());
		int maxX = (int)Math.max(points[0].getX(), points[points.length - 1].getX());
		int maxY = (int)Math.max(points[0].getY(), points[points.length - 1].getY());
        
		return new Rectangle(minX - thickness / 2, minY - thickness / 2, 
							 maxX - minX + thickness, maxY - minY + thickness);
        
    }
    
    public void paint(Graphics2D g) {
                
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(thickness));
        g.setColor(color);
        
        Point one = points[0];
        Point two = points[points.length - 1];
        g.drawLine((int)one.getX(), (int)one.getY(), (int)two.getX(), (int)two.getY());
        
        g.setStroke(oldStroke);        
        
    }
    
}
