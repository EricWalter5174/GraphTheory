import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileTinyEWG = new File("res/tinyEWG.txt");
        File fileTinyFN = new File("res/tinyFN.txt");

        Graph graph = new Graph();
        graph.readFile(fileTinyEWG);

        DiGraph diGraph = new DiGraph();
        diGraph.readFile(fileTinyFN);

        Scanner scanner = new Scanner(System.in);

        int userInput = 0;
        while(userInput != 9) {
            System.out.println("\nPlease choose an algorithm:" +
                    "\n(1) Kruskal's Algorithm" +
                    "\n(2) Dijkstra's Algorithm" +
                    "\n(9) Exit");

            userInput = scanner.nextInt();

            switch(userInput){
                case 1:
                    System.out.println("Kruskal's algorithm:\n");
                    Kruskal kruskal = new Kruskal();
                    kruskal.printGraph(kruskal.kruskal(graph));
                    break;
                case 2:
                    System.out.println("Dijkstra's algorithm:\n");
                    Dijkstra dijkstra = new Dijkstra();
                    System.out.println(dijkstra.getShortestPath(diGraph).toString());
                    break;
                case 9:

                    break;
                default:
                    break;
            }
        }





    }
}
