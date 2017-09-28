package Kantin.Entity

class Pelanggan {
    Kantin kantin;
    String nama;
    Integer tempatDuduk = null;

    Pelanggan(Kantin k) {
        kantin = k;
    }

    public Pelanggan duduk (int mejaId) {
        tempatDuduk = mejaId
        kantin.meja(mejaId).pelanggan = this
        return this
    }

    // Hack to allow braceless invocation
    public Pelanggan getPergi () {
        kantin.meja(tempatDuduk).pelanggan = null
        tempatDuduk = null
        return this
    }

    public void pesan (String namaProduk, int kuantitas) {
        kantin.createPesanan(this, kantin.produk(namaProduk), kuantitas)
    }
}
