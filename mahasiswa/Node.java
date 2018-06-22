public class Node{
	Mahasiswa data;
	Node prev, next;

	Node(Node prev, Mahasiswa data, Node next){
		this.prev = prev;
		this.data = data;
		this.next = next;
	}

	public Mahasiswa getData(){
    return this.data;
  }
}