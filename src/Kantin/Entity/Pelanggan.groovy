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
        if (tempatDuduk != null) {
            kantin.meja(tempatDuduk).pelanggan = null
            tempatDuduk = null
        }
        return this
    }

    public void pesan (String namaProduk, int kuantitas) {
        kantin.createPesanan(this, kantin.produk(namaProduk), kuantitas)
    }

    @Override
    String toString() {
        StringBuilder stringBuilder = new StringBuilder()
        stringBuilder.append("Pelanggan " + this.nama)
        if (tempatDuduk != null){
            stringBuilder.append(" duduk pada meja " + tempatDuduk)
        }

        return stringBuilder.toString()
    }
}
