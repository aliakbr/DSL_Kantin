import Kantin.Entity.Kantin

class Main {
    public static void main(String[] args) {

        def kantin = Kantin.make {
            nama "Nasi Goreng"
            bahan "Telor" harga 1000 kuantitas 200
            bahan "Nasi" harga 3000 kuantitas 200

            produk "Nasi Goreng" harga 20000 dari "Nasi", 1 dari "Telor", 2

            meja 1
            meja 2
            meja 3
            meja 4
        }

        println("\n\n\nEpoch 1 Result\n")
        println(kantin)

        kantin.update {
            pelanggan "A" duduk 1
            pelanggan "A" pesan "Nasi Goreng", 20
            pesanan "A", "Nasi Goreng" dimasak
            pesanan "A", "Nasi Goreng" selesai
        }

        println("\n\n\nEpoch 2 Result\n")
        println(kantin)

        kantin.update {
            pelanggan "A" pergi
            bahan "Telor" ditambah 2
        }

        println("\n\n\nEpoch 3 Result\n")
        println(kantin)
    }

}
