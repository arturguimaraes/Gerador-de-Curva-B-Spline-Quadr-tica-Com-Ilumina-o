/**
 * @author Artur Guimarães
 */
public class Vertex {
    
    Point3D coordinate;
    String name;
    
    public Vertex(String name, Point3D point) {
        this.name = name;
        this.coordinate = point;
    }
    
    public Vertex(String name, PointDouble3D point) {
        this.name = name;
        this.coordinate = new Point3D(point);
    }
    
    public Vertex(String name, int x, int y) {
        this.name = name;
        this.coordinate = new Point3D(x,y);
    }
    
    public Vertex(String name, int x, int y, int z) {
        this.name = name;
        this.coordinate = new Point3D(x,y,z);
    }
    
    public Vertex(String name, double x, double y) {
        this.name = name;
        this.coordinate = new Point3D(x, y);
    }
    
    public Vertex(String name, double x, double y, double z) {
        this.name = name;
        this.coordinate = new Point3D(x, y, z);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s", this.name, this.coordinate.toString());
    }
}