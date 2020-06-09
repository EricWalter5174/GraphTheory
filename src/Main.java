import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileTinyEWG = new File("res/tinyEWG.txt");
        File fileTinyFN = new File("res/tinyFN.txt");

        DiGraph diGraph = new DiGraph();
        Graph graph = new Graph();
        diGraph.readFile(fileTinyFN);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.getShortestPath(diGraph, diGraph.vertexMap.get(0));

        /*Kruskal kruskal = new Kruskal();
        kruskal.printGraph(kruskal.kruskal(graph));*/


    }
}
