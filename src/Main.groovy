import Kantin.Kantin

class Main {
    public static void main(String[] args) {
        def kantin = Kantin.make {
            bahan {
                nama = "Telor"
                kuantitas = 200
                harga_per_satuan = 75000
            }

            produk {
                nama "Telor Dadar"
                bahan "Telor", 1
            }
//
//            pelanggan {
//                nama "Ali"
//            }
//
//            pesanan {
//                pelanggan "Ali"
//                produk "Telor Dadar" 1
//            }
        }

        println(kantin)
    }

}
