package PanelAndFrame;

import ImageAnimator.ImageManager;
import text.FontManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class OpeningPanel extends JPanel {
    private BufferedImage openingImage;
    private boolean isHover = false; // status hover
    private Rectangle textBounds;    // area teks untuk deteksi hover
    private GameFrame parentFrame;  // Reference ke GameFrame

    public OpeningPanel(GameFrame frame) {
        this.parentFrame = frame;
        openingImage = ImageManager.get("opening");

        // Saat klik
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isHover) { // hanya jalan kalau klik tepat di teks
                    System.out.println("Game dimulai!");
                    parentFrame.switchToStory(); // Panggil method di GameFrame
                }
            }
        });

        // Saat mouse gerak (hover detector)
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (textBounds != null && textBounds.contains(e.getPoint())) {
                    isHover = true;
                } else {
                    isHover = false;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background
        if (openingImage != null) {
            g.drawImage(openingImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Draw text
        g.setFont(isHover ? FontManager.get("bold", 38f) : FontManager.get("bold", 32f));
        String text = "Klik Untuk Memulai Game!";
        int textWidth = g.getFontMetrics().stringWidth(text);
        int x = (getWidth() - textWidth) / 2;
        int y = getHeight() - 100;

        // Simpan area teks untuk deteksi hover
        textBounds = new Rectangle(x, y - 30, textWidth, 40);

        // Jika hover, warna berubah
        g.setColor(isHover ? new Color(0x85082d) : Color.BLACK);
        g.drawString(text, x, y);
    }
}
