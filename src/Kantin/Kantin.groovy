package Kantin

import Kantin.Entity.Bahan
import Kantin.Entity.BahanDasar

class Kantin {
    private Map<String, BahanDasar> bahanMap = new HashMap<>();

    public static Kantin make(Closure<Kantin> closure) {
        def kantin = new Kantin()
        closure.delegate = kantin
        closure()
        return kantin
    }

    public void bahan(closure) {
        def b = BahanDasar.make(closure)
        bahanMap.put(b.nama, b)
    }

    @Override
    String toString() {
        StringBuilder stringBuilder = new StringBuilder()
        stringBuilder.append("Bahan:\n")
        for (def b : bahanMap.values()) {
            stringBuilder.append(b.nama + ": " + b.kuantitas + " buah")
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
