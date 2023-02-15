package giantvoid.dosbox.ezconfig.gui;

import giantvoid.dosbox.ezconfig.base.Props;

import javax.swing.*;
import java.awt.*;

public class MachinePropertiesPanel extends JPanel {
    private JComboBox<Item> comboBoxCpu;
    private JComboBox<Item> comboBoxMemory;
    private JComboBox<Item> comboBoxDisplay;

    private JCheckBox checkBoxFullscreen;

    public MachinePropertiesPanel() {
        super(new BorderLayout());
        initialize();
    }

    private void initialize() {
        JPanel contentPanel = new JPanel(new GridLayout(2, 2, 20, 0));
        add(contentPanel, BorderLayout.NORTH);

        comboBoxCpu = new JComboBox<>(new Item[]{new Item("80386", "386")});
        contentPanel.add(GuiUtils.createSinglePropertyPanel("cpu", comboBoxCpu));

        comboBoxDisplay = new JComboBox<>(new Item[]{new Item("VGA", "vgaonly")});
        contentPanel.add(GuiUtils.createSinglePropertyPanel("display", comboBoxDisplay));

        comboBoxMemory = new JComboBox<>(new Item[]{new Item("4MB", "4")});
        contentPanel.add(GuiUtils.createSinglePropertyPanel("memory", comboBoxMemory));

        checkBoxFullscreen = new JCheckBox("Fullscreen");
        checkBoxFullscreen.setMargin(new Insets(0, 0, 0, 0));
        contentPanel.add(GuiUtils.createSinglePropertyPanel("empty", checkBoxFullscreen));
    }
}
