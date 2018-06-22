import java.util.Scanner;


public class DoubleLinkedListMain{
	static Scanner scan = new Scanner(System.in);
	static DoubleLinkedList dll = new DoubleLinkedList();
	//static Node head;

	public static void menu(){
		
		char ch;
		do
		{
			System.out.println("---------------------------------------");			
			dll.printfromHead();
			System.out.println("---------------------------------------");
			System.out.println("\n DOUBLE LINKED LIST DENGAN MENU \n");
			System.out.println("=======================================");
			System.out.println("1. Tambah Awal");
			System.out.println("2. Tambah Akhir");
			System.out.println("3. Tambah Data Indeks Tertentu");
			System.out.println("4. Hapus Awal");
			System.out.println("5. Hapus Akhir");
			System.out.println("6. Hapus Indeks Tertentu");
			System.out.println("7. Cetak Data");
			System.out.println("8. Cari");
			System.out.println("9. Merge sort");
			System.out.println("10. Keluar");
			System.out.println("=======================================");
			System.out.print(">> ");
			int choice = scan.nextInt();
			System.out.println("=======================================");
			System.out.println();
			switch (choice){
				case 1 :
				tambahAwal();
				break;

				case 2 :
				tambahAkhir();				
				break;

				case 3 :
				tambahIndex();
				break;

				case 4 :
				hapusAwal();
				break;

				case 5 :
				hapusAkhir();
				break;

				case 6 :
				hapusIndex();
				break;

				case 7 :
				dll.printfromHead();
				break;

				case 8 :
				cari();
				break;

				case 9 :
				mergeSort();
				break;

				case 10 :
				System.exit(0);
				break;

				default :
				System.out.println("Masukkan sesuai pilihan!");
				break;
				
			}

			System.out.print("\n Lanjutkan ? (Y/T) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

	}


	public static void tambahAwal(){
		System.out.print("Masukkan data : ");
		int data = scan.nextInt();
		dll.addFirst(data);
		System.out.println();
		dll.printfromHead();
		System.out.println();
		// menu();
	}

	public static void tambahAkhir(){
		System.out.print("Masukkan data : ");
		int data = scan.nextInt();
		dll.addLast(data);

				System.out.println();
		dll.printfromHead();
		System.out.println();
		
	}


	public static void tambahIndex(){
		System.out.print("Masukkan data : ");
		int data = scan.nextInt();
		System.out.print("Masukkan index : ");
		int index = scan.nextInt();
		dll.add(data,index);

		System.out.println();
		dll.printfromHead();
		System.out.println();

		// menu();
	}	


	public static void hapusAwal(){
		dll.printfromHead();

		dll.removeFirst();
		System.out.println("data awal telah dihapus!");

				System.out.println();
		dll.printfromHead();
		System.out.println();
	}


	public static void hapusAkhir(){
		dll.printfromHead();

		dll.removeLast();
		System.out.println("data akhir telah dihapus!");

		System.out.println();
		dll.printfromHead();
		System.out.println();
	}

	public static void hapusIndex(){
		System.out.print("Masukkan index : ");
		int index = scan.nextInt();
		dll.remove(index);

		System.out.println();
		dll.printfromHead();
		System.out.println();		
		
	}


	public static void cari(){
		dll.printfromHead();
		System.out.print("Masukkan data yang dicari : ");
		int cari = scan.nextInt();
		System.out.println();
		System.out.println("data "+cari+" ada pada index ke : "+dll.get(cari));
		
	}

	public static void mergeSort(){
		dll.printfromHead();
		System.out.println();
		//Node head = dll.getIndex(0);

		Node node = null;
        node = dll.mergeSort(dll.head);
        System.out.println("Linked list after sorting :");
        dll.print(node);
	}

	public static void main(String[] args) {
		
		dll.addFirst(3);
		dll.addLast(4);
		dll.addFirst(7);

		menu();
	}
}