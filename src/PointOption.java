/**
 * @author Artur Guimarães
 */
public class PointOption {
    
    int x, y, z, index;
    
    public PointOption(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.z = 0;
        this.index = index;
    }
    
    public PointOption(int x, int y, int z, int index) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
    }
    
    public PointOption(Point3D point, int index) {
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;
        this.index = index;
    }
    
    public Point3D getPoint() {
        return new Point3D(x,y,z);
    }
    
    @Override
    public String toString() {
        return String.format("Ponto %d [%d,%d, %d]", this.index, this.x, this.y, this.z);
    }
}