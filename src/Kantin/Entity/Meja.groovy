package Kantin.Entity

class Meja {
    Integer id;
    Pelanggan pelanggan = null;
    Boolean available () {
        return pelanggan == null;
    }
}
