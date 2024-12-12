package ie.ucd.csnl.comp47500.model;

import java.util.List;

/**
 * Interface for a generic graph.
 * This interface defines the standard operations to be supported by any graph implementation.
 *
 * @param <T> the type of the data stored in the vertices of the graph
 */
public interface Graph<T> {
    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to be added to the graph
     */
    void addVertex(Vertex<T> vertex);

    /**
     * Adds an edge between two vertices in the graph.
     *
     * @param from the starting vertex of the edge
     * @param to the ending vertex of the edge
     * @param weight the weight of the edge
     * @param bidirectional true if the edge should be added in both directions
     */
    void addEdge(Vertex<T> from, Vertex<T> to, int weight, boolean bidirectional);

    /**
     * Retrieves a list of edges originating from a specified vertex.
     *
     * @param vertex the vertex from which edges are to be retrieved
     * @return a list of edges starting from the specified vertex
     */
    List<Edge<T>> getEdgesFrom(Vertex<T> vertex);

    /**
     * Checks if a vertex exists in the graph.
     *
     * @param vertex the vertex to check for in the graph
     * @return true if the vertex exists, false otherwise
     */
    boolean hasVertex(Vertex<T> vertex);

    /**
     * Checks if an edge exists between two vertices in the graph.
     *
     * @param from the starting vertex of the edge
     * @param to the ending vertex of the edge
     * @return true if the edge exists, false otherwise
     */
    boolean hasEdge(Vertex<T> from, Vertex<T> to);

    /**
     * Returns the number of vertices in the graph.
     *
     * @return the count of vertices in the graph
     */
    int getVertexCount();

    /**
     * Returns the number of edges in the graph.
     * If the graph is bidirectional, the count is adjusted accordingly.
     *
     * @param bidirectional specifies if the edge count should consider the graph as bidirectional
     * @return the count of edges in the graph
     */
    int getEdgeCount(boolean bidirectional);

    /**
     * Prints the adjacency list of the graph to the console.
     */
    void printGraph();
}

