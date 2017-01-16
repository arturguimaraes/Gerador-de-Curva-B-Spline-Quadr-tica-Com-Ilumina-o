/**
 * @author Artur Guimarães
 */
public class Face {
    
    String name;
    Edge edge1, edge2, edge3, edge4;
    
    public Face(String name, Edge e1, Edge e2, Edge e3, Edge e4) {
        this.name = name;
        this.edge1 = e1;
        this.edge2 = e2;
        this.edge3 = e3;
        this.edge4 = e4;
    }
    
    @Override
    public String toString() {
        return String.format("%s: [%s,%s,%s,%s]", this.name, edge1.name, edge2.name, edge3.name, edge4.name);
    }
}