public class Edge {

    private Vertex from = null;
    private Vertex to = null;
    private double weight;
    private Color color = Color.GREY;

    public double getWeight () {
        return weight;
    }

    public Edge(Vertex from, Vertex to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Edge(Vertex from, Vertex to){
        this.from = from;
        this.to = to;
        weight = 1.0;
    }

    public void setColor(Color c){
        this.color = c;
    }
}

