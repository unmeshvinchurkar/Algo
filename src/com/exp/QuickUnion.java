package com.exp;

public class QuickUnion {
	private int id[];

	public QuickUnion(int nodeNo) {
		id = new int[nodeNo];
		for (int i = 0; i < nodeNo; i++) {
			id[i] = i;
		}
	}

	public int root(int p) {
		while (p != id[p]) {
			// optimized
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	public boolean find(int p, int q) {
		int p1 = root(p);
		int p2 = root(q);
		return p1 == p2;
	}

	public void unite(int p, int q) {
		int p1 = id[p];
		int p2 = id[q];
		id[p2] = p1;
	}
}
