package hmw1;


public class Node {	
	private String data;
	private Node link;
	private int local_depth;
	private int repetition_counter;
	
	public Node(String x) {
		data = x;
		link = null;
		local_depth = main.globaldepth;
		repetition_counter = 1;
	}
	public void increase_repetition() {
		this.repetition_counter++;
	}
	public int getRepetition_counter() {
		return repetition_counter;
	}
	public Object getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
	public void setLocal_depth(int local_depth) {
		this.local_depth = local_depth;
	}
	public int getLocal_depth() {
		return local_depth;
	}
	public int size(){
		Node temp = this.getLink();
		int number_of_file = 0;
		while (temp != null) {
			number_of_file++;
			temp = temp.getLink();
		}
		return number_of_file;
	}
}
