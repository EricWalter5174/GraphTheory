
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class DiGraph extends Graph{

    public Map<Integer,Vertex> vertices = new HashMap<> ();

    @Override
    public void readFile(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(file)).useLocale(Locale.US);
        numberOfVertices = reader.nextInt();
        numberOfEdges = reader.nextInt();
        ArrayList<Integer> addedVertices = new ArrayList<>();

        while (reader.hasNext()) {
            int tempFrom = reader.nextInt();
            int tempTo = reader.nextInt();
            double tempWeight = reader.nextDouble();
            if (!addedVertices.contains(tempFrom)) {
                vertices.put(tempFrom, new Vertex(tempFrom, tempWeight));
                addedVertices.add(tempFrom);
            }
            if (!addedVertices.contains(tempTo)) {
                vertices.put(tempTo, new Vertex(tempTo, tempWeight));
                addedVertices.add(tempTo);
            }
            Edge tempEdge = new Edge(getVertexById(tempFrom), getVertexById(tempTo), tempWeight);
            edges.add(tempEdge);
            vertices.get(tempFrom).addNeighbor(tempEdge);
        }

    }

}
