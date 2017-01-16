/**
 * @author Artur Guimarães
 */
public class DataStructure2 {
    
    Vertex[] vertexes;
    Edge[] edges;
    Face[] faces;
    
    public DataStructure2() {
    }

    public void setVertexes(Vertex[] vertexes) {
        this.vertexes = vertexes;
    }
    
    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }
    
    public void setFaces(Face[] faces) {
        this.faces = faces;
    }
    
    @Override
    public String toString() {
        String response = "--------- Estrutura de Dados ---------";
        
        response += "\n\nVértices:";
        for (Vertex vertex : vertexes)
            response += "\n" + vertex.toString();
        
        response += "\n\nArestas:";
        for (Edge edge: edges)
            response += "\n" + edge.toString();
        
        response += "\n\nFaces:";
        for (Face face: faces)
            response += "\n" + face.toString();
        
        response += String.format("\n\nFórmula de Euler obedecida: %d - %d + %d = %d",vertexes.length, edges.length, faces.length, (vertexes.length - edges.length + faces.length));
              
        return response;
    }
}