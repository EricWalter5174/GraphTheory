import java.security.DigestException;

public class Dijkstra {

    public static final double INFINITY = Double.MAX_VALUE;
    DiGraph graph;

    public Dijkstra(DiGraph graph){
        this.graph = graph;
    }

    public void getShortestPath(){
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
                if(!v.getVisited() && v.getDist() > u.getDist() + e.getWeight()){
                    v.setDist(u.getDist() + e.getWeight());
                    v.setPrev(u);
                    pq.update(v.getId(),v.getDist());
                }
            }
        }
    }

    public void printPath(Vertex dest) {
        if(!graph.vertexMap.containsKey(dest.getId())) {
            System.out.println("Destination does not exist");
            return;
        }
        Vertex x = graph.vertexMap.get(dest.getId());
        double sDist = x.getDist();
        while(x.getPrev() != null) {
            System.out.print(x.getId() + "(" + x.getDist()+")<------(" + x.getPrev().getDist() + ")");
            x = x.getPrev();
            System.out.println(x.getId());
        }
        System.out.println(("Total length: " + sDist));

    }


}