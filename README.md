# DSL Kantin

## Anggota Kelompok

- 13514014 M. Isham A.
- 13514080 Ali Akbar
- 13514086 Azka Hanif Imtiyaz

## Cara Menggunakan

Gunakan *static method* `Kantin.make` untuk membuat obyek kantin
dan mendefinisikan kondisi awal kantin. 
Kemudian, gunakan *method* `kantin.update` 
untuk melakukan perubahan kepada *state* kantin.

DSL yang dapat digunakan adalah sebagai berikut:

    nama <string>

Mendefinisikan nama kantin.

    bahan <nama> harga <harga> kuantitas <jumlah awal>
    
Mendefinisikan bahan.
    
    produk <nama> harga <harga> (dari <bahan>, <jumlah>)+
    
Mendefinisikan produk yang dijual di kantin dan dibuat dari satu atau lebih bahan.
    
    meja <number>
    
Mendefinisikan meja.
    
    pelanggan <nama> duduk <meja>
    
Mendefinisikan pelanggan yang datang dan menggunakan suatu meja. 
Pesanan pelanggan ini akan dianggap *dine in*.
    
    pelanggan <nama pelanggan> pesan <produk>, <jumlah>
    
Mencatat pesanan suatu pelanggan terhadap suatu produk.
    
    pelanggan <nama pelanggan> pergi
    
Mencatat pelanggan pergi dan mejanya dapat digunakan lagi.
    
    pesanan <nama pelanggan>, <nama produk> dimasak
    
Mencatat pesanan suatu pelanggan mulai dimasak. Stok bahan dikurangi pada saat ini.
    
    pesanan <nama pelanggan>, <nama produk> selesai
    
Mencatat pesanan suatu pelanggan selesai dimasak.
    
    bahan <bahan> ditambah <jumlah>
    
Mencatat penambahan stok bahan.

## Keluaran

Kondisi kantin dapat didapatkan dengan memanggil `toString`. Berikut contoh kondisi kantin:

    Bahan:
    Bahan Telor harga: 1000 kuantitas: 173 buah
    Bahan Nasi harga: 3000 kuantitas: 190 buah
    
    Produk:
    Nasi Goreng harga: 20000
    Bahan produk:
    Telor kuantitas: 2 buah
    Nasi kuantitas: 1 buah
    
    Omelet harga: 10000
    Bahan produk:
    Telor kuantitas: 3 buah
    
    Meja:
    Meja 1 available: true
    Meja 2 available: false dengan pelanggan B
    Meja 3 available: true
    Meja 4 available: true
    
    Pelanggan:
    Pelanggan A
    Pelanggan B duduk pada meja 2
    Pelanggan C
    
    Pesanan:
    Pesanan 1
    Pesanan dari pelanggan A produk: Nasi Goreng kuantitas: 5 buah
    harga satuan: Rp 20000 total: Rp 100000 jenis: DineIn status: Selesai
    
    Pesanan 2
    Pesanan dari pelanggan A produk: Omelet kuantitas: 2 buah
    harga satuan: Rp 10000 total: Rp 20000 jenis: DineIn status: Pending
    
    Pesanan 3
    Pesanan dari pelanggan B produk: Omelet kuantitas: 3 buah
    harga satuan: Rp 10000 total: Rp 30000 jenis: DineIn status: Selesai
    
    Pesanan 4
    Pesanan dari pelanggan C produk: Nasi Goreng kuantitas: 2 buah
    harga satuan: Rp 20000 total: Rp 40000 jenis: TakeAway status: Selesai
    
    Pesanan 5
    Pesanan dari pelanggan A produk: Nasi Goreng kuantitas: 3 buah
    harga satuan: Rp 20000 total: Rp 60000 jenis: DineIn status: Selesai 
