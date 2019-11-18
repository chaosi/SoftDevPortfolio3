import java.util.*;
import javafx.util.Pair;

public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();
    private ArrayList<String> pathStr = new ArrayList<>();


    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }


    public Vertex getvertex(String s)
    {
        for(Vertex v : Vertices )
        {
            if (v.Name==s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge=new Edge(from,to);
        newedge.distance=dist;
        newedge.time=tim;


    }

    public  ArrayList<String> ShortestDistance(Vertex source, Vertex zink)
    {
        Map<Vertex,Vertex> PredecessorMap= new HashMap<>();
        Map<Vertex,Integer> DistanceMap=new HashMap<>();
        int time = 0;
        int dist = 0;

        Vertex indexPoint = source;

        // initialize arrays

        for(Vertex v: Vertices)
        {
            if(v.Name.equals(source.Name))
            {
                DistanceMap.put(v,0);
            }
            else
            {
                DistanceMap.put(v,1000);
            }
            PredecessorMap.put(v, null);
        }




        //loop vertice
        for (int l = 0; l < Vertices.size(); l++)
        {
            int minVal = 10000;//min value in edge path ( initilize placeholder value)
            int minValueI = -1; // index min value in edge path ( initilize placeholder value)


            //loop edges
            for (int i = 0; i < indexPoint.getOutEdges().size(); i++) {
                //Check if not allready visited or same
                if (!indexPoint.Name.equals(indexPoint.getOutEdges().get(i).getTovertex().Name) &&  PredecessorMap.get(indexPoint.getOutEdges().get(i).getTovertex()) == null)
                {
                    int calt =  (indexPoint.getOutEdges().get(i).distance + indexPoint.getOutEdges().get(i).time) + DistanceMap.get(indexPoint); //adding up the move cost

                    if (DistanceMap.get(indexPoint.getOutEdges().get(i).getTovertex()) >= calt ) //check if move cost i lower
                    {
                        DistanceMap.replace(indexPoint.getOutEdges().get(i).getTovertex(), calt);//replace value
                    }

                    if (DistanceMap.get(indexPoint.getOutEdges().get(i).getTovertex()) <= minVal) // find the lowest value
                    {
                        minVal = DistanceMap.get(indexPoint.getOutEdges().get(i).getTovertex());// add lowest value from loop (i)
                        minValueI = i; // get index of lowest value
                    }
                }

            }

            time += indexPoint.getOutEdges().get(minValueI).time;
            dist += indexPoint.getOutEdges().get(minValueI).distance;

            PredecessorMap.replace(indexPoint,indexPoint.getOutEdges().get(minValueI).getTovertex());// add to path/visited map using minValueI as index pointer
            indexPoint = indexPoint.getOutEdges().get(minValueI).getTovertex(); // move to lowest cost vertex point using minValueI as index pointer

            if(indexPoint.Name.equals(zink.Name))// break when goal found
            {
                break;
            }
        }




        pathStr.clear();//  making sure is empty
        Vertex out =  PredecessorMap.get(source);// get start point
        pathStr.add(source.Name + "->");

        while (true)// going through PredecessorMap and add to arraylist until Goal found
        {

            pathStr.add("("+DistanceMap.get(out) +")"+ out.Name +"->"  );
            if (out == zink)
            {
                break;
            }
           out = PredecessorMap.get(out);

        }

        pathStr.add("(total Time "+ time +" )");
        pathStr.add("(total Distance "+ dist +" )");



        return pathStr;// return arraylist with path and cost
    }




}




class Vertex{
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        Name=id;
    }
    public void addOutEdge(Edge outedge){
        OutEdges.add(outedge);
    }
    public ArrayList<Edge> getOutEdges(){return OutEdges;}
}



class Edge{
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance=0;
    public int time=0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to){
        fromvertex=from;
        tovertex=to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }



}


