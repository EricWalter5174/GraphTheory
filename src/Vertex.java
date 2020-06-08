import java.util.ArrayList;

public class Vertex {

    private boolean visited = false;
    private int id = 0;
    private ArrayList<Edge> edges = new ArrayList<>();
    private Color color = Color.GREY;

    public Vertex(int id) {
        this.id = id;
    }

    public void addEdge(Edge e){

    }
    public int getId(){
        return id;
    }
}
