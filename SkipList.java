import java.util.Random;

public class SkipList extends BaseList
{
	private SkipListNode head, tail;  // head and tail pointers
    private int h;                    // height (# of lanes)
    private int n;                    // # Items in list (slow lane)
    private Random r;                 // we’re about to discuss this
    boolean found = false;
    
    public SkipList() // constructor
    {
        head = new SkipListNode(); // create the two
        tail = new SkipListNode(); // sentinel nodes
        head.isSentinel = true;
        tail.isSentinel = true;
        head.right = tail; // link them to ...
        tail.left  = head; // ... each other
        r = new Random();  // create a RNG (to use later)
        n = 0;             // no entries yet (empty list)
        h = 1;             // no new levels yet (still single level)
    }
   
    
    public SkipListNode search(String k)
    {  // returns a slow-lane pointer to either the node containing key k
       // or the slow-lane node preceding where k WOULD be if in the list
       found = false;
       SkipListNode p = head;
       
       while (true)
       {
    	  keyCompare++;
          while (!p.right.isSentinel && p.right.key.compareTo(k) <= 0) // if the link to the right is not sentinal(infinity) and the word is is alphabetically before the linked word to the right
          {
        		  p = p.right; // set p to the linked node on the right of p
          }
          
          if (p.down == null) // if the down link of p is null, return p because we have reached the bottom layer
          {
        	  keyCompare++;
        	  if (p.getKey() != null && p.getKey().equals(k)) // if p exists in the bottom layer, return found
        	  {
        		  found = true;
        	  }
        	  return p;
          }
          p = p.down; // set p to the linked node on the right of p
       }
    }

    public void add(String word) // Adds a new element to the top of the stack
	{
    	SkipListNode current = search(word);
    	if (found == true) // if the current word is repeated, add the count of the word
    	{
    		current.value++; 
    	}
    	
    	else // if the current word is not repeated
    	{
    		// link the new word in between the the current node and the node to the right of the current node
    		SkipListNode between = new SkipListNode();
    		between.key = word;
    		between.value = 1;
    		
    		between.right = current.right;
    		current.right.left = between;
    		between.left = current;
    		current.right = between;
    		
    		refChanges++;
    		refChanges++;
    		refChanges++;
    		refChanges++;

        	r = new Random(); 
        	int coinFlip = r.nextInt(2); // flip the coin, if it's 0, it's heads
        	int counter = 1;
        
        	while (coinFlip == 0) // while the coin is heads
        	{
        		coinFlip = r.nextInt(2);
        		
        		
        		if (counter==h) // if the current height is equal to the maximum height of the skip list add a new layer
        		{
        			SkipListNode p = new SkipListNode();
            		SkipListNode q = new SkipListNode();
            		p.down = head; 
            		head.up = p;
            		
                	q.down = tail; 
                	tail.up = q;
                	
                	p.right = q;   
                	q.left = p;
                	
                	head = p;      
                	tail = q;
                	head.isSentinel = true;
                	tail.isSentinel = true;
                    h++;
                    refChanges++;
                    refChanges++;
                    refChanges++;
                    refChanges++;
                    refChanges++;
                    refChanges++;
                    refChanges++;
                    refChanges++;
                    
                    // add the node in between the other existing nodes in the new layer
                    SkipListNode middle = new SkipListNode(word);
                    middle.down = between;
            		between.up = middle;
            		
            		between = middle;
            		
            		
            		between.right = tail;
            		tail.left = between;
            		head.right = between;
            		between.left = head;
            		
            		counter++;
            		refChanges++;
            		refChanges++;
            		refChanges++;
            		refChanges++;
            		refChanges++;
            		refChanges++;
            		refChanges++;
        		}
        		
        		else // if there is a pre existing layer
        		{
        			// link the new node to the old node below it
        			SkipListNode middle = new SkipListNode(word);
        			
        			middle.down = between;
            		between.up = middle;
            		between = middle;
            		
        			while (current.up == null) // find the left node of the upper layer
            		{
            				current = current.left;
            		}
        			// set the new node in between the left node of the upper layer and the right node of the upper layer
        			current = current.up;
            		between.right = current.right;
            		between.left = current;
            		current.right.left = between;
            		current.right = between;
            		counter++;
            		refChanges++;
            		refChanges++;
            		refChanges++;
            		refChanges++;	
            		refChanges++;
            		refChanges++;
            		refChanges++;
            		refChanges++;
        		}

        		coinFlip = r.nextInt(2); // flip the coin again to see if it results in heads
        	}
    	}      
	}
   
    
    public int getDistinctWords()
	{
		// How many nodes are there on the list? Each corresponds to a unique word
		int count = 0; // Alternate coding:
		SkipListNode p = head; //
		
		while (p.down != null)
		{
			p = p.down;
		}
		
		while (!p.right.isSentinel) // for (LLNode p = list; p != null; p = p.getNext()) count++;
		{ // return count;
			count++; //
			p = p.getRight(); //
		} //
		return count; //
	}
	
	public int getTotalWords()
	{
		// How many TOTAL words? That's the sum of the counts in each node.
		//
		int count = 0;
		SkipListNode p = head;

		while (p.down != null)
		{
			p = p.down;
		}
	
		while (!p.right.isSentinel)
		{
			count += p.right.getValue();
			p = p.getRight();
		}
		return count;
	}
	
	public int getH()
	{
		return h;
	}
}




