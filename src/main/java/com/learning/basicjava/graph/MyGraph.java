package com.learning.basicjava.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyGraph {
	private int vertices; //represents the vertices in the graph
	private List<Integer> vertexEdges[]; //represents the edges for each Vertex
	
	public MyGraph (int vertices) {
		this.vertices = vertices;
		vertexEdges = new LinkedList[vertices];
		
		//initialize each linkedList
		for (int i = 0; i < vertices; i ++) {
			vertexEdges[i] = new LinkedList<>();
		}
	}
	
	public void buildEdge (int sourceVertex, int destinationVertex) {
		List<Integer> vertexEdge = vertexEdges[sourceVertex];
		vertexEdge.add(destinationVertex);
	}
	
	public List<Integer> BFS (int sourceVertex) {
		//store the already visited Vertices so they are not duplicated
		boolean visited[] = new boolean [vertices];
		
		//priorityQueue for calculating the BFS
		Queue<Integer> edgeStorage = new PriorityQueue<>();
		
		//List for storing the possibleEdges
		List<Integer> possibleEdges = new ArrayList<>();
		
		edgeStorage.offer(sourceVertex);
		visited[sourceVertex] = true;
		possibleEdges.add(sourceVertex);
		
		while (!edgeStorage.isEmpty()) {
			int queueVertex = edgeStorage.poll();
			List<Integer> allVertexEdges = vertexEdges[queueVertex];
			ListIterator<Integer> it = allVertexEdges.listIterator();
			
			while (it.hasNext()) {
				int linkedVertex = it.next();
				
				boolean isVertexVisited = visited[linkedVertex];
				if (!isVertexVisited) {
					visited[linkedVertex] = true;
					edgeStorage.offer(linkedVertex);
					possibleEdges.add(linkedVertex);
				}
			}
		}
		
		return possibleEdges;
	}
	
	public List<Integer> DFS (int sourceVertex) {
		//store the already visited Vertices so they are not duplicated
		boolean visited[] = new boolean [vertices];
		
		//List for storing the possibleEdges
		List<Integer> possibleEdges = new ArrayList<>();
		
		DFS_calculator (sourceVertex, visited, possibleEdges);
		return possibleEdges;
	}
	
	private void DFS_calculator (int vertex, boolean[] visited, List<Integer> result) {
		
		boolean isVisited = visited[vertex];
		if (! isVisited) {
			result.add(vertex);
			visited[vertex] = true;
			ListIterator<Integer> establishedVertexEdges = vertexEdges[vertex].listIterator();
			while (establishedVertexEdges.hasNext()) {
				DFS_calculator(establishedVertexEdges.next(), visited, result);
			}
		}
	}
}
