package com.exp;

public class QuickFind {

	private int id[];

	public QuickFind(int nodeNo) {
		id = new int[nodeNo];

		for (int i = 0; i < nodeNo; i++) {
			id[i] = i;
		}
	}

	public int root(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public boolean find(int p, int q) {
		return id[p] == id[q];
	}

	public void unite(int p, int q) {
		int p1 = id[p];
		int p2 = id[q];

		for (int i = 0; i < id.length; i++) {
			if (id[i] == p2) {
				id[i] = p1;
			}
		}
	}
}
