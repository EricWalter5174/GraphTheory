public class DiGraph {
    int vertices;
    double matrix[][];

    public DiGraph(int vertex) {
        this.vertices = vertex;
        matrix = new double[vertex][vertex];
    }

    public void addEdge(int source, int destination, double weight) {
        //add edge
        matrix[source][destination] = weight;

        //add back edge for undirected graph
        matrix[destination][source] = weight;
    }

    //get the vertex with minimum distance which is not included in SPT
    int getMinimumVertex(boolean[] mst, double[] key) {
        double minKey = Double.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (mst[i] == false && minKey > key[i]) {
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }
}
