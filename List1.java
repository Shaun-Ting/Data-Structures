// List1.java
//
// The unsorted linked list reads each word,and adds it to the top of the list
// This class contains location, previous, found, temp variable
// It has one constructor without a parameter
// This class has the methods: add(), find()

public class List1 extends BaseList 
{
		// This file creates a linked list using a stack
		// It creates nodes and linked them to each other
		
		public LLNode location;
		public LLNode previous;
		public boolean found;
		LLNode temp;
	
		List1() // Constructor without parameters
		{ 
			this.list = null;
		}
		
		public void add(String word) // Adds a new element to the top of the stack
		{
			find(word);
			if (found == true)
			{
				location.count++;
			}
			
			else 
			{
				LLNode temp = new LLNode();
				temp.info = word;
				temp.count = 1;
				temp.link = list;
				list = temp;
				refChanges++;
				refChanges++;
			}
		}
		
		protected void find(String target) // Finds the element and sets the previous, and location element
		{
			location = list;
			found = false;
			while (location != null)
			{
				keyCompare++;
				if (location.getInfo().equals(target))
				{
					found = true;
					return;
				}
				
				else
				{
					previous = location;
					location = location.getLink();
					
				}
			}
		}

		@Override
		public int getH() {
			// TODO Auto-generated method stub
			return 0;
		}
}


