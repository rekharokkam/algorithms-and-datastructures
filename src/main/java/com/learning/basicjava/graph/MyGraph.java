package com.learning.basicjava.graph;

import java.util.LinkedList;
import java.util.List;

public class MyGraph {
	private int vertices;
	
	private List<Integer>[] adjacentList; //Array of linked list. Each list represents the edges of a Vertex
	
	public MyGraph (int vertices){
		this.vertices = vertices;
		adjacentList = new LinkedList[vertices];
		
		//Initialize the linked list of each vertex that stores the edges for each vertex
		for (int i = 0; i < vertices; i ++) {
			adjacentList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge (int sourceVertex, int destinationVertex) {
		//get the list of sourceVertex
		adjacentList[sourceVertex].add(destinationVertex);
	}
}
