
package buttons;


import PanelAndFrame.StoryPanel;
public class EvidenceLaptop extends ChoiceManager {
    
    public EvidenceLaptop(ChoiceButton.ChoiceActionListener listener) {
        super(listener);
    }
    
    @Override
    protected void setupButtons() {
        // Setup 2 tombol dengan gambar custom
        addButton("file-evidence");
        addButton("image-evidence");
        addButton("choice5-button");
    }
    
    @Override
    protected void handleButtonClick(ChoiceButton clickedButton) {
        int buttonIndex = choiceButtons.indexOf(clickedButton);
        if (panelListener instanceof StoryPanel) {
            StoryPanel panel = (StoryPanel) panelListener;
            switch(buttonIndex) {
                case 0:
                    panel.onSceneChangeRequest("bukti-file");
                    break;
                case 1:
                    panel.onSceneChangeRequest("bukti-foto");
                    break;
                case 2:
                    panel.onSceneChangeRequest("kembali-laptop");
                    break;
                }
        }
    }
}
