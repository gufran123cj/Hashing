package hmw1;


public class HashTable {
		Node[] table;
		int size ;
	 
	    /* Constructor */
		HashTable(int tableSize)
	    {
	        table = new Node[ nextPrime(tableSize)-1 ];
	        size = 0;
	    }
		public Node search(String string)
        {
			int pos = myhash(string);// global depth yerini tutuyor 
			Node temp_node = table[pos]; 
			if(temp_node != null)while(temp_node != null){
				if(temp_node.getData().equals(string)){
					return temp_node;
				}
				temp_node = temp_node.getLink();
			}
			return new Node("");
        }
	    /* Function to check if hash table is empty */
	    public boolean isEmpty()
	    {
	        return size == 0;
	    }

	    /* Function to clear hash table */
	    public void makeEmpty()
	    {
	        int l = (int)Math.pow(2, main.globaldepth);
	        table = new Node[l];
	        size = 0;
	    }
	    /* Function to get size */
	    public int getSize()
	    {
	        return size;
	    }
		public void resize(){
			main.globaldepth++;
			makeEmpty();
			for (String string : main.words) {
				insert(string);
			}
			
		}	   
	    public void insert(String string)
	    {
	        
	        int pos = myhash(string); 
			Node first_node = table[pos];       
	        Node new_node = new Node(string);  
			String new_node_string = (String)new_node.getData(); 
			Node search_result = search(new_node_string);
			if(first_node != null)if(first_node.size()>main.bucketsize){
				resize();
			}
			if(search_result.getData().equals(new_node_string)){
				search_result.increase_repetition();
				return;
			}              
	        if (table[pos] == null)
	            table[pos] = new_node;            
	        else
	        {
	            new_node.setLink(table[pos]);;
	            table[pos] = new_node;
	        }
			size++;    
	    }

		static private String control(String binary){
			String first_binary = binary;
			if(binary.length()< main.globaldepth){
				binary = "";
				for (int i = 0; i < main.globaldepth-first_binary.length(); i++) {
					binary+= "0"; 
				}
				binary += first_binary;
			}
			return binary;
		}
	    static public long get_key(String string){
			long key = 0;
	        for (int i = 0; i < string.length(); i++) {
				key += (string.charAt(i) - 96)* Math.pow(2, i); ;
			}
			return key;
		}
	    /* Function myhash */
	    static private int myhash(String string)
	    {
			long key = get_key(string);
			String binary = Long.toBinaryString(key);
			binary = control(binary);
			try {
				binary = binary.substring(binary.length()- main.globaldepth);
			} catch (Exception e) {
				System.out.println();
			}
			
			return Integer.parseInt(binary,2);
	    }
	    private static int nextPrime( int n )
	    {
	        if (n % 2 == 0)
	            n++;
	        for ( ; !isPrime( n ); n += 2);
	 
	        return n;
	    }
	    private static boolean isPrime( int n )
	    {
	        if (n == 2 || n == 3)
	            return true;
	        if (n == 1 || n % 2 == 0)
	            return false;
	        for (int i = 3; i * i <= n; i += 2)
	            if (n % i == 0)
	                return false;
	        return true;
	    }
	    public void printHashTable ()
	    {
	        System.out.println();
	        for (int i = 0; i < table.length; i++)
	        {
	            System.out.print ("Bucket " + i + ":  ");             
	            Node start = table[i];
	            while(start != null)
	            {
	                System.out.print(start.getData() +" ");
	                start = start.getLink();
	            }
	            System.out.println();
	        }
	    }   
	

	public class HashEntry {

		private long key;
		private Node value;
		private SingleLinkedList SLL;

		public SingleLinkedList getSLL() {
			return SLL;
		}

		public void setSLL(SingleLinkedList sLL) {
			SLL = sLL;
		}

		HashEntry(long key, Node value) {
			this.key = key;
			this.value = value;
		}

		public long getKey() {
			return key;
		}

		public Node getValue() {
			return value;
		}

	}

	

}
