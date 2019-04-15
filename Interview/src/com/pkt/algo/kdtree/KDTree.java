package com.pkt.algo.kdtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KDTree<T extends KDNodeComparator<T>> {
	private KDNode<T> root;

	public KDTree(List<T> items) {
		root = createKDTree(items, 0, 3);
	}

	public T findNearest(T search) {
		return findNearest(root, search, 0).location;
	}

	// Only ever goes to log2(items.length) depth so lack of tail recursion is a
	// non-issue
	@SuppressWarnings("unchecked")
	private KDNode<T> createKDTree(List<T> items, int depth, int dim) {
		if (items.isEmpty()) {
			return null;
		}
		Collections.sort(items, items.get(0).getComparator(depth % dim));
		int currentIndex = items.size() / 2;
		return new KDNode<T>(createKDTree(new ArrayList<T>(items.subList(0, currentIndex)), depth + 1, dim),
				createKDTree(new ArrayList<T>(items.subList(currentIndex + 1, items.size())), depth + 1, dim),
				items.get(currentIndex));
	}

	@SuppressWarnings("unchecked")
	private KDNode<T> findNearest(KDNode<T> currentNode, T search, int depth) {

		int direction = search.getComparator(depth % 3).compare(search, currentNode.location);
		KDNode<T> next = (direction < 0) ? currentNode.left : currentNode.right;
		KDNode<T> other = (direction < 0) ? currentNode.right : currentNode.left;
		KDNode<T> best = (next == null) ? currentNode : findNearest(next, search, depth + 1); // Go to a leaf
		if (currentNode.location.squaredDistance(search) < best.location.squaredDistance(search)) {
			best = currentNode; // Set best as required
		}
		if (other != null) {
			if (currentNode.location.axisSquaredDistance(search, depth % 3) < best.location.squaredDistance(search)) {
				KDNode<T> possibleBest = findNearest(other, search, depth + 1);
				if (possibleBest.location.squaredDistance(search) < best.location.squaredDistance(search)) {
					best = possibleBest;
				}
			}
		}
		return best; // Work back up
	}
}
