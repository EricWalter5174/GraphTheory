import java.util.Arrays;

public class MinPQ {
    private Vertex[] e;
    private int maxsize;
    private int currentsize;

    public MinPQ(int max) {
        currentsize = 0;
        maxsize = max;
        e = new Vertex[max+1];
        e[0] = new Vertex(0,0.0);

    }
    public boolean isEmpty() {
        return currentsize < 1;
    }
    public boolean insert(Vertex n) {
        if(currentsize == maxsize) {
//			 throw new IllegalArgumentException("heap overflow");
            System.out.println("heap overflow");
            return false;
        }
        currentsize ++;
        e[currentsize] = n;

        upheap(currentsize);
        return true;
    }

    public Vertex extractElement() {
        if(isEmpty()) {
            System.out.println("heap underflow");
            return new Vertex(0,0.0);
        }
        Vertex min = e[1];
        e[1] = e[currentsize];
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
        if(l <= currentsize && e[l].getDist() < e[i].getDist()) {
            largest = l;
        } else {
            largest = i;
        }
        if(r <= currentsize && e[r].getDist() < e[largest].getDist()) {
            largest = r;
        }
        if(largest != i) {
            swap(i, largest);
            downheap(largest);
        }

    }

    private void upheap(int i) {
        while(i > 1 && e[parent(i)].getDist() > e[i].getDist()){
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
        Vertex temp = e[x];
        e[x] = e[y];
        e[y] = temp;
    }

    public void update(int id, double n) {
        double prio = 0;
        int i = 1;
        while(i <= currentsize){
            if(e[i].getId() ==  id) {
                prio = e[i].getDist();
                e[i].setDist(n);
                break;
            }
            i++;
        }
        if(i == currentsize+1) {
            System.out.println("No such element with ID: " +id);
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
        for(Vertex v : e){
            sb.append(v.toString());
        }
        return sb.toString();
    }

}
