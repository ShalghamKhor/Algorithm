package assignment3.task4;

public class VertexDistance {
    int vertex;
    double distance;

    public VertexDistance(int vertex, double distance){
        this.vertex = vertex;
        this.distance = distance;
    }

    public int getVertex(){
        return vertex;
    }

    public double getDistance(){
        return distance;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    @Override
    public String toString(){
        return "vertex " + vertex + " with distance " + distance;
    }
}
