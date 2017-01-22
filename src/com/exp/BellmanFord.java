package com.exp;

import java.util.List;

public class BellmanFord {

	private Graph graph = null;

	private Integer[] parent = null;
	private Integer[] cost = null;

	public BellmanFord(Graph graph) {

		this.graph = graph;
		parent = new Integer[graph.getTotalVertex()];
		cost = new Integer[graph.getTotalVertex()];

		for (int i = 0; i < cost.length; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
	}

	public void run() {

		TopologicalSort sort = new TopologicalSort(graph);
		sort.run();
		List<Integer> nodes = sort.getSortedArray();

		cost[nodes.get(0)] = 0;
		parent[nodes.get(0)] = nodes.get(0);

		for (int i = 0; i < graph.getTotalVertex() - 1; i++) {

			for (int src : nodes) {
				List<Integer> nList = graph.getNeighbours(src);
				for (int dest : nList) {
					if (cost[dest] > cost[src] + graph.getWeight(src, dest)) {
						cost[dest] = cost[src] + graph.getWeight(src, dest);
						parent[dest] = src;
					}
				}
			}
		}

		for (int src : nodes) {
			List<Integer> nList = graph.getNeighbours(src);
			for (int dest : nList) {
				if (cost[dest] > cost[src] + graph.getWeight(src, dest)) {
					throw new RuntimeException(
							"There are negative cycles in a graph");
				}
			}
		}

	}
}
