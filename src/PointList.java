/**
 * @author Artur Guimarães
 */
public class PointList {
    
    Point3D point;
    PointList father, son;
    
    public PointList() {
        father = null;
        point = null;
        son = null;
    }
    
    public PointList(Point3D p) {
        father = null;
        point = p;
        son = null;
    }
    
    @SuppressWarnings("LeakingThisInConstructor")
    public PointList(PointList pointList, Point3D p) {
        father = pointList;
        father.son = this;
        point = p;
    }
    
    public String getPoint() {
        if (point != null)
            return String.format("[%d,%d]", point.x, point.y);
        return "";
    }
    
    public int pointCount() {
        int count = 0;
        if (father != null)
            count += father.pointCount();
        if (point != null)
            count += 1;
        return count;
    }
    
    public PointOption[] getPointOptionArray() {
        PointList pointList = this;
        PointOption[] pointOptions = new PointOption[pointCount()];
        int pos = pointCount() - 1;
        
        for (int i = 0; i < pointCount(); i++) {    
            pointOptions[pos] = new PointOption(pointList.point, pos);
            pointList = pointList.father;
            pos--;
        }
 
        return pointOptions;
    }
    
    public PointList getFirst() {
        PointList pointer = this;
        while(pointer.father.point != null) 
            pointer = pointer.father;
        return pointer;
    }
    
    @Override
    public String toString() {
        String result = "";
        if (father != null) {
            result = father.toString();
            if (father.point != null)
                result += " -> ";  
        }
        result += getPoint();          
        return result;
    }    
}