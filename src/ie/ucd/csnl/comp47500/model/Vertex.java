package ie.ucd.csnl.comp47500.model;

/**
 * Represents a vertex in a graph with data of generic type T.
 * 
 * @param <T> the type of data stored in the vertex
 */
public interface Vertex<T> {

	/**
	 * Returns the data stored in this vertex.
	 * 
	 * @return the data stored in the vertex
	 */
	public T getData();

	/**
	 * Returns a string representation of this vertex.
	 * 
	 * @return a string representation of the vertex
	 */

	public String toString();
}
