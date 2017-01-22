package com.exp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph implements Cloneable {

	private int vertexN = -1;
	private Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();
	private Map<String, Integer> weightMap = new HashMap<String, Integer>();

	public Graph(int vertexNo) {
		vertexN = vertexNo;
		for (int i = 0; i < vertexN; i++) {
			edgeMap.put(i, new ArrayList<Integer>());
		}
	}

	public Object clone() {

		Graph cloned = (Graph) this.clone();

		Map<Integer, List<Integer>> clonedEdgeMap = new HashMap<Integer, List<Integer>>();

		for (Entry<Integer, List<Integer>> entry : edgeMap.entrySet()) {

			clonedEdgeMap.put(entry.getKey(),
					(List<Integer>) ((ArrayList<Integer>) entry.getValue())
							.clone());
		}
		cloned.edgeMap = clonedEdgeMap;
		return this;
	}

	public int getTotalVertex() {
		return vertexN;
	}

	public List<Integer> getNeighbours(int v) {
		return edgeMap.get(v);
	}

	public void addEdge(int src, int dest, int weight) {
		edgeMap.get(src).add(dest);
		setWeight(src, dest, weight);
	}

	public void removeEdge(int src, int dest) {
		weightMap.remove(String.valueOf(src) + "_" + String.valueOf(dest));
		edgeMap.get(src).remove(dest);
	}

	public void removeVertex(int v) {
		edgeMap.remove(v);
		Set<String> keySet = weightMap.keySet();

		for (String key : keySet) {
			if (key.startsWith(v + "_")) {
				weightMap.remove(key);
			}
		}
	}

	public int getInDegree(int v) {
		int inDegree = 0;
		Collection<List<Integer>> coll = edgeMap.values();

		for (List<Integer> dests : coll) {
			if (dests.contains(v)) {
				inDegree++;
			}
		}
		return inDegree;
	}

	public int getOutDegree(int v) {
		return edgeMap.get(v).size();
	}

	public boolean hasEdge(int src, int dest) {
		return edgeMap.get(src).contains(dest);
	}

	public int getWeight(int src, int dest) {
		return weightMap.get(String.valueOf(src) + "_" + String.valueOf(dest));
	}

	public void setWeight(int src, int dest, int weight) {
		weightMap.put(String.valueOf(src) + "_" + String.valueOf(dest), weight);
	}

}
