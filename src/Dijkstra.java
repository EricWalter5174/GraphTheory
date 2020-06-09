
public class Dijkstra {

    public static final double INFINITY = Double.MAX_VALUE;

    public MinPQ getShortestPath(DiGraph graph){
        MinPQ pq = new MinPQ(graph.getNumberOfVertices());
        for(Vertex v : graph.vertexMap.values()){
            v.setVisited(false);
            v.setPrev(null);
            v.setDist(INFINITY);
            if(v.getId() == 0){
                v.setDist(0);
            }
            pq.insert(v);
        }
        while (!pq.isEmpty()){
            Vertex u = pq.extractElement();
            u.setVisited(true);
            for (Edge e : u.getNeighbors()){
                Vertex v = e.getTo();
                if(v.getVisited() == false && v.getDist() > u.getDist() + e.getWeight()){
                    v.setDist(u.getDist() + e.getWeight());
                    v.setPrev(u);
                    pq.update(v.getId(),v.getDist());
                }
            }
        }
        return pq;
    }

}