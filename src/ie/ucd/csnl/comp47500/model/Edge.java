package ie.ucd.csnl.comp47500.model;

/**
 * Represents an edge in a graph, connecting two vertices.
 * 
 * @param <T> the type of the vertex data
 */
public interface Edge<T> {

	/**
	 * Returns the starting vertex of this edge.
	 * 
	 * @return the starting vertex
	 */
	public Vertex<T> getFrom();

	/**
	 * Returns the ending vertex of this edge.
	 * 
	 * @return the ending vertex
	 */
	public Vertex<T> getTo();

	/**
	 * Returns the weight of this edge.
	 * 
	 * @return the weight
	 */
	public int getWeight();

	/**
	 * Returns a string representation of the edge.
	 * 
	 * @return a string representation of the edge
	 */

	public String toString();
}
