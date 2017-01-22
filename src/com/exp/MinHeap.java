package com.exp;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	private List<Integer> list = new ArrayList<Integer>();

	public MinHeap() {
	}

	public void add(Integer no) {
		int index = list.size();
		list.add(no);
		moveUp(index);
	}

	public Integer getRoot() {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public Integer remove() {

		Integer root = list.get(0);
		int index = 0;
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		moveDown(index);

		return root;
	}

	public void moveUp(int index) {
		int pIndex = index / 2;

		while (list.get(pIndex) > list.get(index)) {
			Integer tmp = list.get(pIndex);
			int no = list.get(index);
			list.set(pIndex, no);
			list.set(index, tmp);
			index = pIndex;
			pIndex = index / 2;
		}
	}

	public void moveDown(int index) {
		Integer childIndex = 0;

		while (true) {

			int leftI = 2 * index + 1;
			int rightI = 2 * index + 2;
			int no = list.get(index);

			Integer lChild = leftI < list.size() ? list.get(leftI) : null;
			Integer rChild = rightI < list.size() ? list.get(rightI) : null;

			if (lChild == null) {
				break;
			} else if (rChild == null) {
				if (no > lChild) {
					childIndex = leftI;
					_swap(childIndex, index);
					index = childIndex;
				} else {
					break;
				}
			} else if (lChild != null && rChild != null) {

				if (no <= lChild && no <= rChild) {
					break;
				} else if (no >= lChild && no >= rChild) {
					if (lChild > rChild) {
						childIndex = leftI;
					} else {
						childIndex = rightI;
					}
				} else if (no < lChild && no >= rChild) {
					childIndex = rightI;
				} else if (no >= lChild && no < rChild) {
					childIndex = leftI;
				}
				_swap(childIndex, index);
				index = childIndex;
			}
		}
	}

	private void _swap(int index1, int index2) {
		int tmp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, tmp);
	}
}
