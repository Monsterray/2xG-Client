// Decompiler options: packimports(3) 
// Source File Name:   NodeCache.java

import sign.signlink;

final class NodeCache {

	private final int size;

	private final Node cache[];

	public NodeCache() {
		int i = 1024;
		size = i;
		cache = new Node[i];
		for (int k = 0; k < i; k++) {
			Node node = cache[k] = new Node();
			node.prev = node;
			node.next = node;
		}

	}

	public Node findNodeByID(long l) {
		Node node = cache[(int) (l & (size - 1))];
		for (Node node_1 = node.prev; node_1 != node; node_1 = node_1.prev) {
			if (node_1.id == l) {
				return node_1;
			}
		}

		return null;
	}

	public void removeFromCache(Node node, long l) {
		try {
			if (node.next != null) {
				node.unlink();
			}
			Node node_1 = cache[(int) (l & (size - 1))];
			node.next = node_1.next;
			node.prev = node_1;
			node.next.prev = node;
			node.prev.next = node;
			node.id = l;
			return;
		} catch (RuntimeException runtimeexception) {
			signlink.reporterror((new StringBuilder()).append("91499, ")
					.append(node).append(", ").append(l).append(", ").append(7)
					.append(", ").append(runtimeexception.toString())
					.toString());
		}
		throw new RuntimeException();
	}
}
