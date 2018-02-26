package com.learning.basicjava.graph;

import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.junit.Ignore;
import org.junit.Test;

public class MyGraphTest {

	@Test
	@Ignore
	public void test_BFS() {
		//given
		MyGraph graph = new MyGraph (5);
		
		graph.buildEdge(0, 1);
		graph.buildEdge(0, 2);
		graph.buildEdge(1, 2);
		graph.buildEdge(0, 1);
		graph.buildEdge(2, 0);
		graph.buildEdge(2, 3);
		graph.buildEdge(3, 3);
		
		//when
		List<Integer> bfsList = graph.BFS(1);
		
		//then
		BDDAssertions.then(bfsList).containsExactly(1, 2, 0, 3);
	}
	
	@Test
	public void test_DFS() {
		//given
		MyGraph graph = new MyGraph (5);
		
		graph.buildEdge(0, 1);
		graph.buildEdge(0, 2);
		graph.buildEdge(1, 2);
		graph.buildEdge(0, 1);
		graph.buildEdge(2, 0);
		graph.buildEdge(2, 3);
		graph.buildEdge(3, 3);
		
		//when
		List<Integer> dfsList = graph.DFS(2);
		
		//then
		BDDAssertions.then(dfsList).containsExactly(2, 0, 1, 3);
	}

}
