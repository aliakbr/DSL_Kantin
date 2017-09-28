import Kantin.Entity.Kantin

class Main {
    public static void main(String[] args) {

        def kantin = Kantin.make {
            nama "Nasi Goreng"
            bahan "Telor" harga 1000 kuantitas 200
            bahan "Nasi" harga 3000 kuantitas 200

            produk "Nasi Goreng" harga 20000 dari "Nasi", 1 dari "Telor", 2
            produk "Omelet" harga 10000 dari "Telor", 3

            meja 1
            meja 2
            meja 3
            meja 4
        }

        println("\n\n\nEpoch 1 Result\n")
        println(kantin)

        kantin.update {
            pelanggan "A" duduk 1
            pelanggan "A" pesan "Nasi Goreng", 5
            pelanggan "A" pesan "Omelet", 2
            pesanan "A", "Nasi Goreng" dimasak
            pesanan "A", "Nasi Goreng" selesai
        }

        println("\n\n\nEpoch 2 Result\n")
        println(kantin)

        kantin.update {
            pelanggan "B" duduk 2
            pelanggan "B" pesan "Omelet", 3
            pesanan "B", "Omelet" dimasak
            pelanggan "C"
            pelanggan "C" pesan "Nasi Goreng", 2
            bahan "Telor" ditambah 2
            pesanan "C", "Nasi Goreng" dimasak
            pesanan "C", "Nasi Goreng" selesai
            pelanggan "C" pergi
            pelanggan "A" pesan "Nasi Goreng", 3
            pesanan "B", "Omelet" selesai
            pesanan "A", "Nasi Goreng" dimasak
            pesanan "A", "Nasi Goreng" selesai
            pelanggan "A" pergi
        }

        println("\n\n\nEpoch 3 Result\n")
        println(kantin)
    }

}
