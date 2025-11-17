package buttons;

import PanelAndFrame.StoryPanel; // Import StoryPanel

public class ThreeChoiceManager extends ChoiceManager {
    
    public ThreeChoiceManager(ChoiceButton.ChoiceActionListener listener) {
        super(listener);
    }
    
    @Override
    protected void setupButtons() {
        addButton("choice2-button"); // Periksa Barang Bukti
        addButton("choice1-button"); // Tanya Saksi
        addButton("choice3-button"); // Tuduh Tersangka
    }
    
    @Override
    protected void handleButtonClick(ChoiceButton clickedButton) {
        int buttonIndex = choiceButtons.indexOf(clickedButton);
        
        // Pastikan listener adalah StoryPanel agar bisa pindah scene
        if (panelListener instanceof StoryPanel) {
            StoryPanel panel = (StoryPanel) panelListener;
            
            switch(buttonIndex) {
                case 0: // Tombol 1: Periksa Barang Bukti
                    // Pindah ke scene yang managerType-nya EVIDENCE_CHOICE
                    panel.onSceneChangeRequest("scene_bukti"); 
                    break;
                case 1: // Tombol 2: Tanya Saksi
                    // Pindah ke scene People Choice 1
                    panel.onSceneChangeRequest("scene_saksi");
                    break;
                case 2: // Tombol 3: Tuduh Tersangka
                    panel.onSceneChangeRequest("scene_tuduh");
                    break;
            }
        }
    }
}