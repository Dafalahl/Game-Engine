
package buttons;
import PanelAndFrame.StoryPanel;


public class EvidenceChoice extends ChoiceManager {
    
    public EvidenceChoice(ChoiceButton.ChoiceActionListener listener) {
        super(listener);
    }
    
    @Override
    protected void setupButtons() {
        // Setup 2 tombol dengan gambar custom
        addButton("laptop");
        addButton("cctv");
        addButton("choice5-button");
    }
    
    @Override
    protected void handleButtonClick(ChoiceButton clickedButton) {
        int buttonIndex = choiceButtons.indexOf(clickedButton);
        if (panelListener instanceof StoryPanel) {
            StoryPanel panel = (StoryPanel) panelListener;
            switch(buttonIndex) {
                case 0:
                    panel.onSceneChangeRequest("membuka-laptop");
                    break;
                case 1:
                    panel.onSceneChangeRequest("membuka-cctv");
                    break;
                case 2:
                    panel.onSceneChangeRequest("kembali-pilhan");
                    break;
                }
        }
    }
}
