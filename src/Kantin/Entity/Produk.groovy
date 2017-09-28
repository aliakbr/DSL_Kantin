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


}
