public class Main{
	public static void main(String[] args){
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.printfromHead();
		dll.printfromTail();
		System.out.println("size : "+dll.size());
		System.out.println("=====================================");
		dll.addFirst(3);
		dll.addLast(4);
		dll.addFirst(7);
		dll.printfromHead();
		dll.printfromTail();
		System.out.println("size : "+dll.size());
		System.out.println("=====================================");
		// dll.add(40,1);
		dll.printfromHead();
		dll.printfromTail();
		System.out.println("size : "+dll.size());
		System.out.println("=====================================");
		// dll.clear();
		// dll.print();
	}	
}
