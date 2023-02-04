// List3.java
//
// The heavy-weight adjust linked list moves the frequent words to the top every time a repeated word is read. 
// The goal for this is to minimize search time, by predicting that a repeated word would appear more frequently. 
// This class contains location, previous, found, temp variable
// It has one constructor without a parameter
// This class has the methods: add(), find()

public class List3 extends BaseList 
{
	// This file creates a linked list using a stack
	// It creates nodes and linked them to each other
		public LLNode location;
		public LLNode previous;
		public boolean found;
		LLNode temp;
		
		List3() // Constructor without parameters
		{ 
			this.list = null; 
		}

		public void add(String word) // Adds a new element to the top of the stack
		{
			find(word);
			if (found == true) // if the word is a repeated word
			{
				location.count++;
				
				if (location != list) // if the word is not at the top of the list, move the word one step up
				{
					previous.link = location.link;
					location.link = list;
					list = location;
					refChanges++;
					refChanges++;
					refChanges++;
				}
			}
			
			else 
			{
				LLNode temp = new LLNode();
				temp.info = word;
				temp.link = list;
				temp.count = 1;
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
				if (location.getInfo().equals(target)) // if the word is repeated, set found to true
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



