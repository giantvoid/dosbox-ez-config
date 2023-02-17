package giantvoid.dosbox.ezconfig.gui;

import javax.swing.*;
import java.awt.*;

public class MachinePropertiesPanel extends JPanel {
    private JComboBox<Item> comboBoxCpu;
    private JComboBox<Item> comboBoxMemory;
    private JComboBox<Item> comboBoxDisplay;
    private JComboBox<Item> comboBoxKeyboardLayout;
    private JComboBox<Item> comboBoxMouseSensitivity;

    private JCheckBox checkBoxFullscreen;
    private JCheckBox checkBoxMouseAutoLock;

    public MachinePropertiesPanel() {
        super(new BorderLayout());
        initialize();
    }

    private void initialize() {
        JPanel contentPanel = new JPanel(new GridLayout(3, 2, 20, 0));
        add(contentPanel, BorderLayout.NORTH);

        comboBoxCpu = new JComboBox<>(new Item[]{new Item("80386", "386")});
        contentPanel.add(GuiUtils.createPropertyPanel("cpu", comboBoxCpu, null));

        comboBoxKeyboardLayout = new JComboBox<>(new Item[]{new Item("de - German", "de")});
        contentPanel.add(GuiUtils.createPropertyPanel("keyboard", comboBoxKeyboardLayout, null));

        comboBoxMemory = new JComboBox<>(new Item[]{new Item("4MB", "4")});
        contentPanel.add(GuiUtils.createPropertyPanel("memory", comboBoxMemory, null));

        comboBoxMouseSensitivity = new JComboBox<>(new Item[]{new Item("normal", "500")});
        checkBoxMouseAutoLock = new JCheckBox("Autolock");
        checkBoxMouseAutoLock.setMargin(new Insets(0, 0, 0, 0));
        contentPanel.add(GuiUtils.createPropertyPanel("mouse", comboBoxMouseSensitivity, checkBoxMouseAutoLock));

        comboBoxDisplay = new JComboBox<>(new Item[]{new Item("VGA", "vgaonly")});
        checkBoxFullscreen = new JCheckBox("Fullscreen");
        checkBoxFullscreen.setMargin(new Insets(0, 0, 0, 0));
        contentPanel.add(GuiUtils.createPropertyPanel("display", comboBoxDisplay, checkBoxFullscreen));
    }
}
