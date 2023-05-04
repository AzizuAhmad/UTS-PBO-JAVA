import java.util.Scanner;
import java.util.Random;

class perdana {
    int barCode;
    String nmKartu;
    int hrgBeli, hrgJual;
    Scanner input1 = new Scanner(System.in);

    public void inputPerdana() {
        System.out.print("Barcode \t : ");
        barCode = input1.nextInt();
        input1.nextLine();
        System.out.print("Nama Produk \t : ");
        nmKartu = input1.nextLine();
        System.out.print("Harga Beli \t : ");
        hrgBeli = input1.nextInt();

        if (hrgBeli > 200000) {
            hrgJual = hrgBeli + (int) (hrgBeli * 0.5);
            System.out.println("Harga Jual \t : " + hrgJual);
        } else if (hrgBeli > 100000 && hrgBeli <= 200000) {
            hrgJual = hrgBeli + (int) (hrgBeli * 0.75);
            System.out.println("Harga Jual \t : " + hrgJual);
        } else if (hrgBeli > 50000 && hrgBeli <= 100000) {
            hrgJual = hrgBeli + (int) (hrgBeli * 1);
            System.out.println("Harga Jual \t : " + hrgJual);
        } else if (hrgBeli > 20000 && hrgBeli <= 50000) {
            hrgJual = hrgBeli + (int) (hrgBeli * 1.5);
            System.out.println("Harga Jual \t : " + hrgJual);
        } else if (hrgBeli < 25000) {
            hrgJual = hrgBeli + (int) (hrgBeli * 2);
            System.out.println("Harga Jual \t : " + hrgJual);
        }
    }

}

class grosir extends perdana {
    int noNota, jmlJual, totJual, jnsBayar, ppn, bunga, totByr, waktutemp;
    String ketBayar, souvenir, tempjnsbyr;
    String cabang;
    Scanner input2 = new Scanner(System.in);
    Random rand = new Random();
    
    int upperbound = 1000;
    

    public grosir(String cabang) {
        this.cabang = cabang;
        noNota = 1;

    }

    public int setNota() {
        noNota = rand.nextInt(upperbound);
        return noNota;

    }

    public int inputJumlah() {
        System.out.print("jml jual \t : ");
        jmlJual = input2.nextInt();
        return jmlJual;
    }

    public int getHargaJual() {
        return hrgJual;
    }

    public String inputJenis() {
        System.out.print("jenis bayar \t : ");
        jnsBayar = input2.nextInt();
        if (jnsBayar == 1) {
            tempjnsbyr = "cash";
        } else if (jnsBayar == 2) {
            tempjnsbyr = "tempo";
        }
        return tempjnsbyr;
    }

    public int hitungJual() {

        // System.out.print("Total : ");
        totJual = getHargaJual() * jmlJual;
        // System.out.println(totJual);
        return totJual;
    }

    public String getSouvenir() {
        if (jnsBayar == 1 && totByr >= 100000 && totByr <= 500000) {
            souvenir = "Mug";
        } else if (jnsBayar == 1 && totByr >= 500001 && totByr <= 750000) {
            souvenir = "Payung";
        } else if (jnsBayar == 1 && totByr >= 750001 && totByr <= 1000000) {
            souvenir = "Tas";
        } else if (jnsBayar == 1 && totByr >= 1000000) {
            souvenir = "Voucher 100rb";
        } else {
            souvenir = " - ";
        }
        return souvenir;
    }

    public int getppn() {
        ppn = (int) (hitungJual() * 0.11);
        return ppn;
    }

    public int getbunga() {
        if (waktutemp > 1) {
            bunga = (int) (hitungJual() * 0.5);
        }
        return bunga;
    }

    public int WT() {
        System.out.print("waktu tempo \t : ");
        waktutemp = input2.nextInt();
        return waktutemp;
    }

    public int gettotjual() {
        // // System.out.print("Total : ");
        // totJual = getHargaJual() * jmlJual;
        // // System.out.println(totJual);
        // return totJual;
        if (jnsBayar == 2) {
            totByr = getppn() + hitungJual() + getbunga();

        } else {
            totByr = getppn() + hitungJual();

        }
        return totByr;

    }

    public void ketbayr() {
        System.out.print(tempjnsbyr);
    }

    public void cetak() {
        System.out.println();
        System.out.println("grosir kartu perdana - " + cabang);
        System.out.println("no nota \t : " + setNota());
        // System.out.println("barcode \t : " + barCode);
        // System.out.println("nama produk \t : " + nmKartu);
        // System.out.println("harga beli \t : " + hrgBeli);
        // System.out.println("harga jual \t : " + hrgJual);
        inputPerdana();
        // System.out.println("jml. jual \t : " + jmlJual);
        inputJumlah();
        System.out.println("total \t\t : " + hitungJual());
        // System.out.println("jenis bayar \t : " + jnsBayar);
        inputJenis();
        System.out.println("ket bayar \t : " + tempjnsbyr);
        if (jnsBayar == 2) {
            WT();
            System.out.println("waktu tempo \t : " + waktutemp);
        } else if (jnsBayar == 1) {
            System.out.println("waktu tempo \t : " + "-");
        }
        System.out.println("PPN \t\t : " + getppn());
        if (jnsBayar == 2) {
            System.out.println("Bunga \t\t : " + getbunga());
        } else if (jnsBayar == 1) {
            System.out.println("Bunga \t\t : " + "-");
        }
        System.out.println("Total Bayar \t : " + gettotjual());
        System.out.println("souvenir \t : " + getSouvenir());
    }

    public void cetakNota() {
        System.out.println(setNota() + ".\t" + barCode + "\t" + nmKartu + "\t\t" + hrgBeli + "\t\t"
                + hrgJual + "\t\t" + jmlJual + "\t\t" + hitungJual() + "\t" + jnsBayar + "\t\t" + tempjnsbyr + "\t\t"
                + waktutemp + "\t\t" + getppn() + "\t" +getbunga() + "\t" + gettotjual() + "\t\t" + getSouvenir());
    }

}

public class PerdanaDemo {
    public static void main(String[] args) {
        String cabang;
        grosir[] tes1 = new grosir[10];
        int i = 1;
        Scanner input3 = new Scanner(System.in);

        while (true) {

            System.out.print("masukan cabang \t : ");
            cabang = input3.nextLine();
            tes1[i] = new grosir(cabang);
            System.out.println(" ");
            tes1[i].cetak();
            System.out.println("");
            i++;
            System.out.printf("Input lagi(y/t) \t: ");
            char loop = ' ';
            loop = input3.next().charAt(0);
            if (loop == 't') {

                break;
            }
            System.out.println("");
            input3.nextLine();
        }
        System.out.println("");

        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "Nota\tBarcode\tNama Produk\tHarga Beli\tHarga Jual\tJml. Jual\ttotal\tJenis Bayar\tKet. Bayar\tWaktu Tempo\tPPN\tBunga\tTotal Bayar\tSouvenir");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int j = 1; j <i; j++) {
            
            
            tes1[j].cetakNota();
        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
}
