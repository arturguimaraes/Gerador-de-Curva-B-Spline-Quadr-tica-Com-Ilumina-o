/**
 * @author Artur Guimarães
 */
public class Edge {
    
    String name;
    Vertex vertex1, vertex2;
    
    public Edge(String name, Vertex v1, Vertex v2) {
        this.name = name;
        this.vertex1 = v1;
        this.vertex2 = v2;
    }
    
    @Override
    public String toString() {
        return String.format("%s: [%s,%s]", this.name, vertex1.name, vertex2.name); 
    }
}