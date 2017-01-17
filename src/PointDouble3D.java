import java.awt.Color;

/**
 * @author Artur Guimarães
 */
public class PointDouble3D {
    double x, y, z;
    Color color;
    boolean painted;
    int index, brightness;
    
    public PointDouble3D(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0.0;
        this.initiate();
    }
    
    public PointDouble3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.initiate();
    }
    
    public PointDouble3D(Point3D point) {
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;this.initiate();
    }
    
    private void initiate() {
        this.setColor();
        this.setBrightness();
        this.painted = false;
        this.index = 0;
    }
    
    public PointDouble3D paint(int position) {
        PointDouble3D paintedPoint = new PointDouble3D(this.x,this.y,this.z);
        paintedPoint.painted = true;
        paintedPoint.index = position;
        paintedPoint.color = this.color;
        return paintedPoint;
    }
    
    public static PointDouble3D[] getPointDoubleVector(PointList pointList) {
        if (pointList.pointCount() > 0) {
            PointList pointer = pointList.getFirst();
            int posicao = 0;
            PointDouble3D[] pointVector = new PointDouble3D[pointList.pointCount()];
            while(posicao < pointList.pointCount()) {
                pointVector[posicao] = new PointDouble3D(pointer.point.x, pointer.point.y);
                pointer = pointer.son;
                posicao++;
            }
            return pointVector;
        }
        else
            return null;
    }
    
    public static PointDouble3D[] getDeslocatedPointDoubleVector(PointList pointList, double distance, int ratio) {
        if (pointList.pointCount() > 0) {
            PointDouble3D[] deslocatedPointVector = getPointDoubleVector(pointList);
            for (PointDouble3D deslocatedPoint : deslocatedPointVector) {
                deslocatedPoint.z += (distance/ratio);
            }
            return deslocatedPointVector;
        }
        else
            return null;
    }
    
    public static double getDistance(PointDouble3D p1, PointDouble3D p2) {
        if (p1 != null && p2 != null)
            return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
        return 0.0;
    }
    
    public static String printVector(PointDouble3D[] pointVector) {
        String resp = "";
        for (PointDouble3D point : pointVector)
            resp += "\n" + point;
        return  resp;
    }
    
    private void setColor() {
        setColor(Color.WHITE);
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    private void setBrightness() {
        setBrightness(255); 
    }
    
    private void setBrightness(int brightness) {
        this.brightness = brightness;
    }
        
    @Override
    public String toString() {
        return String.format("%s %s %s %s", getPoint(), getRGB(), getPainted(), getIndex());    
    }
    
    public String getPoint() {
        if (this.z == 0)
            return String.format("[%1.2f,%1.2f]", this.x, this.y);
        else
            return String.format("[%1.2f,%1.2f,%1.2f]", this.x, this.y, this.z);
    }
    
    private String getRGB() {
        return String.format("RGB:[%d,%d,%d]", this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    }
    
    private String getPainted() {
        return String.format("P:%s", this.painted);
    }
    
    private String getIndex() {
        return String.format("I:%s", this.index);
    }
}