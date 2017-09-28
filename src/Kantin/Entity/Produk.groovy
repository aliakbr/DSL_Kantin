package Kantin.Entity

class Produk {
    Kantin kantin
    String name;
    BigInteger price;
    Map<Bahan, Integer> resource_req = new HashMap<>();

    Produk(Kantin kantin) {
        this.kantin = kantin
    }

    public Produk harga(Integer price){
        this.price = price;
        return this;
    }

    public Produk dari(String nama_bahan, Integer quantity){
        resource_req.put(kantin.bahan(nama_bahan), quantity)
        return this
    }

    @Override
    String toString() {
        StringBuilder stringBuilder = new StringBuilder()
        stringBuilder.append(this.name + " harga: "+ this.price)
        stringBuilder.append("\n")
        stringBuilder.append("Bahan produk:\n")
        for (def resource: this.resource_req){
            stringBuilder.append(resource.key.name + " kuantitas: " + resource.value + " buah")
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
