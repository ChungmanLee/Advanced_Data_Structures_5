package ie.ucd.csnl.comp47500.implementation;

import ie.ucd.csnl.comp47500.model.Edge;
import ie.ucd.csnl.comp47500.model.Vertex;

/**
 * Represents an edge in a graph, connecting two vertices.
 * 
 * @param <T> the type of the vertex data
 */
public class EdgeImpl<T> implements Edge<T> {
	private Vertex<T> from; // The starting vertex of the edge
	private Vertex<T> to; // The ending vertex of the edge
	private int weight = 1; // The weight of the edge

	/**
	 * Constructs a new Edge from one vertex to another with a specified weight.
	 * 
	 * @param from   the starting vertex
	 * @param to     the ending vertex
	 * @param weight the weight of the edge
	 */
	public EdgeImpl(Vertex<T> from, Vertex<T> to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@SuppressWarnings("unchecked")
	public EdgeImpl(UserVertex from, UserVertex to, int weight) {
		this.from = (Vertex<T>) from;
        this.to = (Vertex<T>) to;
        this.weight = weight;
	}

	/**
	 * Returns the starting vertex of this edge.
	 * 
	 * @return the starting vertex
	 */
	
	
	public Vertex<T> getFrom() {
		return from;
	}

	/**
	 * Returns the ending vertex of this edge.
	 * 
	 * @return the ending vertex
	 */
	public Vertex<T> getTo() {
		return to;
	}

	/**
	 * Returns the weight of this edge.
	 * 
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Returns a string representation of the edge.
	 * 
	 * @return a string representation of the edge
	 */
	@Override
	public String toString() {
		return "Edge{" + from + " -> " + to + ", weight=" + weight + '}';
	}
}
