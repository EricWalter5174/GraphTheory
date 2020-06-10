public class MinPQ {
    private Vertex[] vertexArray;
    private int maxsize;
    private int currentsize;

    public MinPQ(int max) {
        currentsize = 0;
        maxsize = max;
        vertexArray = new Vertex[max+1];
        vertexArray[0] = new Vertex(0,0.0);

    }
    public boolean isEmpty() {
        return currentsize < 1;
    }
    public boolean insert(Vertex vertex) {
        if(currentsize == maxsize) {
//			 throw new IllegalArgumentException("heap overflow");
            System.out.println("heap overflow");
            return false;
        }
        currentsize ++;
        vertexArray[currentsize] = vertex;

        upheap(currentsize);
        return true;
    }

    public Vertex extractElement() {
        if(isEmpty()) {
            System.out.println("heap underflow");
            return null;
        }
        Vertex min = vertexArray[1];
        vertexArray[1] = vertexArray[currentsize];
        currentsize --;
        downheap(1);
        return min;
    }
    public int extractData() {
        return extractElement().getId();
    }

    private void downheap(int i) {
        int l = left(i);
        int r = right(i);
        int largest = 0;
        if(l <= currentsize && vertexArray[l].getDist() < vertexArray[i].getDist()) {
            largest = l;
        } else {
            largest = i;
        }
        if(r <= currentsize && vertexArray[r].getDist() < vertexArray[largest].getDist()) {
            largest = r;
        }
        if(largest != i) {
            swap(i, largest);
            downheap(largest);
        }

    }

    private void upheap(int i) {
        while(i > 1 && vertexArray[parent(i)].getDist() > vertexArray[i].getDist()){
            swap(i, parent(i));
            i = parent(i);
        }
    }
    private int parent(int i) {
        return i / 2;
    }
    private int left(int i) {
        return 2 * i;
    }
    private int right(int i) {
        return 2 * i + 1;
    }
    private void swap(int x, int y) {
        Vertex temp = vertexArray[x];
        vertexArray[x] = vertexArray[y];
        vertexArray[y] = temp;
    }

    public void update(int id, double n) {
        double prio = 0;
        int i = 1;
        while(i <= currentsize){
            if(vertexArray[i].getId() ==  id) {
                prio = vertexArray[i].getDist();
                vertexArray[i].setDist(n);
                break;
            }
            i++;
        }
        if(i == currentsize+1) {
            System.out.println("No such element with ID: " + id);
        }
        if(n > prio) {
            downheap(i);
        }
        if(n < prio) {
            upheap(i);
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Vertex v : vertexArray){
            sb.append(v.toString());
        }
        return sb.toString();
    }

}
