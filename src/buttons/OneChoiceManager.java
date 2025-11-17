
package buttons;
import PanelAndFrame.StoryPanel;

public class OneChoiceManager extends ChoiceManager {
    
    public OneChoiceManager(ChoiceButton.ChoiceActionListener listener) {
        super(listener);
    }
    
    @Override
    protected void setupButtons() {
        // Setup 2 tombol 
        addButton("choice5-button");
    }
    
    @Override
    protected void handleButtonClick(ChoiceButton clickedButton) {
        if (panelListener instanceof StoryPanel) {
            StoryPanel panel = (StoryPanel) panelListener;
            panel.onSceneChangeRequest("kembali");
        }
    }
}