package ie.ucd.csnl.comp47500.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.ucd.csnl.comp47500.model.Edge;
import ie.ucd.csnl.comp47500.model.Graph;
import ie.ucd.csnl.comp47500.model.Vertex;

/**
 * Implements the GraphInterface using an adjacency list to manage vertices and
 * edges. This class provides a concrete implementation of a graph that can
 * handle any type of data in vertices.
 *
 * @param <T> the type of the vertex data
 */
public class GraphImpl<T> implements Graph<T> {
	private Map<Vertex<T>, List<Edge<T>>> adjacencyList;

	/**
	 * Constructs a new, empty GraphImpl.
	 */
	public GraphImpl() {
		this.adjacencyList = new HashMap<>();
	}

	@Override
	public void addVertex(Vertex<T> vertex) {
		adjacencyList.putIfAbsent(vertex, new ArrayList<>());
	}

	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to, int weight, boolean bidirectional) {
		adjacencyList.putIfAbsent(from, new ArrayList<>());
		adjacencyList.putIfAbsent(to, new ArrayList<>());
		adjacencyList.get(from).add(new EdgeImpl<>(from, to, weight));
		if (bidirectional) {
			adjacencyList.get(to).add(new EdgeImpl<>(to, from, weight));
		}
	}

	@Override
	public List<Edge<T>> getEdgesFrom(Vertex<T> vertex) {
		return adjacencyList.getOrDefault(vertex, new ArrayList<>());
	}

	@Override
	public boolean hasVertex(Vertex<T> vertex) {
		return adjacencyList.containsKey(vertex);
	}

	@Override
	public boolean hasEdge(Vertex<T> from, Vertex<T> to) {
		if (!adjacencyList.containsKey(from)) {
			return false;
		}
		return adjacencyList.get(from).stream().anyMatch(edge -> edge.getTo().equals(to));
	}

	@Override
	public int getVertexCount() {
		return adjacencyList.keySet().size();
	}

	@Override
	public int getEdgeCount(boolean bidirectional) {
		int count = adjacencyList.values().stream().mapToInt(List::size).sum();
		return bidirectional ? count / 2 : count;
	}

	@Override
	public void printGraph() {
		for (Map.Entry<Vertex<T>, List<Edge<T>>> entry : adjacencyList.entrySet()) {
			System.out.print(entry.getKey() + " -> ");
			entry.getValue().forEach(edge -> System.out.print(edge + ", "));
			System.out.println();
		}
	}
	
	protected Map<Vertex<T>, List<Edge<T>>> getAdjacencyList() {
        return adjacencyList;
    }
}
