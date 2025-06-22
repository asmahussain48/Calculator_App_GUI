import java.awt.*;
import javax.swing.*;

public class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        setFocusable(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false); // Ensures transparency
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Anti-aliasing for smoother curves and text
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        if (getModel().isArmed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }

        // Rounded background fill
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        // Text
        g2.setColor(getForeground());
        g2.setFont(getFont());
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();
        g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 4);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Optional: draw clean rounded border (or remove this if not needed)
        g.setColor(getBackground().darker());
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }

    @Override
    public boolean contains(int x, int y) {
        // For circular shape hit detection; you can change this for rounded
        return new Rectangle(0, 0, getWidth(), getHeight()).contains(x, y);
    }
}
