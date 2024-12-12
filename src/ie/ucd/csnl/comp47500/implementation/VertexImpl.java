package ie.ucd.csnl.comp47500.implementation;

import java.util.Objects;

import ie.ucd.csnl.comp47500.model.Vertex;

/**
 * Represents a vertex in a graph with data of generic type T.
 * 
 * @param <T> the type of data stored in the vertex
 */
public class VertexImpl<T> implements Vertex<T> {
    private T data;  // Data element stored in this vertex

    /**
     * Constructs a new Vertex with the specified data.
     * 
     * @param data the data to be stored in the vertex
     */
    public VertexImpl(T data) {
        this.data = data;
    }

    /**
     * Returns the data stored in this vertex.
     * 
     * @return the data stored in the vertex
     */
    public T getData() {
        return data;
    }

    /**
     * Checks if this vertex is equal to another object.
     * 
     * @param o the object to compare with
     * @return true if the objects are the same or their data elements are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VertexImpl)) return false;
        VertexImpl<?> vertex = (VertexImpl<?>) o;
        return Objects.equals(data, vertex.data);
    }

    /**
     * Returns the hash code of this vertex based on its data.
     * 
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    /**
     * Returns a string representation of this vertex.
     * 
     * @return a string representation of the vertex
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
