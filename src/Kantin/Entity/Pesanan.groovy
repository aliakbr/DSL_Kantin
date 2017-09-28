package Kantin.Entity

class Pesanan {
    enum Status {
        Pending,
        Dibuat,
        Selesai
    }
    enum Jenis {
        DineIn,
        TakeAway
    }
    Kantin kantin
    Pelanggan pelanggan
    Produk produk
    Status status
    int kuantitas
    Jenis jenis

    Pesanan(Kantin kantin, Pelanggan pelanggan, Produk produk, int kuantitas) {
        this.kantin = kantin
        this.pelanggan = pelanggan
        this.produk = produk
        this.kuantitas = kuantitas
        this.status = Status.Pending
        this.jenis = pelanggan.tempatDuduk != null ? Jenis.DineIn : Jenis.TakeAway
    }

    // Hack to allow braceless invocation
    public Pesanan getDimasak() {
        // LBYL to avoid changing state if error occurs
        for (def entry : produk.resource_req.entrySet()) {
            def bahan = entry.key
            def kuantitasKebutuhanBahan = entry.value
            if (bahan.quantity < kuantitasKebutuhanBahan * kuantitas) {
                throw new RuntimeException("Bahan habis untuk pembuatan produk " + produk.name)
            }
        }

        // Actually update
        status = Status.Dibuat
        for (def entry : produk.resource_req.entrySet()) {
            def bahan = entry.key
            def kuantitasKebutuhanBahan = entry.value
            bahan.quantity -= kuantitasKebutuhanBahan * kuantitas
        }

        return this
    }

    public Pesanan getSelesai() {
        status = Status.Selesai

        return this
    }

    @Override
    String toString() {
        StringBuilder stringBuilder = new StringBuilder()
        stringBuilder.append("Pesanan dari pelanggan " + this.pelanggan.nama + " produk: "+ this.produk.name
                +  " kuantitas: " + this.kuantitas + " buah\n")
        stringBuilder.append("harga satuan: Rp " + this.produk.price + " total: Rp " + this.produk.price * this.kuantitas)
        stringBuilder.append(" jenis: " + this.jenis + " status: " + this.status)


        return stringBuilder.toString()
    }
}
