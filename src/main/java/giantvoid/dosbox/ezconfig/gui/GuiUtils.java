package giantvoid.dosbox.ezconfig.gui;

import giantvoid.dosbox.ezconfig.base.Props;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class GuiUtils {
    private static final Font DEFAULT_FONT = new FontUIResource("Helvetica", Font.PLAIN, 12);

    public static JPanel createSinglePropertyPanel(String imageIconName, JComponent propertyComponent) {
        propertyComponent.setFont(DEFAULT_FONT);

        JPanel groupPanel = new JPanel(new BorderLayout(10, 0));
        groupPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));

        groupPanel.add(new JLabel(Props.getImageIcon(imageIconName)), BorderLayout.WEST);
        groupPanel.add(propertyComponent, BorderLayout.CENTER);

        return groupPanel;
    }
}
