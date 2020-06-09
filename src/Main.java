import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("res/tinyEWG.txt");
        DiGraph diGraph = new DiGraph();
        Graph graph = new Graph();
        diGraph.readFile(file);
        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.getShortestPath(diGraph, diGraph.getVertexById(0)).toString());

        /*Kruskal kruskal = new Kruskal();
        kruskal.printGraph(kruskal.kruskal(graph));*/


    }
}
