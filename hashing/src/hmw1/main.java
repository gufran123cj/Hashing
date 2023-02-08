package hmw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static int globaldepth=8;
	public static int bucketsize=10;
	public static int bit_count=1;//1bit
	public static ArrayList<String> words = new ArrayList<>();
	SingleLinkedList SSL;


	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{

		int cnt=0;
	    String s;
		//File file = new File("deneme.txt");
		File file = new File("file.txt");
		

        Scanner sc = new Scanner(file);
		while(sc.hasNext()){
			words.add(sc.next());
		}
		HashTable hashTable = new HashTable((int)Math.pow(2, globaldepth));
		long key = 0;
		for (String string : words) {
			hashTable.insert(string);
		}
		System.out.println("------ Hashing Algorithm ------");
		System.out.println("Search: ");
		Scanner input= new Scanner(System.in);
		Node input_node = hashTable.search(input.next());
		System.out.println("Key: " + HashTable.get_key((String)input_node.getData()));
		System.out.println("Count: " + input_node.getRepetition_counter());
		System.out.println("Index: " + Long.toBinaryString(HashTable.get_key((String)input_node.getData())));
		System.out.println("Global Depth: " + main.globaldepth);
		System.out.println("Local Depth: " + input_node.getLocal_depth());
		sc.close();

		
		


	    }
}














