import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String pilihan = "";

		System.out.println("===== Selamat Datang di Program Pendataan Makanan, Minuman, dan Obat =====\n");

		ArrayList<Makanan> makanan = new ArrayList<>();

		ArrayList<Minuman> minuman = new ArrayList<>();

		ArrayList<Obat> obat = new ArrayList<>();

		System.out.print("Masukkan pilihan Anda (makanan/minuman/obat): ");
		pilihan = sc.next();
		if (!pilihan.equals("makanan") && !pilihan.equals("minuman") && !pilihan.equals("obat")) {
			System.exit(0);
		}

		switch(pilihan) {
			case "makanan":
				System.out.print("Masukkan jumlah makanan yang ingin diinput: ");
				if (sc.hasNextInt()) {
					n = sc.nextInt();
					if (n < 0) {
						System.exit(0);
					}
				} else {
					System.exit(0);
				}

				System.out.println("\nINPUT DATA MAKANAN");

				for(int i = 0; i < n; i++) {
					Makanan newMakanan = new Makanan();
					try {
						System.out.print((i+1) + ". Kode: ");
						newMakanan.setKode(sc.next());
						System.out.print("   Nama: ");
						newMakanan.setNama(sc.next());
						System.out.print("   Kandungan Gizi: ");
						newMakanan.setKandunganGizi(sc.next());

						String jenis;
						System.out.print("   Jenis (MakananPokok, Snack, atau MakananPendamping): ");
						jenis = sc.next();
						if (!jenis.equals("MakananPokok") && !jenis.equals("Snack") && !jenis.equals("MakananPendamping")) {
							System.exit(0);
						}
						newMakanan.setJenis(jenis);

						System.out.print("   Nomor Ijin Pabrik: ");
						newMakanan.setNoIjinPabrik(sc.next());
					} catch(Exception e) {}
					makanan.add(newMakanan);
				}
				System.out.println("\n//DATA MAKANAN BERHASIL DIINPUT//");
				break;

			case "minuman":
				System.out.print("\nMasukkan jumlah minuman yang ingin diinput: ");
				if (sc.hasNextInt()) {
					n = sc.nextInt();
					if (n < 0) {
						System.exit(0);
					}
				} else {
					System.exit(0);
				}

				System.out.println("\nINPUT DATA MINUMAN");

				for(int i = 0; i < n; i++) {
					Minuman newMinuman = new Minuman();
					System.out.println("Input data minuman ke-" + (i+1) + ": ");
					try {
						System.out.print((i+1) + ". Kode: ");
						newMinuman.setKode(sc.next());
						System.out.print("   Nama: ");
						newMinuman.setNama(sc.next());
						System.out.print("   Kandungan Gula: ");
						newMinuman.setKandunganGula(sc.nextInt());

						String jenis;
						System.out.print("   Jenis (AirBersih, Suplemen, atau Buah): ");
						jenis = sc.next();
						if (!jenis.equals("AirBersih") && !jenis.equals("Suplemen") && !jenis.equals("Buah")) {
							System.exit(0);
						}
						newMinuman.setJenis(jenis);

						System.out.print("   Nomor Ijin Pabrik: ");
						newMinuman.setNoIjinPabrik(sc.next());
					} catch(Exception e) {}
					minuman.add(newMinuman);
				}
				System.out.println("\n//DATA MINUMAN BERHASIL DIINPUT//");
				break;

			case "obat":
				System.out.print("\nMasukkan jumlah obat yang ingin diinput: ");
				if (sc.hasNextInt()) {
					n = sc.nextInt();
					if (n < 0) {
						System.exit(0);
					}
				} else {
					System.exit(0);
				}

				for(int i = 0; i < n; i++) {
					Obat newObat = new Obat();
					System.out.println("Input data obat ke-" + (i+1) + ": ");
					try {
						System.out.print((i+1) + ". Kode: ");
						newObat.setKode(sc.next());
						System.out.print("   Nama: ");
						newObat.setNama(sc.next());
						System.out.print("   Jenis: ");
						newObat.setJenis(sc.next());

						int dose;
						try {
							System.out.print("   Dosis Per Hari (1-3): ");
							dose = sc.nextInt();
							if (dose < 1 || dose > 3) {
								System.exit(0);
							}
							newObat.setDosisPerHari(dose);
						} catch (InputMismatchException e) {
							System.exit(0);
						}

						System.out.print("   Bentuk: ");
						newObat.setBentuk(sc.next());
						System.out.print("   Penyakit: ");
						newObat.setPenyakit(sc.next());
						System.out.print("   Nomor Ijin Pabrik: ");
						newObat.setNoIjinPabrik(sc.next());
					} catch(Exception e) {}
					obat.add(newObat);
				}
				System.out.println("\n//DATA OBAT BERHASIL DIINPUT//");
				break;
		}

		int count;
		switch(pilihan) {
			case "makanan":
				count = 0;
				System.out.println("\nDATA MAKANAN:");
				for(Makanan m : makanan) {
					System.out.println((count+1) + ". Kode: " + m.getKode());
					System.out.println("   Nama: " + m.getNama());
					System.out.println("   Kandungan Gizi: " + m.getKandunganGizi());
					System.out.println("   Jenis: " + m.getJenis());
					System.out.println("   Nomor Ijin Pabrik: " + m.getNoIjinPabrik());
					count++;
				}
				break;
			case "minuman":
				count = 0;
				System.out.println("\nDATA MINUMAN:");
				for(Minuman m : minuman) {
					System.out.println((count+1) + ". Kode: " + m.getKode());
					System.out.println("   Nama: " + m.getNama());
					System.out.println("   Kandungan Gula: " + m.getKandunganGula());
					System.out.println("   Jenis: " + m.getJenis());
					System.out.println("   Nomor Ijin Pabrik: " + m.getNoIjinPabrik());
					count++;
				}
				break;

			case "obat":
				count = 0;
				System.out.println("\nDATA OBAT:");
				for(Obat o : obat) {
					System.out.println((count+1) + ". Kode: " + o.getKode());
					System.out.println("   Nama: " + o.getNama());
					System.out.println("   Jenis: " + o.getJenis());
					System.out.println("   Dosis per hari: " + o.getDosisPerHari());
					System.out.println("   Bentuk: " + o.getBentuk());
					System.out.println("   Penyakit: " + o.getPenyakit());
					System.out.println("   Nomor Ijin Pabrik: " + o.getNoIjinPabrik());
				}
				break;
		}

		System.out.println("\n//TERIMA KASIH!//");
	}
}