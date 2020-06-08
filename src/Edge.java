public class Edge {

    private Vertex from = null;
    private Vertex to = null;
    private double weight;

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

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }
}

