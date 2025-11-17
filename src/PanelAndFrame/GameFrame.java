package PanelAndFrame;


import PanelAndFrame.OpeningPanel;
import PanelAndFrame.StoryPanel;
import ImageAnimator.ImageManager;
import text.FontManager;
import javax.swing.*;
import java.awt.*;

//tambahan
import engine.GameScene;
import engine.StoryLoader;
import java.util.List;

public class GameFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private StoryPanel storyPanel;
    
    public GameFrame() {
        setTitle("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        ImageManager.load();
        FontManager.load();
        
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        device.setFullScreenWindow(this);
        
        // Setup CardLayout untuk switching panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        //Inisialisasi panel
        OpeningPanel openingPanel = new OpeningPanel(this);
        storyPanel = new StoryPanel(); // (Panel A)
        
        // Tambahkan panel-panel MENGGUNAKAN VARIABEL YANG SUDAH ADA
        mainPanel.add(openingPanel, "opening"); // Gunakan variabel openingPanel
        mainPanel.add(storyPanel, "Story");     // Gunakan variabel storyPanel (Panel A)
        
        add(mainPanel);
        
        // Tampilkan opening panel pertama
        cardLayout.show(mainPanel, "opening");
    }
    
    // Method untuk beralih ke Story panel
public void switchToStory() {
        // 1. Load data dari JSON
        List<GameScene> story = StoryLoader.loadStory("contoh.json");
        
        // 2. Masukkan data ke StoryPanel (Gunakan loadStory, bukan startGame)
        storyPanel.loadStory(story); 
        
        // 3. Tampilkan Panel
        cardLayout.show(mainPanel, "Story");
    }

    // Method overload untuk story specific (opsional)
    public void switchToStory(String storyFile) {
        StoryPanel storyPanel = new StoryPanel();
        mainPanel.add(storyPanel, "story");
        
        // Load story dari file
        List<GameScene> story = StoryLoader.loadStory(storyFile);
        storyPanel.loadStory(story);
        
        cardLayout.show(mainPanel, "story");
    }
}