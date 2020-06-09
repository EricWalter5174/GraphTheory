
public class Dijkstra {
    public static final double INFINITY = Double.MAX_VALUE;

    public MinPQ getShortestPath(DiGraph graph, Vertex start){
        MinPQ pq = new MinPQ(graph.getNumberOfVertices());
        for(Vertex v : graph.vertexMap.values()){
            v.setVisited(false);
            v.setPrev(null);
            v.setDist(INFINITY);
            if(v.getId() == start.getId()){
                v.setDist(0);
            }
            pq.insert(v);
        }
        while (!(pq.isEmpty())){
            Vertex u = pq.extractElement();
            u.setVisited(true);
            for (Edge k : u.getNeighbors()){
                Vertex v = k.getTo();
                if(!v.getVisited() && v.getDist() > u.getDist() + k.getWeight()){
                    v.setDist(u.getDist() + k.getWeight());
                    v.setPrev(u);
                    pq.update(v.getId(),v.getDist());
                }
            }
        }
        return pq;
    }

}