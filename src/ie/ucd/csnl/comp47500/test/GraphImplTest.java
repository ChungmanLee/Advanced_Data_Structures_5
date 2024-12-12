package ie.ucd.csnl.comp47500.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.ucd.csnl.comp47500.implementation.GraphImpl;
import ie.ucd.csnl.comp47500.model.Vertex;

class GraphImplTest {
    private GraphImpl<String> graph;
    Vertex<String> v1;
    Vertex<String> v2;
    Vertex<String> v3;
    Vertex<String> v4;
    @BeforeEach
    void setUp() {
        graph = new GraphImpl<>();
        v1 = new Vertex<>() {
            @Override
            public String getData() {
                return "A";
            }
        };
        v2 = new Vertex<>() {
            @Override
            public String getData() {
                return "B";
            }
        };
        v3 = new Vertex<>() {
            @Override
            public String getData() {
                return "C";
            }
        };
        v4 = new Vertex<>() {
            @Override
            public String getData() {
                return "D";
            }
        };
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
    }


    @Test
    void testAddMultipleVerticesAndEdges() {


        // Add edges
        graph.addEdge(v1, v2, 5, false);
        graph.addEdge(v1, v3, 7, false);
        graph.addEdge(v2, v3, 3, false);
        graph.addEdge(v3, v4, 4, false);

        // Test vertex count
        assertEquals(4, graph.getVertexCount());

        // Test edge count
        assertEquals(4, graph.getEdgeCount(false));

        // Test presence of vertices
        assertEquals(true, graph.hasVertex(v1));
        assertEquals(true, graph.hasVertex(v2));
        assertEquals(true, graph.hasVertex(v3));
        assertEquals(true, graph.hasVertex(v4));

        // Test presence of edges
        assertEquals(true, graph.hasEdge(v1, v2));
        assertEquals(true, graph.hasEdge(v1, v3));
        assertEquals(true, graph.hasEdge(v2, v3));
        assertEquals(true, graph.hasEdge(v3, v4));
        assertEquals(false, graph.hasEdge(v2, v1));	//test false for bidirection
        assertEquals(false, graph.hasEdge(v1, v4));	// test for a nonexistent edge

        // Test weights of edges
        assertEquals(5, graph.getEdgesFrom(v1).get(0).getWeight());
        assertEquals(7, graph.getEdgesFrom(v1).get(1).getWeight());
        assertEquals(3, graph.getEdgesFrom(v2).get(0).getWeight());
        assertEquals(4, graph.getEdgesFrom(v3).get(0).getWeight());
    }
    
    @Test
    void testAddMultiDirectionalEdges() {
        // Add edges
        graph.addEdge(v1, v2, 5, true); // Bidirectional edge
        graph.addEdge(v1, v3, 7, true); // Bidirectional edge
        graph.addEdge(v2, v3, 3, true); // Bidirectional edge
        graph.addEdge(v3, v4, 4, true); // Bidirectional edge

        // Test vertex count
        assertEquals(4, graph.getVertexCount());

        // Test edge count (bidirectional)
        assertEquals(4, graph.getEdgeCount(true));

        // Test presence of vertices
        assertEquals(true, graph.hasVertex(v1));
        assertEquals(true, graph.hasVertex(v2));
        assertEquals(true, graph.hasVertex(v3));
        assertEquals(true, graph.hasVertex(v4));

        // Test presence of edges
        assertEquals(true, graph.hasEdge(v1, v2));
        assertEquals(true, graph.hasEdge(v2, v1)); // Bidirectional
        assertEquals(true, graph.hasEdge(v1, v3));
        assertEquals(true, graph.hasEdge(v3, v1)); // Bidirectional
        assertEquals(true, graph.hasEdge(v2, v3));
        assertEquals(true, graph.hasEdge(v3, v2)); // Bidirectional
        assertEquals(true, graph.hasEdge(v3, v4));
        assertEquals(true, graph.hasEdge(v4, v3)); // Bidirectional

        // Test weights of edges
        assertEquals(5, graph.getEdgesFrom(v1).get(0).getWeight());
        assertEquals(5, graph.getEdgesFrom(v2).get(0).getWeight()); // Bidirectional
        assertEquals(7, graph.getEdgesFrom(v1).get(1).getWeight());
        assertEquals(7, graph.getEdgesFrom(v3).get(0).getWeight()); // Bidirectional
        assertEquals(3, graph.getEdgesFrom(v2).get(1).getWeight());
        assertEquals(3, graph.getEdgesFrom(v3).get(1).getWeight()); // Bidirectional
        assertEquals(4, graph.getEdgesFrom(v3).get(2).getWeight());
        assertEquals(4, graph.getEdgesFrom(v4).get(0).getWeight()); // Bidirectional
    }


    @Test
    void testPrintGraph() {
        // Add vertices
        Vertex<String> v1 = new Vertex<>() {
            @Override
            public String getData() {
                return "A";
            }
        };
        Vertex<String> v2 = new Vertex<>() {
            @Override
            public String getData() {
                return "B";
            }
        };
        graph.addVertex(v1);
        graph.addVertex(v2);

        // Add edges
        graph.addEdge(v1, v2, 5, false);

        // Print graph
        System.out.println("Graph:");
        graph.printGraph();
    }


    

 
    
}

