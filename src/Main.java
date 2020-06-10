import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileTinyEWG = new File("res/tinyEWG.txt");
        File fileTinyFN = new File("res/tinyFN.txt");
        File mediumEWG = new File("res/mediumEWG.txt");

        Graph graph = new Graph();
        DiGraph diGraph = new DiGraph();

        Scanner scanner = new Scanner(System.in);

        int fileInput = 0;
        int userInput = 0;
        int exit = -1;

        /*
        * Choose one of the predefined files, because they have
        * the right format for the algorithms to work properly
        * */
        while(fileInput != exit){
            System.out.println("\nPlease choose a file:" +
                    "\n(1) TinyEWG.txt" +
                    "\n(2) TinyFN.txt" +
                    "\n(3) mediumEWG.txt");
            fileInput = scanner.nextInt();

            switch(fileInput){
                case 1:
                    System.out.println("File path: " + fileTinyEWG.getAbsolutePath());
                    graph.readFile(fileTinyEWG);
                    diGraph.readFile(fileTinyEWG);
                    fileInput = exit;
                    break;
                case 2:
                    System.out.println("File path: " + fileTinyFN.getAbsolutePath());
                    graph.readFile(fileTinyFN);
                    diGraph.readFile(fileTinyFN);
                    fileInput = exit;
                    break;
                case 3:
                    System.out.println("File path: " + mediumEWG.getAbsolutePath());
                    graph.readFile(mediumEWG);
                    diGraph.readFile(mediumEWG);
                    fileInput = exit;
                    break;
                default:
                    break;
            }
        }

        /*
        * Choose an algorithm to go with the chosen file
        * */
        while(userInput != exit) {
            System.out.println("\nPlease choose an algorithm:" +
                    "\n(1) Kruskal's Algorithm" +
                    "\n(2) Dijkstra's Algorithm" +
                    "\n(9) Exit");

            userInput = scanner.nextInt();

            switch(userInput){
                case 1:
                    System.out.println("Kruskal's algorithm (undirected graph):\n");
                    Kruskal kruskal = new Kruskal();
                    kruskal.printGraph(kruskal.kruskal(graph));
                    break;
                case 2:
                    System.out.println("Dijkstra's algorithm (directed graph):\n");
                    Dijkstra dijkstra = new Dijkstra(diGraph);
                    dijkstra.getShortestPath();
                    dijkstra.printPath(diGraph.vertexMap.get(diGraph.numberOfVertices-1));
                    break;
                case 9:
                    userInput = exit;
                    break;
                default:
                    break;
            }
        }





    }
}
