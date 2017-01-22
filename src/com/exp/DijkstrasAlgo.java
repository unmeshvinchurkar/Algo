package com.exp;

import java.util.List;

public class DijkstrasAlgo {

	private Graph graph = null;
	private Integer[] parent = null;
	private Integer[] cost = null;
	private boolean[] processed = null;

	public DijkstrasAlgo(Graph graph) {
		this.graph = graph;
		parent = new Integer[graph.getTotalVertex()];
		cost = new Integer[graph.getTotalVertex()];
		processed = new boolean[graph.getTotalVertex()];

		for (int i = 0; i < cost.length; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
	}

	public void run(int src) {

		cost[src] = 0;
		int v = src;

		while (v != -1) {

			List<Integer> neigbs = graph.getNeighbours(v);

			for (Integer vertex : neigbs) {
				if (cost[vertex] > cost[v] + graph.getWeight(v, vertex)) {
					cost[vertex] = cost[v] + graph.getWeight(v, vertex);
					parent[vertex] = v;
				}
			}
			processed[v] = true;
			v = _getNextNode();
		}
	}

	private int _getNextNode() {
		int minvertex = -1;
		Integer minCost = Integer.MAX_VALUE;

		for (int i = 0; i < cost.length; i++) {
			if (!processed[i]) {
				if (minCost > cost[i]) {
					minvertex = i;
					minCost = cost[i];
				}
			}
		}
		return minvertex;
	}
}
