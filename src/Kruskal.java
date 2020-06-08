public class Kruskal {

    public static Graph getMinimumSpanningTree(Graph g){
        Graph MST = new Graph();
        g.sortEdgesByWeight();

        for (int i = 0; i < g.getNumberOfEdges(); i++) {
            Edge temp = g.getEdgeByIndex(i);
        }


        return MST;
    }

    public static void handleEdge(){
        
    }
}
