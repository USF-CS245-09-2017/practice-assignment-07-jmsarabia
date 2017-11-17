

public class Hashtable<Key,Value> {

	private HashNode<Key, Value>[] arr;
	private int size;
	
	
	//Constructor: arr initialized to 314527 because 2027 < 314513 < 314527 (per assignment) and it is prime
	public Hashtable()
	{
		//TODO: why giving this awkward error?
		arr = new HashNode[314513];
		size = 0;	
	}
	
	//hashCode: takes in key, returns int for hash position;
	private int hashCode(String key)
	{
		//absolute value because hashCode returns ()
		return Math.abs(key.hashCode()) % arr.length-1;
		//personally written arbitrary hash following research and teacher's constraints
		/*int hash = 13;
		for(int i = 0; i < key.length(); i++)
		{
			hash =( hash + 31 * Character.getNumericValue(key.charAt(2)) ) % arr.length;
		}
		return hash;*/
	}
	
	//containsKey: returns true if key is in array
	public boolean containsKey(String searchKey)
	{
		//current becomes the head of the linked list at the hashed position
		HashNode<Key, Value> current = arr[ hashCode(searchKey) ];
		//check there is a node inside arr at the position; makes worst case O(n)
		if(current != null)
		{
			//loop through linked list and check 
			while(current.next != null)
			{
				if(current.key.equals(searchKey))
				{
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}
	
	//remove: returns teh value associated with the search key, but throws exception if not found (per assignment)
	public String remove(String key) throws Exception 
	{
		int pos = hashCode(key);
		HashNode<Key, Value> current = arr[pos];
		if(current == null)
		{
			throw new Exception(); //per assignment details
		}
		if(current.key.equals(key))	//check if it is the first/head of linked list
		{
			size--;
			return current.value;
		}
		//Move on to the rest of the bucket
		HashNode<Key, Value> prev = current;
		current = current.next;
		while(current != null)
		{
			
			if(current.key.equals(key))
			{
				size--;
				return current.value;
			}
			prev = current;
			current = current.next;
		}
		//reaches end of bucket, and it is not in the bucket at the hash position of the key
		System.out.println("Not in the bucket at the key position ");
		throw new Exception();
	}
	
	//put: takes in key,value pair, makes a hash node, then puts in the appropriate bucket
	public void put(String key, String value)
	{	
		/* Depending on application for similar keys: remove then add (commented out), or find then change
		//If the key,value hash node already exists, remove, then add a new hash node to bucket (puts it in front); per prompt
		if(containsKey(key) && get(key).equals(value))
		{
			try {
				remove(key);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}*/
		int pos = hashCode(key);
		//loop through bucket to find if a node has the equal key, then change the node's value
		HashNode current = arr[pos];
		if(current != null)
		{
			//loop through linked list and check 
			while(current.next != null)
			{
				if(current.key.equals(key))
				{
					current.value = value;
				}
				current = current.next;
			}
		}
		//if key is not in the bucket, make a hash node and add to the head of the link list in the bucket
		HashNode head = arr[pos];
		HashNode<Key,Value> start = new HashNode<Key,Value>(key,value);
		start.next = head;
		arr[pos] = start;
		size++;
	}
	
	//get: takes in key, returns value associated with key if found
	public String get(String key)
	{
		int pos = hashCode(key);
		HashNode start = arr[pos];
		while(start != null)
		{
			if(key.equals(start.key))
			{
				return start.value;
			}
			start = start.next;
		}
		return null;
	}
	
	class HashNode <Key, Value>{
		
		String key;
		String value;
		HashNode next;
		
		//Constructor
		HashNode(String k, String v)
		{
			key = k;
			value = v;
			next = null;
		}
	}
	
	
	
	
	
}
