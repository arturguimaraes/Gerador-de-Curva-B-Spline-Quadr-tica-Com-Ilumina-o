import java.awt.Point;

/**
 * @author Artur Guimarães
 */
public class Point3D {
    
    int x, y, z;
    
    public Point3D(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    
    public Point3D(double x, double y) {
        this.x = (int) Math.round(x);
        this.y = (int) Math.round(y);
        this.z = 0;
    }
    
    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Point3D(double x, double y, double z) {
        this.x = (int) Math.round(x);
        this.y = (int) Math.round(y);
        this.z = (int) Math.round(z);
    }
    
    public Point3D(PointDouble3D point) {
        this.x = (int) Math.round(point.x);
        this.y = (int) Math.round(point.y);
        this.z = (int) Math.round(point.z);
    }
    
    public static Point3D getPoint3DFrom2D(Point point) {
        return new Point3D(point.x, point.y);
    }
    
    @SuppressWarnings("LocalVariableHidesMemberVariable")
    public Point3D[] getSubPoints(Point3D lastPoint, int precision) {
        if (precision > 1) {
            Point3D[] points = new Point3D[precision+2];
            points[0] = this;
            points[precision+1] = lastPoint;
            int difX = lastPoint.x - this.x;
            int difY = lastPoint.y - this.y;
            for (int i = 1; i < precision+1; i++) {
                
                int x = Math.round(points[i-1].x + difX/precision);
                int y = Math.round(points[i-1].y + difY/precision);
                points[i] = new Point3D(x,y); 
            }        
            return points;
        }
        return null;
    }
    
    public static double getDistance(Point3D p1, Point3D p2) {
        if (p1 != null && p2 != null)
            return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
        return 0;
    }
    
    @Override
    public String toString() {
        return String.format("[%d,%d,%d]",this.x,this.y,this.z);
    }
}