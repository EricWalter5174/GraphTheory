import java.lang.reflect.Array;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {
    public static final double INFINITY = Double.MAX_VALUE;

    public MinPQ getShortestPath(DiGraph graph, Vertex start){
        MinPQ pq = new MinPQ(graph.getNumberOfVertices());
        for(Vertex v : graph.getVertices()){
            v.setVisited(false);
            v.setPrev(null);
            v.setDist(INFINITY);
            if(v == graph.vertices.get(start)){
                v.setDist(0);
            }
            pq.insert(v);
        }
        while (!(pq.isEmpty())){
            Vertex u = pq.extractElement();
            u.setVisited(true);
            for (Edge k : u.getNeighbors()){
                Vertex v = k.getTo();
                if(v.getVisited() == false && v.getDist() > u.getDist() + k.getWeight()){
                    v.setDist(u.getDist() + k.getWeight());
                    v.setPrev(u);
                    pq.update(v.getId(),v.getDist());
                }
            }
        }
        return pq;
    }

}