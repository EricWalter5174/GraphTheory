import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Graph {
    private int numberOfVertices = 0;
    private int numberOfEdges = 0;
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();

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
                vertices.add(new Vertex(tempFrom));
                addedVertices.add(tempFrom);
            }
            if (!addedVertices.contains(tempTo)) {
                vertices.add(new Vertex(tempTo));
                addedVertices.add(tempTo);
            }
            edges.add(new Edge(getVertexById(tempFrom), getVertexById(tempTo), tempWeight));
        }

    }

    public Vertex getVertexById(int id) {
        for (Vertex v : vertices) {
            if (v.getId() == id)
                return v;
        }
        return null;
    }

    public void sortEdgesByWeight(){
        ArrayList<Edge> temp = new ArrayList<>();

        for(int i= 0; i < numberOfEdges; i++) {
            int index = getIndexOfLowestEdgeByWeight();
            temp.add(edges.get(index));
            edges.remove(index);
        }
        edges = temp;
    }

    public int getIndexOfLowestEdgeByWeight() {
        int indexOflowestWeight = -1;
        double lowestWeight = Double.MAX_VALUE;

        for(int i = 0; i < edges.size(); i++) {
            if(edges.get(i).getWeight() < lowestWeight) {
                indexOflowestWeight = i;
                lowestWeight = edges.get(i).getWeight();
            }
        }
        return indexOflowestWeight;
    }

    public Edge getEdgeByIndex(int index){
        return edges.get(index);
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }


}
