package com.exp;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {
	private Graph graph = null;
	private List<Integer> sortedArry = new ArrayList<Integer>();

	public TopologicalSort(Graph graph) {
		this.graph = (Graph) graph.clone();
	}

	public List<Integer> getSortedArray() {
		return sortedArry;
	}

	public void run() {
		while (graph.getTotalVertex() != 0) {
			int src = _getSrcNode();
			sortedArry.add(src);
			graph.removeVertex(src);
		}
	}

	private int _getSrcNode() {
		int vNo = graph.getTotalVertex();

		for (int i = 0; i < vNo; i++) {
			if (graph.getInDegree(i) == 0) {
				return i;
			}
		}
		return -1;
	}
}
