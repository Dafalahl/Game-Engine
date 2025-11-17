package buttons;

import PanelAndFrame.StoryPanel;
import engine.GameCharacter;
import engine.SuspectCharacter;

public class TwoChoiceManager extends ChoiceManager {
    
    public TwoChoiceManager(ChoiceButton.ChoiceActionListener listener) {
        super(listener);
    }
    
    @Override
    protected void setupButtons() {
        addButton("choice4-button"); // Tombol TUDUH (Asumsi gambar choice4 = Ya/Tuduh)
        addButton("choice5-button"); // Tombol KEMBALI (Asumsi gambar choice5 = Tidak/Kembali)
    }
    
    @Override
    protected void handleButtonClick(ChoiceButton clickedButton) {
        int buttonIndex = choiceButtons.indexOf(clickedButton);
        
        if (panelListener instanceof StoryPanel) {
            StoryPanel panel = (StoryPanel) panelListener;
            
            switch(buttonIndex) {
                case 0: // --- LOGIKA TUDUH ---
                    // 1. Ambil ID tersangka dari Scene saat ini
                    String suspectId = panel.getCurrentScene().suspectId;
                    
                    if (suspectId != null) {
                        // 2. Cek di GameState apakah dia Guilty
                        GameCharacter character = panel.getGameState().getCharacter(suspectId);
                        if (character instanceof SuspectCharacter) {
                            boolean isGuilty = ((SuspectCharacter) character).isGuilty();
                            
                            if (isGuilty) {
                                System.out.println("✅ MENANG! Pelaku tertangkap: " + suspectId);
                                panel.onSceneChangeRequest("true_ending");
                            } else {
                                System.out.println("❌ SALAH TUDUH! Bukan dia pelakunya.");
                                panel.onSceneChangeRequest("bad_ending");
                            }
                        }
                    } else {
                        System.out.println("⚠️ Error: Tidak ada suspectId di scene ini.");
                    }
                    break;
                    
                case 1: // --- LOGIKA KEMBALI ---
                    System.out.println("🔙 Kembali memilih tersangka...");
                    // Kembali ke scene pemilihan orang
                    panel.onSceneChangeRequest("scene_tuduh"); 
                    break;
            }
        }
    }
}