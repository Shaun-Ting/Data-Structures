// List2a.java
//
// The sorted linked list does the same but searches the list for where the word must be placed alphabetically in the list. 
// Once the “correct” place is found, the word is added to that specific place
// This class contains counter, location, previous, found, middle, bottom, temp variable
// It has one constructor without a parameter
// This class has the methods: add(), find()

public class List2a extends BaseList 
{
	// This file creates a linked list using a stack
	// It creates nodes and linked them to each other
		public int counter = 0;
		public LLNode location;
		public LLNode previous;
		public boolean found;
		public boolean middle;
		public boolean bottom;
		public LLNode last;
		
		List2a() // Constructor without parameters
		{ 
			this.list = null; 
		}

		public void add(String word) // Adds a new element to the top of the stack
		{
			find(word);
			LLNode temp = new LLNode(word);
			
			if (found == true) // if the word is a repeated word, add one to the count
			{
				location.count++; 
			}
			else if (location == list) // if the location is at the start of the list, add the word onto the top of the list
			{
				temp.info = word;
				temp.count = 1;
				temp.link = list;
				list = temp;
				refChanges++;
				refChanges++;
			}
			
			else
			{
				if (previous == null) // if the previous location is null
				{
					temp.info = word;
					temp.count = 1;
					temp.link = list;
					list = temp;
					refChanges++;
					refChanges++;
				}
				
				else if (previous.link == null) // if the word is bigger than all of the words in the list, set the previous link to the word
				{
					temp.info = word;
					previous.link = temp;
					temp.count = 1;
					refChanges++;
				}
				else // if the word is in the middle of the list, add it in between of the two words
				{
					temp.count = 1;
					temp.setLink(location);
					previous.setLink(temp);		
					refChanges++;
					refChanges++;
				}
				last = temp;
			}
			
		}
		
		protected void find(String target) // Finds the element and sets the previous, and location element
		{
			location = list;
			found = false;
			middle = false;
			bottom = false;
			counter = 0;
			
			if (last == null)
			{
				
			}
			else if (target.compareTo(last.getInfo().toString()) > 0) // if the new word is alphabetically bigger that the last word added
			{
				keyCompare++;
				location = last;
			}
			
			while (location != null) 
			{
				keyCompare++;
				counter++;

				if (location.getInfo().equals(target)) // if the word is repeated, set found to true
				{
					found = true;
					return;
				}
				
				
				else if (target.compareTo(location.getInfo().toString()) < 0) // if the word is smaller, set middle to true
				{ 
					keyCompare++;
					middle = true;
					return;
				} 
				
				else if (location==null) // if the word is null
				{
					keyCompare++;
					bottom = true;
					return;
				}
				
				else
				{
					keyCompare++;
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





