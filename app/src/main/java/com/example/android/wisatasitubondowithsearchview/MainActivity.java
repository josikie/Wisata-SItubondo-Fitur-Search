package com.example.android.wisatasitubondowithsearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // membuat field private
    private ArrayList<TempatWisata> tempatWisataArrayList = new ArrayList<TempatWisata>();
    private ListView listView;
    private TempatWisataAdapter tempatWisataAdapter;
    private String[] namaTempatList;
    private String[] lokasiTempatList;
    private SearchView searchView;
    private int[] gambarTempatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // isi data sesuai nama tempat wisata
        namaTempatList = new String[]{"Pasir Putih","Pathek", "Tampora", "Balanan", "Lempuyang", "Tangsi", "Bama", "Jangkar"};

        //isi data sesuai lokasi tempat wisata
        lokasiTempatList = new String[]{"Jln. Raya Pasir Putih No.87, Selomukti, Mlandingan, Pandansari, Bungatan, Situbondo, Jawa Timur, Indonesia", "Jalan Pantai Pathek, Gelung Selatan, Gelung, Kecamatan Situbondo, Kabupaten Situbondo, Jawa Timur, Indonesia",
                "Jalan Tampora, Besuki, Situbondo, Jawa Timur, Indonesia", "Desa Wonorejo, Kecamatan Banyu Putih, Kabupaten Situbondo, Jawa Timur",  "Pintu masuk Karangtekok, Situbondo, Jawa Timur, Indonesia",
                "Desa Pecinan/Simiring, Mangaran, Situbondo, Jawa Timur, Indonesia", "Banyuputih, Kabupaten Situbondo, Jawa Timur, Indonesia",  "Desa Jangkar, Situbondo, Jawa Timur, Indonesia"
        };

        //isi data sesuai gambar tempat
        gambarTempatList = new int[]{R.drawable.pasirputih, R.drawable.pathek, R.drawable.tampora, R.drawable.balanan, R.drawable.lempuyang, R.drawable.tangsi, R.drawable.bama, R.drawable.jangkar};

        // lakukan perulangan untuk memasukkan semua data list yang terpisah ke tempatWisataArrayList
        for (int i = 0; i < namaTempatList.length; i ++){
            // buat objek tempat wisata yang berisi gambarTempatList[posisi], namaTempatList[posisi], lokasiTempatList[posisi]
            TempatWisata tempatWisata = new TempatWisata(gambarTempatList[i], namaTempatList[i], lokasiTempatList[i]);
            //memasukkan semua data yang didapatkan oleh objek tempat wisata ke tempatWisataArrayList
            tempatWisataArrayList.add(tempatWisata);
        }

        // Memasang TempatWisataAdapter
        tempatWisataAdapter = new TempatWisataAdapter(this, tempatWisataArrayList);

        // Menemukan ListView menggunakan id
        listView = findViewById(R.id.listview);

        // pasang tempatWisataAdapter ke listview
        listView.setAdapter(tempatWisataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri url = Uri.parse("https://josikie.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);;
                startActivity(intent);
            }
        });
        // menemukan SearchView pada layout di activity_main.xml menggunakan id
        searchView = findViewById(R.id.search);
        // menempelkan querytextlistener yang didalamnya ada this yang merujuk ke MainActivity.java
        searchView.setOnQueryTextListener(this);
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextChange(String s) {
        // filter semua data yang masuk melalui variabel String s untuk dicari apakah ada di tempatWisataAdapter
        tempatWisataAdapter.filter(s);
        return false;
    }
}

