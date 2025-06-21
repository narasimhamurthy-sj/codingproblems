package dataStructureSet3;


import java.util.HashMap;
import java.util.HashSet;

/*
Undirected Graph - will have path from point A to B and B to A
Directed Graph - will have one way i.e., path from point A to B.

Graph representation:
0 -> [1, 4]
1 -> [0, 2, 3, 4]
2 -> [1, 3]
3 -> [1, 2, 4]
4 -> [0, 1, 3]


steps:
1.Store vertex as HashMap key and value as associated edges

For HashMap value i.e associated edges, store it as HashSet. In case of undirected graph, as connection or edges are two-way,
to avoid duplicate entries, HashSet should be used.
Ex: vertex 1 has edge to 3
    vertex 3 has edge to 1

   During insertion of edge 1 to 3, we insert
   1 to 3 and
   3 to 1   by default

   If in case, trying to insert edge from 3 to 1 again(duplicate),
   3 to 1 and
   1 to 3

   In this case, duplicate entries will not be stored. Hence, HashSet should be used

 2. Create instance of HashMap under constructor of class.  This helps to create new graph
 as and when we create new instance of graph class.
 If we create HashMap instance outside of constructor,  each time new graph data also will be
 stored under previous graph details.
3. insert edge: if its undirected graph, insert edges for both side of vertex. ie., point A to B and B to A
   We can achieve this with below steps:
    1.HashMap getKey returns value that is HashSet,
    2.Add destination vertex or point B in HashSet.
    3.We should give bidirectional path i.,e
    A  to B and
    B to A

Tests:
1.create graph in which all vertices have edge and print
2.create graph in which 2  vertices doesn't have edge
3.Try to insert duplicate edge
4.create graph in which multiple vertices have edge to more than 1 vertex
5.create graph in which all vertices don't have edge
6. Graph with multiple cycles in it
7. Try to insert an edge in which vertex A doesn't exist but vertex B exists
8. Try to insert an edge in which vertex A exists but vertex B doesn't exist
9. Try to insert an edge in which vertex A and vertex B doesn't exist
10. Create multiple graphs with vertices and print


 */
public class SimpleGraph {
    HashMap<Integer, HashSet<Integer>> vertexMap;

    public SimpleGraph() {
        vertexMap = new HashMap<>();
    }

    public static void main(String[] args) {

        SimpleGraph graph = insertVertices(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        graph.insertEdgeInUndirectedGraph(1, 2);
        graph.insertEdgeInUndirectedGraph(1, 3);
        graph.insertEdgeInUndirectedGraph(2, 5);
        graph.insertEdgeInUndirectedGraph(2, 4);
        graph.insertEdgeInUndirectedGraph(3, 4);
        graph.insertEdgeInUndirectedGraph(3, 7);
        graph.insertEdgeInUndirectedGraph(4, 6);
        graph.insertEdgeInUndirectedGraph(4, 9);
        graph.insertEdgeInUndirectedGraph(5, 6);
        graph.insertEdgeInUndirectedGraph(6, 8);
        graph.insertEdgeInUndirectedGraph(6, 9);
        graph.insertEdgeInUndirectedGraph(7, 8);
        graph.insertEdgeInUndirectedGraph(8, 9);
        graph.printGraph();
        System.out.println("------second Graph -------");
        SimpleGraph secondGraph = insertVertices(new int[]{50, 60, 70, 80, 90});

        secondGraph.insertEdgeInUndirectedGraph(50, 60);
        secondGraph.insertEdgeInUndirectedGraph(60, 70);
        secondGraph.insertEdgeInUndirectedGraph(70, 80);
        secondGraph.insertEdgeInUndirectedGraph(80, 90);
        secondGraph.printGraph();


    }


    private static SimpleGraph insertVertices(int[] vertexArray) {
        SimpleGraph graph = new SimpleGraph();
        for (int vertex : vertexArray) {
            graph.insertVertex(vertex);
        }
        return graph;
    }

    public void insertVertex(int vertexValue) {
        vertexMap.put(vertexValue, new HashSet<>());
    }

    public void insertEdgeInUndirectedGraph(int vertexA, int vertexB) {
        if (vertexMap.containsKey(vertexA)) {
            vertexMap.get(vertexA).add(vertexB);
        } else {
            System.out.println(vertexA + " vertex not found");
            return;
        }

        if (vertexMap.containsKey(vertexB)) {
            vertexMap.get(vertexB).add(vertexA);
        } else {
            System.out.println(vertexB + " vertex not found");
        }
    }

    public HashMap<Integer, HashSet<Integer>> printGraph() {
        for (Integer vertex : vertexMap.keySet()) {
            if (vertexMap.get(vertex).isEmpty()) {
                System.out.println("vertex: " + vertex + " has no edges");
            } else {
                System.out.println("vertex: " + vertex + " has edges to ------> " + vertexMap.get(vertex));
            }
        }
        return vertexMap;
    }
}
