/**
 * @author Artur Guimarães
 */
public class Vertex {
    
    PointDouble3D vertex;
    String name;
    
    public Vertex(String name, PointDouble3D point) {
        this.name = name;
        this.vertex = point;
    }
    
    public Vertex(String name, Point3D point) {
        this.name = name;
        this.vertex = new PointDouble3D(point);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s", this.name, this.vertex.getPoint());
    }
}