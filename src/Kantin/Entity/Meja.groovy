package Kantin.Entity

class Meja {
    Integer id;
    Pelanggan pelanggan = null;
    Boolean available () {
        return pelanggan == null;
    }

    @Override
    String toString() {
        StringBuilder stringBuilder = new StringBuilder()
        stringBuilder.append("Meja " + this.id + " available: "+ this.available())
        if (!this.available()){
            stringBuilder.append(" dengan pelanggan " + pelanggan.nama)
        }

        return stringBuilder.toString()
    }
}
