package Kantin

import Kantin.Entity.*;

class Kantin {
    private String name;
    private Map<String, Bahan> bahanMap = new HashMap<>();
    private Map<Integer, Meja> mejaMap = new HashMap<>();
    private Map<String, Produk> produkMap = new HashMap<>();

    public static Kantin make(Closure<Kantin> closure) {
        def kantin = new Kantin()
        closure.delegate = kantin
        closure()
        return kantin
    }

    public Bahan bahan(String s){
        def b = new Bahan();
        b.name = s;
        bahanMap.put(b.name, b);
        return b;
    }

    public Produk produk(String s){
        def p = new Produk();
        p.name = s;
        produkMap.put(p.name, p);
        return p;
    }

    public void meja(Integer id){
        def m = new Meja();
        m.id = id;
        mejaMap.put(m.id, m);
    }

    public void nama(String s){
        this.name = s;
    }

    @Override
    String toString() {
        StringBuilder stringBuilder = new StringBuilder()
        stringBuilder.append("Bahan:\n")
        for (def b : bahanMap.values()) {
            stringBuilder.append(b.name + " harga: "+ b.price +  " kuantitas: " + b.quantity + " buah")
            stringBuilder.append("\n")
        }

        stringBuilder.append("Produk:\n")
        for (def p: produkMap.values()){
            stringBuilder.append(p.name + " harga: "+ p.price)
            stringBuilder.append("\n")
            stringBuilder.append("Bahan:\n")
            for (def resource: p.resource_req){
                stringBuilder.append(resource.key + " kuantitas: " + resource.value + " buah")
                stringBuilder.append("\n")
            }
        }

        stringBuilder.append("Meja:\n")
        for (def m : mejaMap.values()) {
            stringBuilder.append(m.id + " available: "+ m.available)
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
