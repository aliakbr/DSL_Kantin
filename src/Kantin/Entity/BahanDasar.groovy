package Kantin.Entity

class BahanDasar {
    String nama;
    Integer kuantitas;
    BigInteger harga_per_satuan;

    public static BahanDasar make (closure) {
        def dasar = new BahanDasar()

        closure.delegate = dasar
        closure()
        return dasar
    }

}
