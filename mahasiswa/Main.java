import java.util.Scanner;


public class Main{
	static Scanner scan = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);
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
			System.out.println("5. Cetak Data");
			System.out.println("6. Merge sort");
			System.out.println("7. Keluar");
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
				dll.printfromHead();
				break;

				case 6 :
				mergeSort();
				break;

				case 7 :
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
		System.out.print("Inputkan Nama : ");
		String nama = scString.nextLine();
		System.out.print("Inputkan nilai : ");
		int nilai = scan.nextInt();

		Mahasiswa newMahasiswa = new Mahasiswa(nama, nilai);
		dll.addFirst(newMahasiswa);
		System.out.println();
		dll.printfromHead();
		System.out.println();
		
	}

	public static void tambahAkhir(){
		System.out.print("Inputkan Nama : ");
		String nama = scString.nextLine();
		System.out.print("Inputkan nilai : ");
		int nilai = scan.nextInt();

		Mahasiswa newMahasiswa = new Mahasiswa(nama, nilai);
		
		dll.addLast(newMahasiswa);

		System.out.println();
		dll.printfromHead();
		System.out.println();
		
	}


	public static void tambahIndex(){
		System.out.print("Inputkan Nama : ");
		String nama = scString.nextLine();
		System.out.print("Inputkan nilai : ");
		int nilai = scan.nextInt();

		Mahasiswa newMahasiswa = new Mahasiswa(nama, nilai);

		System.out.print("Masukkan index : ");
		int index = scan.nextInt();

		dll.add(newMahasiswa,index);

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
		
		Mahasiswa newMahasiswa1 = new Mahasiswa("deby", 90);
		Mahasiswa newMahasiswa2 = new Mahasiswa("Alvin", 95);
		Mahasiswa newMahasiswa3 = new Mahasiswa("kinci", 100);
		dll.addFirst(newMahasiswa1);
		dll.addLast(newMahasiswa2);
		dll.addFirst(newMahasiswa3);

		menu();
	}
}