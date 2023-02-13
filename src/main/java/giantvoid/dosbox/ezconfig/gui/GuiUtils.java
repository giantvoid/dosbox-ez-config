package giantvoid.dosbox.ezconfig.gui;

import javax.swing.*;
import java.awt.*;

public class GuiUtils {
    public static JPanel createSinglePropertyPanel(ImageIcon imageIcon, JComponent propertyComponent) {
        JPanel groupPanel = new JPanel(new BorderLayout(10, 0));
        groupPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));

        groupPanel.add(new JLabel(imageIcon), BorderLayout.WEST);
        groupPanel.add(propertyComponent, BorderLayout.CENTER);

        return groupPanel;
    }
}
