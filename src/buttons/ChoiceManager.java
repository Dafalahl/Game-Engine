package buttons;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ChoiceManager implements ChoiceButton.ChoiceActionListener {
    
    protected List<ChoiceButton> choiceButtons;
    protected ChoiceButton.ChoiceActionListener panelListener;
    
    public ChoiceManager(ChoiceButton.ChoiceActionListener listener) {
        this.panelListener = listener;
        this.choiceButtons = new ArrayList<>();
        setupButtons(); // Template method pattern
    }
    
    // --- ABSTRACT METHODS (harus diimplement subclass) ---
    
    /**
     * Setup konfigurasi tombol (jumlah, gambar, posisi, dll)
     */
    protected abstract void setupButtons();
    
    /**
     * Handle logic ketika tombol tertentu diklik
     */
    protected abstract void handleButtonClick(ChoiceButton clickedButton);
    
    // --- TEMPLATE METHODS (sudah implement, bisa dioverride) ---
    
    // --- Meneruskan Input (Full-Stretch) ---
    
    public void checkAllHovers(Point p, int panelWidth, int panelHeight) {
        for (ChoiceButton button : choiceButtons) {
            button.checkHover(p, panelWidth, panelHeight);
        }
    }
    
    public void checkAllClicks(Point p, int panelWidth, int panelHeight) {
        for (ChoiceButton button : choiceButtons) {
            // Jika tombol ini diklik...
            if (button.checkClick(p, panelWidth, panelHeight)) {
                // ...Panggil logika spesifik tombol tersebut!
                handleButtonClick(button);
                
                // Panggil listener global (opsional, untuk efek suara klik dll)
                if (panelListener != null) panelListener.onChoiceClicked();
                
                return; // Hentikan pengecekan agar tidak klik double
            }
        }
    }
    
    // --- Drawing (Full-Stretch) ---
    
    public void drawAll(Graphics g, int panelWidth, int panelHeight) {
        for (ChoiceButton button : choiceButtons) {
            button.draw(g, panelWidth, panelHeight);
        }
    }
    
    // --- Interface Callback ---
    
    @Override
    public void onChoiceClicked() {
        // Default implementation - bisa dioverride
        panelListener.onChoiceClicked();
    }
    
    // --- Kontrol ---
    
    public void showAll(boolean show) {
        for (ChoiceButton button : choiceButtons) {
            button.show(show);
        }
    }
    
    // --- Helper Methods ---
    
    protected void addButton(String imageKey) {
        choiceButtons.add(new ChoiceButton(this, imageKey));
    }
    
    protected void addButton(ChoiceButton button) {
        choiceButtons.add(button);
    }
    
    public List<ChoiceButton> getChoiceButtons() {
        return choiceButtons;
    }
}