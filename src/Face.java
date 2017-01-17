/**
 * @author Artur Guimarães
 */
public class Face {
    
    String name;
    Edge edge1, edge2, edge3;
    
    public Face(String name, Edge e1, Edge e2, Edge e3) {
        this.name = name;
        this.edge1 = e1;
        this.edge2 = e2;
        this.edge3 = e3;
    }
    
    @Override
    public String toString() {
        return String.format("%s: [%s,%s,%s,%s]", this.name, edge1.name, edge2.name, edge3.name);
    }
}