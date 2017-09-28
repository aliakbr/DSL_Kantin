import Kantin.Kantin

class Main {
    public static void main(String[] args) {

        def kantin = Kantin.make {
            nama "Nasi Goreng"
            bahan "Telor" harga 1000 kuantitas 200
            bahan "Nasi" harga 3000 kuantitas 200
            produk "Nasi Goreng" harga 20000 dari "Nasi", 1 dari "Telor", 2 dari "Kecap", 1
            meja 0
            meja 1
        }

//        kantin.update {
//            pelanggan "A" duduk 0
//            pelanggan "A" pesan "Selo Jamur", 2
//            pesanan "A", "Selo Jamur" mulai dimasak
//            pesanan "A", "Selo Jamur" selesai dimasak
//            pelanggan "A" pergi
//
//            //------------------
//            bahan "Telur" ditambah 2
//        }

        println(kantin)
    }

}
