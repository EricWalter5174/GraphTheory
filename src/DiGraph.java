
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

class DiGraph extends Graph{

    public   Map<Integer,Vertex> vertices = new HashMap<> ();

    public boolean BFS(Integer from, Integer to, int max) {
        for(Vertex u : vertices.values()) {
            u.setPrev(null);
            u.setVisited(false);
            u.setDist(0.0);
        }
        vertices.get(from).setPrev(null);
        vertices.get(from).setVisited(true);
        Queue<Vertex> q = new LinkedList<>();
        q.add(vertices.get(from));

        while(!q.isEmpty()) {
            Vertex u = q.poll();
            if(u.getDist() > max) {
                return false;
            }
            if(u == vertices.get(to)) {
                return true;
            }
            for(Edge v : u.getNeighbors()) {
                if(v.getTo().getVisited() == false) {
                    v.getTo().setVisited(true);
                    v.getTo().setPrev(u);
                    v.getTo().setDist(u.getDist()+1);
                    q.add(v.getTo());
                }
            }

        }
        return false;
    }

}
