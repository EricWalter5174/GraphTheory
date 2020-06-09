import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskal {

    public ArrayList<Edge> kruskal(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.getNumberOfEdges(), Comparator.comparingDouble(o -> o.getWeight()));

        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i < graph.getEdges().size(); i++) {
            pq.add(graph.getEdges().get(i));
        }

        //create a parent array
        int[] parent = new int[graph.getNumberOfVertices()];

        //makeset
        makeSet(parent, graph);

        ArrayList<Edge> mst = new ArrayList<>();

        //process vertices - 1 edges
        int index = 0;
        while (index < graph.getNumberOfEdges() - 1) {
            Edge edge = pq.remove();
            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.getFrom().getId());
            int y_set = find(parent, edge.getTo().getId());

            //only add edge if it does not form a cycle
            if (x_set != y_set) {
                mst.add(edge);
                union(parent, x_set, y_set);
            }
            index++;
        }
        return mst;
    }

    private void makeSet(int[] parent, Graph graph) {
        //Make set- creating a new element with a parent pointer to itself.
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            parent[i] = i;
        }
    }

    private int find(int[] parent, int vertex) {
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if (parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    private void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }

    public void printGraph(ArrayList<Edge> edgeList) {
        System.out.println("Edges of minimal spanning tree: ");
        double temp = 0.0;
        for (Edge edge : edgeList) {
            temp += edge.getWeight();
            System.out.println("(" + edge.getFrom().getId() +
                    "," + edge.getTo().getId() + ")");
        }
        System.out.printf("Weight of the MST: %.2f %n", temp); // rounds down to 2 decimals
    }

}
