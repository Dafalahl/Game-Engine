package text;

/**
 * Kelas yang menyimpan konfigurasi tata letak (layout) 
 * untuk teks di dalam kotak dialog.
 * Tujuannya adalah memisahkan data posisi teks dari logika animasi dialog.
 */
public class DialogText {
    // Posisi X awal teks di panel
    private static final int TEXT_X = 300; 
    // Posisi Y awal teks di panel
    private static final int TEXT_Y = 150;  
    // Lebar maksimum yang diizinkan untuk teks sebelum pindah baris
    private static final int MAX_TEXT_WIDTH = 550;
    
    // --- Getter Methods ---

    public static int getTextX() {
        return TEXT_X;
    }

    public static int getTextY() {
        return TEXT_Y;
    }

    public static int getMaxTextWidth() {
        return MAX_TEXT_WIDTH;
    }
}