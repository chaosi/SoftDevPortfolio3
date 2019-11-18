
import java.util.ArrayList;


public class GraphTests {
    private static ArrayList<String> pathStr = new ArrayList<>();

    public static void main(String[] args) {

        // Create graph
        GraphTests TestGraph= new GraphTests();

        Graph g = TestGraph.MakeSmallGraph();
        Vertex source = g.getvertex("A");
        Vertex zink = g.getvertex("F");
        pathStr =g.ShortestDistance(source, zink);

        System.out.println(" shortest From A to F");
        System.out.println(pathStr.toString());
        System.out.println(" -----------------");


        Graph g2 = TestGraph.MakeSmallGraph2();
         source = g2.getvertex("10");
         zink = g2.getvertex("6");
        pathStr =g2.ShortestDistance(source, zink);

        System.out.println(" shortest From 10 to 6");
        System.out.println(pathStr.toString());
        System.out.println(" -----------------");

    }
    public Graph MakeSmallGraph()
    {
        Graph mygraph= new Graph();
        final Vertex A=mygraph.addvertex("A");
        final Vertex B= mygraph.addvertex("B");
        final Vertex C =mygraph.addvertex("C");
        final Vertex D = mygraph.addvertex("D");
        final Vertex E = mygraph.addvertex("E");
        final Vertex F = mygraph.addvertex("F");

        mygraph.newedge(A,B,1,2);
        mygraph.newedge(A,C, 5,1);
        mygraph.newedge(A,D, 4,6);
        mygraph.newedge(B,C, 3,2);
        mygraph.newedge(B,D, 2,3);
        mygraph.newedge(B,E, 2,4);
        mygraph.newedge(C,F, 1,8);
        mygraph.newedge(C,E, 2,2);
        mygraph.newedge(D,F, 2,7);
        mygraph.newedge(E,F, 3,6);


        return mygraph;

    }

    public Graph MakeSmallGraph2()
    {
        Graph mygraph= new Graph();
        final Vertex A =mygraph.addvertex("1");
        final Vertex B= mygraph.addvertex("2");
        final Vertex C =mygraph.addvertex("3");
        final Vertex D = mygraph.addvertex("4");
        final Vertex E = mygraph.addvertex("5");
        final Vertex F = mygraph.addvertex("6");
        final Vertex G = mygraph.addvertex("7");
        final Vertex H = mygraph.addvertex("8");
        final Vertex I = mygraph.addvertex("9");
        final Vertex J = mygraph.addvertex("10");

        mygraph.newedge(A,G,15,0);
        mygraph.newedge(A,F,5,0);
        mygraph.newedge(A,E,20,0);
        mygraph.newedge(B,D,10,0);
        mygraph.newedge(B,C,5,0);
        mygraph.newedge(C,D,5,0);
        mygraph.newedge(D,E,10,0);
        mygraph.newedge(E,F,5,0);
        mygraph.newedge(G,F,10,0);
        mygraph.newedge(H,G,5,0);
        mygraph.newedge(H,A,5,0);
        mygraph.newedge(H,B,20,0);
        mygraph.newedge(I,H,20,0);
        mygraph.newedge(I,B,15,0);
        mygraph.newedge(I,J,10,0);
        mygraph.newedge(J,C,15,0);
        mygraph.newedge(J,B,5,0);





        return mygraph;

    }
}
