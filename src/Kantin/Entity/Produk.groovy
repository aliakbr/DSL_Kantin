package Kantin.Entity

class Produk {
    String name;
    BigInteger price;
    Map<String, Integer> resource_req = new HashMap<>();

    def harga(Integer price){
        this.price = price;
        return this;
    }

    def dari(String nama_bahan, Integer quantity){
        resource_req.put(nama_bahan, quantity)
        return this
    }
}
