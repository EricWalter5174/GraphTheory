import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int id;
    private List<Edge> neighbors;
    private boolean visited;
    private Vertex prev;
    private double dist;


    public Vertex(int id){
        this.id = id;
    }

    public Vertex(int id, double d) {
        this.id = id;
        dist = d; // INFINITY
        prev = null;
        visited = false;
        neighbors = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    public boolean getVisited() {
        return visited;
    }

    public Vertex getPrev() {
        return prev;
    }

    public double getDist() {
        return dist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addNeighbor(Edge e) {
        neighbors.add(e);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    @Override
    public String toString() {
        return id +
                ", Distance= " + dist +
                '\n';
    }
}
