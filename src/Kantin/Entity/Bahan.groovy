package Kantin.Entity

class Bahan {
    String name;
    BigInteger price;
    Integer quantity;

    public Bahan harga(BigInteger price){
        this.price = price;
        return this;
    }

    public Bahan kuantitas(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
