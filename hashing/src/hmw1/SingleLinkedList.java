package hmw1;


public class SingleLinkedList {
	private Node head;

	SingleLinkedList(Node head) {
		this.head = head;
	}	

	public int Size() {
		Node temp = head.getLink();
		int number_of_file = 0;
		while (temp != null) {
			number_of_file++;
			temp = temp.getLink();
		}
		return number_of_file;

	}

	public void print() {
		Node temp = head;
		temp = temp.getLink();
		System.out.println(Size() + " file is found!");
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getLink();
		}

	}

}

