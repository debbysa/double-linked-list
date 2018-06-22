public class DoubleLinkedList{
	Node head;
	Node tail;
	int size;

	public DoubleLinkedList(){
		head = tail = null;
		size = 0;
	}
	public boolean isEmpty(){
		return head == null;
	}

	public void addFirst(int item){
		if(isEmpty()){
			head = tail = new Node(null, item, head);
		} else{
			Node newNode = new Node(null, item, head);
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addLast(int item){
		if(isEmpty()){
			addFirst(item);
		} else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			Node newNode = new Node(current, item, null);
			current.next = newNode;
			size++;
		}
	}

	public void add(int item, int index){
		if(isEmpty()) addFirst(item);
		if(index < 0 || index > size) System.out.println("Nilai Index diluar batas !");
		else {
			Node current = head;
			int i = 0;
			while(i < index){
				current = current.next;
				i++;
			}
			if(current.prev == null){
				Node newNode = new Node(null, item, current);
				current.prev = newNode;
				head = newNode;
			}
			else{
				Node newNode = new Node(current.prev, item, current);
				newNode.prev = current.prev;
				newNode.next = current;
				current.prev.next = newNode;
				current.prev = newNode;
			}
		}
		size++;
	}

	public int size(){
		return size;
	}

	public void clear(){
		head = null;
		size = 0;
	}

	public void printfromHead(){
		if(!isEmpty()){
			Node tmp = head;
			while(tmp!= null){
				System.out.print(tmp.data + "\t");
				tmp = tmp.next;
			}
			System.out.println("berhasil diisi");
		}
		else{
			System.out.println("Linked list kosong");	
		}
	}

	public void printfromTail(){ //index depan masih kosong, dibenerkan
		if(!isEmpty()){
			Node tmp = tail.next;
			while(tmp != null){
				System.out.print(tmp.data + "\t");
				tmp = tmp.prev;
			}
			System.out.println("berhasil diisi");
		}
		else{
			System.out.println("Linked list kosong");	
		}	
	}

	public void removeFirst(){
		if(isEmpty()) System.out.println("Linked List masih kosong, tidak dapat dihapus!");
		else if(size == 1){
			removeLast();
		}
		else{
			head = head.next;
			head.prev = null;
			size--;
		}
	}

	public void removeLast() {
		if(isEmpty()) System.out.println("LInked List masih kosong, tidak dapat dihapus!");
		if(head.next == null){
			head = null;
			size--;
			return;
		}
		Node current = head;
		while(current.next.next != null){
			current = current.next;
		}
		current.next = null;
		size--;
	}

	public void remove(int index) {
		if(isEmpty() || index >= size) System.out.println("Nilai index diluar batas!");
		if(index == 0){
			removeFirst();
		}
		else{
			Node current = head;
			int i = 0;
			while(i < index){
				current = current.next;
				i++;
			}
			if(current.next == null){
				current.prev.next = null;
			}
			else if(current.prev == null){
				current = current.next;
				current.prev = null;
				head = current;
			}
			else{
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
			size--;
		}
	}

	public int getFirst(){
		if(isEmpty()) System.out.println("Linked lIst kosong");
		return head.data;
	}

	public int getLast(){
		if(isEmpty()) System.out.println("Linked lIst kosong");
		Node tmp = head;
		while (tmp.next != null){
			tmp = tmp.next;
		}
		return tmp.data;
	}
	public int getIndex(int index){
		if(isEmpty()) System.out.println("Linked lIst kosong");
		Node tmp = head;
		for (int i =0; i < index; i++) {
			tmp = tmp.next;
		}
		return tmp.data;
	}

	public int get(int data) {
	    if(isEmpty()) System.out.println("LinkedList kosong");
		Node tmp = head;
		int i = 0;
		while (tmp.data != data){
			tmp = tmp.next;
			i++;
		}
		return i;
	}

	//===========================================================================
	//Merge Sort

	 void print(Node node) {
        Node temp = node;
        System.out.println("print from Head :");
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nPrint from Tail : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

	// Split double linked list (DLL) kedalam 2 bagian dari
    // ukuran setengahnya
    Node split(Node head) {
        Node first = head, second = head;
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }
        Node temp = second.next;
        second.next = null;
        return temp;
    }
    
    Node mergeSort(Node node) {

        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);
        
        // untuk mengecek data left dan rightnya
        node = mergeSort(node);
        second = mergeSort(second);
        
        // melakukan merge untuk kedua data left dan right
        return merge(node, second);
    }
    
    // Function untuk me merge 2 linked list
    Node merge(Node first, Node second) {
        //jika linked list pertama kosong
        if (first == null) {
            return second;
        }
        
        // jika linked list kedua kosong
        if (second == null) {
            return first;
        }
        
        // mencari nilai terkecil
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

}