import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileTinyEWG = new File("res/tinyEWG.txt");
        File fileTinyFN = new File("res/tinyFN.txt");
/*        Graph graph = new Graph();
        graph.readFile(fileTinyEWG);*/
        DiGraph diGraph = new DiGraph();

        diGraph.readFile(fileTinyFN);
        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.getShortestPath(diGraph).toString());

/*        Kruskal kruskal = new Kruskal();
        kruskal.printGraph(kruskal.kruskal(graph));*/


    }
}
