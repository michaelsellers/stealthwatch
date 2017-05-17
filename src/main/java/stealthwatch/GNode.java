package stealthwatch;

public interface GNode {
	String getName();
    GNode[] getChildren(); // why not a collection?
}
