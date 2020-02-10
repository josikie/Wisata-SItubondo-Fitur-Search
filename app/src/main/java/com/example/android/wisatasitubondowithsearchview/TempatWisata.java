package com.example.android.wisatasitubondowithsearchview;

public class TempatWisata { // private field gambar (int), namaTempat (String), lokasiTempat (String).
    private int gambar;
    private String namaTempat;
    private String lokasiTempat;

    /** public constructor
     *
     * @param gambar
     * @param namaTempat
     * @param lokasiTempat
     */
    public TempatWisata(int gambar, String namaTempat, String lokasiTempat) {
        this.gambar = gambar;
        this.namaTempat = namaTempat;
        this.lokasiTempat = lokasiTempat;
    }

    /** getLokasiTempat
     *
     * @return lokasiTempat
     */
    public String getLokasiTempat() {
        return lokasiTempat;
    }

    /** getNama Tempat
     *
     * @return namaTempat
     */
    public String getNamaTempat() {
        return namaTempat;
    }

    /** getGambar
     *
     * @return gambar
     */
    public int getGambar() {
        return gambar;
    }
}
