package Kantin.Entity

class Kantin {
    private String name;
    private Map<String, Bahan> bahanMap = new HashMap<>();
    private Map<Integer, Meja> mejaMap = new HashMap<>();
    private Map<String, Produk> produkMap = new HashMap<>();
    private Map<String, Pelanggan> pelangganMap = new HashMap<>();
    private List<Pesanan> pesananList = new ArrayList<>()
    private Map<Tuple2<String, String>, Pesanan> pesananLatestMap = new HashMap<>();

    public static Kantin make(Closure<Kantin> closure) {
        def kantin = new Kantin()
        closure.delegate = kantin
        closure()
        return kantin
    }

    public void update(Closure<Kantin> closure) {
        closure.delegate = this
        closure()
    }

    public Bahan bahan(String s){
        if (bahanMap.containsKey(s)) return bahanMap.get(s);
        def b = new Bahan();
        b.name = s;
        bahanMap.put(b.name, b);
        return b;
    }

    public Produk produk(String s){
        if (produkMap.containsKey(s)) return produkMap.get(s);
        def p = new Produk(this);
        p.name = s;
        produkMap.put(p.name, p);
        return p;
    }

    public Meja meja(Integer id){
        if (mejaMap.containsKey(id)) return mejaMap.get(id);
        def m = new Meja();
        m.id = id;
        mejaMap.put(m.id, m);
        return m;
    }

    public Pelanggan pelanggan(String s){
        if (pelangganMap.containsKey(s)) return pelangganMap.get(s);
        def p = new Pelanggan(this);
        p.nama = s;
        pelangganMap.put(p.nama, p);
        return p;
    }

    public void nama(String s){
        this.name = s;
    }

    public Pesanan createPesanan(Pelanggan pelanggan, Produk produk, int kuantitas) {
        def refPair = new Tuple2(pelanggan.nama, produk.name)
        if (pesananLatestMap.containsKey(refPair)) {
            def existingOrder = pesananLatestMap.getAt(refPair)
            if (existingOrder.status == Pesanan.Status.Pending) {
                existingOrder.kuantitas += kuantitas
                return existingOrder
            } else if (existingOrder.status == Pesanan.Status.Dibuat) {
                // Sudah dibuat, tidak bisa diubah
                return existingOrder
            } // Sudah selesai, bikin baru
        }

        def pesanan = new Pesanan(this, pelanggan, produk, kuantitas)
        pesananList.add(pesanan)
        pesananLatestMap.put(refPair, pesanan)
        return pesanan
    }

    public Pesanan pesanan(String namaPelanggan, String namaProduk) {
        def refPair = new Tuple2(namaPelanggan, namaProduk)
        return pesananLatestMap.get(refPair)
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
                stringBuilder.append(resource.key.name + " kuantitas: " + resource.value + " buah")
                stringBuilder.append("\n")
            }
        }

        stringBuilder.append("Meja:\n")
        for (def m : mejaMap.values()) {
            stringBuilder.append(m.id + " available: "+ m.available())
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
