
    /**
     * Masih ada masalah dalam startnya belum sesuai timing
     */




package text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TypingAnimator {
    private Timer typingTimer; 
    
    // Variabel yang dipindahkan dari PrologPanel
    private String dialogText = ""; // Teks penuh yang akan ditampilkan
    private String displayedText = ""; // Teks yang saat ini ditampilkan
    private int textIndex = 0;
    private final int TYPING_DELAY = 30; 
    
    // Antarmuka (Interface) untuk memberi tahu PrologPanel
    // Ini adalah CALLBACK yang harus di-implementasikan oleh PrologPanel
    public interface TypingCompleteListener {
        void onTypingComplete();
        void requestRepaint();
    }
    
    private TypingCompleteListener listener;
    
    public TypingAnimator(TypingCompleteListener listener, String initialText) {
        this.listener = listener;
        this.dialogText = initialText;
        // Inisialisasi awal timer
        typingTimer = new Timer(TYPING_DELAY, this::handleTypingTick);
    }
    
    /**
     * Aksi yang dijalankan setiap Timer 'tick'
     */
    private void handleTypingTick(ActionEvent e) {
        if (textIndex < dialogText.length()) {
            // Tambahkan satu karakter per tick timer
            displayedText += dialogText.charAt(textIndex);
            textIndex++;
            listener.requestRepaint(); // Meminta PrologPanel untuk me-repaint
        } else {
            // Efek mengetik selesai
            typingTimer.stop();
            listener.onTypingComplete(); // Memberi tahu PrologPanel bahwa typing selesai
        }
    }
    
    /**
     * Memulai efek mengetik
     */
    public void startTypingEffect() {
        displayedText = "";
        textIndex = 0;
        if (typingTimer != null && !typingTimer.isRunning()) {
            typingTimer.start();
        }
    }
    
    // ========== PUBLIC METHODS ==========
    
    public String getDisplayedText() {
        return displayedText;
    }

    public boolean isTypingComplete() {
        return !typingTimer.isRunning();
    }
    
    /**
     * Mengubah teks dialog dan memulai ulang efek mengetik
     */
    public void setDialogText(String newText) {
        if (typingTimer != null && typingTimer.isRunning()) {
            typingTimer.stop();
        }
        this.dialogText = newText;
        listener.onTypingComplete(); // Memberi tahu untuk menyembunyikan tombol pilihan
        startTypingEffect(); 
    }
    
    /**
     * Skip efek mengetik (langsung tampilkan semua teks)
     */
    public void skipTyping() {
        if (typingTimer != null && typingTimer.isRunning()) {
            typingTimer.stop();
            this.displayedText = this.dialogText;
            listener.onTypingComplete(); // Tampilkan tombol setelah skip
            listener.requestRepaint();
        }
    }
    
    /**
     * Cleanup ketika objek dihapus
     */
    public void cleanup() {
        if (typingTimer != null) {
            typingTimer.stop();
        }
    }
}