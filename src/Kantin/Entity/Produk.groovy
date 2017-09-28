package Kantin.Entity

class Produk {
    String name;
    BigInteger price;
    Map<String, Integer> resource_req = new HashMap<>();

    public Produk harga(Integer price){
        this.price = price;
        return this;
    }

    public Produk dari(String nama_bahan, Integer quantity){
        resource_req.put(nama_bahan, quantity)
        return this
    }
}
