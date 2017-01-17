import java.util.*;
        
/**
 * @author Artur Guimarães
 */
public class DataStructure {
    
    PointDouble3D[] surfacePointspoint;
    PointDouble3D[] deslocatedSurfacePoints;
    static List<Vertex> vertexes;
    static List<Edge> edges;
    static List<Face> faces;
    
    public DataStructure () {
        vertexes = new ArrayList<>();
        edges = new ArrayList<>();
        faces = new ArrayList<>();
    }
    
    /**
     *
     * @param dataStructurePoints
     * @param deslocatedDataStructurePoints
     * @return
     */
    @SuppressWarnings("static-access")
    public static DataStructure generate(PointDouble3D[] dataStructurePoints, PointDouble3D[] deslocatedDataStructurePoints) {
        DataStructure dataStructure = new DataStructure();
        if (dataStructurePoints.length > 0 && deslocatedDataStructurePoints.length > 0 &&
                dataStructurePoints.length == deslocatedDataStructurePoints.length) {
            
            //Cria os vértices
            int vertexCount = 0;
            for (int i = 0; i < dataStructurePoints.length; i++) {
               Vertex v = new Vertex("V"+vertexCount++,dataStructurePoints[i]);
               dataStructure.vertexes.add(v);
            }
            for (int i = deslocatedDataStructurePoints.length-1; i >= 0; i--) {
               Vertex dv = new Vertex("V"+vertexCount++,deslocatedDataStructurePoints[i]);
               dataStructure.vertexes.add(dv);
            }
            
            //Cria as arestas
            int edgeCount = 0;
            for (int i = 0; i < dataStructurePoints.length; i++) {
                if (i < dataStructurePoints.length-1) {
                    Edge e1 = new Edge("E"+edgeCount++, getVertex(dataStructurePoints[i]),           getVertex(deslocatedDataStructurePoints[i]));
                    Edge e2 = new Edge("E"+edgeCount++, getVertex(dataStructurePoints[i]),           getVertex(deslocatedDataStructurePoints[i+1]));
                    Edge e3 = new Edge("E"+edgeCount++, getVertex(deslocatedDataStructurePoints[i]), getVertex(deslocatedDataStructurePoints[i+1]));
                    Edge e4 = new Edge("E"+edgeCount++, getVertex(dataStructurePoints[i]),           getVertex(dataStructurePoints[i+1]));
                    dataStructure.edges.add(e1);
                    dataStructure.edges.add(e2);
                    dataStructure.edges.add(e3);
                    dataStructure.edges.add(e4);
                }
                else if (i == dataStructurePoints.length-1) {
                    Edge lastEdge = new Edge("E"+edgeCount++,getVertex(dataStructurePoints[i]), getVertex(deslocatedDataStructurePoints[i]));
                    dataStructure.edges.add(lastEdge);
                }
            }
            
            //Cria as faces
            int faceCount = 0;
            for (int i = 0; i < dataStructurePoints.length; i++) {
                if (i < dataStructurePoints.length-1) {
                    Edge e1 = getEdge(getVertex(dataStructurePoints[i]), getVertex(deslocatedDataStructurePoints[i]));
                    Edge e2 = getEdge(getVertex(dataStructurePoints[i]), getVertex(deslocatedDataStructurePoints[i+1]));
                    Edge e3 = getEdge(getVertex(deslocatedDataStructurePoints[i]), getVertex(deslocatedDataStructurePoints[i+1]));
                    Face f1 = new Face("F"+faceCount++, e1, e2, e3);
                    dataStructure.faces.add(f1);
                    
                    Edge e4 = getEdge(getVertex(dataStructurePoints[i]), getVertex(dataStructurePoints[i+1]));
                    Edge e5 = getEdge(getVertex(dataStructurePoints[i]), getVertex(deslocatedDataStructurePoints[i+1]));
                    Face f2 = new Face("F"+faceCount++, e4, e5, e2);
                    dataStructure.faces.add(f2);
                }
            }
            return dataStructure;
        }
        return null;
    }
    
    public static Vertex getVertex(PointDouble3D vertex) {
        if(vertexes.size() > 0 && vertex != null) {
            for (Vertex v : vertexes) {
                if (v.vertex == vertex)
                    return v;
            }
        }
        return null;
    }
    
    /**
     *
     * @param vertex1
     * @param vertex2
     * @return
     */
    public static Edge getEdge(Vertex vertex1, Vertex vertex2) {
        if(edges.size() > 0 && vertex1 != null && vertex2 != null) {
            for(Edge e : edges) {
                if ((e.vertex1 == vertex1 && e.vertex2 == vertex2) ||
                    (e.vertex1 == vertex2 && e.vertex2 == vertex1)) 
                    return e;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        String response = "--------- Estrutura de Dados ---------";        
        response += String.format("\n\nV:%d A:%d F:%d",vertexes.size(), edges.size(), faces.size());
        return response;
    }
}
