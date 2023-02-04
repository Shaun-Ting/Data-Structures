
public class SkipListNode <T>
{
	SkipListNode <T> head;
    String key; // A comparable value we use to determine position
    int value;  // auxiliary data associated with the key

    public SkipListNode <T>  up, down, left, right; // all four links

    // Rather than looking for a VALUE to ID a sentinel node, we 
    // could just FLAG them as being sentinel nodes!
    public boolean isSentinel;

    public SkipListNode() // constructor: empty list, link set to null
	{
		up = null;
		down = null;
		left = null;
		right = null;
		this.key = null;
		isSentinel = false;
	}
	
	public SkipListNode(String k) // constructor: empty list, updates key, link set to null
	{
		this.key = k;
		up = null;
		down = null;
		left = null;
		right = null;
	}

	public SkipListNode<T> getHead() {
		return head;
	}

	public void setHead(SkipListNode<T> head) {
		this.head = head;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SkipListNode<T> getUp() {
		return up;
	}

	public void setUp(SkipListNode<T> up) {
		this.up = up;
	}

	public SkipListNode<T> getDown() {
		return down;
	}

	public void setDown(SkipListNode<T> down) {
		this.down = down;
	}

	public SkipListNode<T> getLeft() {
		return left;
	}

	public void setLeft(SkipListNode<T> left) {
		this.left = left;
	}

	public SkipListNode<T> getRight() {
		return right;
	}

	public void setRight(SkipListNode<T> right) {
		this.right = right;
	}

	public boolean isSentinel() {
		return isSentinel;
	}

	public void setSentinel(boolean isSentinel) {
		this.isSentinel = isSentinel;
	}
	
	

	
	
}
