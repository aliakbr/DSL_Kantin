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
        if (bahanMap.size() > 0) {
            for (def b : bahanMap.values()) {
                stringBuilder.append(b.toString())
                stringBuilder.append("\n")
            }
        } else {
            stringBuilder.append("tidak ada bahan yang terdaftar.\n")
        }
        stringBuilder.append("\n")

        stringBuilder.append("Produk:\n")
        if (produkMap.size() > 0) {
            for (def p: produkMap.values()){
                stringBuilder.append(p.toString())
                stringBuilder.append("\n")
            }
        } else {
            stringBuilder.append("tidak ada produk yang terdaftar.\n")
        }

        stringBuilder.append("Meja:\n")
        if (mejaMap.size() > 0) {
            for (def m : mejaMap.values()) {
                stringBuilder.append(m.toString())
                stringBuilder.append("\n")
            }
        } else {
            stringBuilder.append("tidak ada meja yang terdaftar.\n")
        }
        stringBuilder.append("\n")

        stringBuilder.append("Pelanggan:\n")
        if (pelangganMap.size() > 0) {
            for (def p : pelangganMap.values()) {
                stringBuilder.append(p.toString())
                stringBuilder.append("\n")
            }
        } else {
            stringBuilder.append("tidak ada pelanggan yang terdaftar.\n")
        }
        stringBuilder.append("\n")

        stringBuilder.append("Pesanan:\n")
        if (pesananList.size() > 0) {
            int i = 1
            for (def p : pesananList) {
                stringBuilder.append("Pesanan " + i++ + "\n")
                stringBuilder.append(p.toString())
                stringBuilder.append("\n\n")
            }
        } else {
            stringBuilder.append("tidak ada pesanan yang terdaftar.\n")
        }
        stringBuilder.append("\n")

        return stringBuilder.toString()
    }
}
