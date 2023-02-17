package giantvoid.dosbox.ezconfig.gui;

import giantvoid.dosbox.ezconfig.base.Props;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class GuiUtils {
    private static final Font DEFAULT_FONT = new FontUIResource("Helvetica", Font.PLAIN, 12);

    public static JPanel createPropertyPanel(String imageIconName, JComboBox comboBox, JCheckBox checkBox) {
        JPanel groupPanel = new JPanel(new BorderLayout(10, 0));
        groupPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));

        groupPanel.add(new JLabel(Props.getImageIcon(imageIconName)), BorderLayout.WEST);

        comboBox.setFont(DEFAULT_FONT);

        if (checkBox != null) {
            checkBox.setFont(DEFAULT_FONT);
            checkBox.setMargin(new Insets(0, 15, 0, 0));
            JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            selectionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            groupPanel.add(selectionPanel, BorderLayout.CENTER);

            selectionPanel.add(comboBox);
            selectionPanel.add(checkBox);
        } else {
            groupPanel.add(comboBox, BorderLayout.CENTER);
        }

        return groupPanel;
    }
}
