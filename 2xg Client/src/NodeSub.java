// Decompiler options: packimports(3) 
// Source File Name:   NodeSub.java

public class NodeSub extends Node {

	public NodeSub prevNodeSub;

	NodeSub nextNodeSub;

	public static int anInt1305;

	public NodeSub() {
	}

	public final void unlinkSub() {
		if (nextNodeSub != null) {
			nextNodeSub.prevNodeSub = prevNodeSub;
			prevNodeSub.nextNodeSub = nextNodeSub;
			prevNodeSub = null;
			nextNodeSub = null;
		}
	}
}
