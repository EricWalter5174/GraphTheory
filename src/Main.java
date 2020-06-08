import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("res/tinyEWG.txt");
        Graph graph = new Graph();
        graph.readFile(file);
        Kruskal kruskal = new Kruskal();
        kruskal.printGraph(kruskal.kruskal(graph));


    }
}
