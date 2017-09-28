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

    public Bahan ditambah(Integer quantity) {
        this.quantity += quantity;
        return this;
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Bahan bahan = (Bahan) o

        if (name != bahan.name) return false

        return true
    }

    int hashCode() {
        return name.hashCode()
    }
}
