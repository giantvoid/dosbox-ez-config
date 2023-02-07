package giantvoid.dosbox.ezconfig.gui;

import giantvoid.dosbox.ezconfig.base.Props;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class MachineSelectionPanel extends JPanel {
    private static final String MACHINE_CUSTOM = "CUSTOM";

    private ButtonGroup buttonGroup;

    protected MachineSelectionPanel() {
        super(new GridLayout(1, 0));
        initialize();
    }

    private void initialize() {
        List<JToggleButton> machineButtons = Props.getSectionNames().stream()
                .filter(sectionName -> sectionName.startsWith("machine_"))
                .map(this::createMachineButton)
                .collect(Collectors.toList());
        machineButtons.add(createCustomMachineButton());

        ((GridLayout) getLayout()).setColumns(machineButtons.size());
        buttonGroup = new ButtonGroup();
        machineButtons.forEach(machineButton -> {
            buttonGroup.add(machineButton);
            add(machineButton);
        });

        machineButtons.get(0).setSelected(true);
    }

    private JToggleButton createMachineButton(String sectionName) {
        JToggleButton machineButton = new JToggleButton(Props.get(sectionName, "name"), Props.getImageIcon(sectionName, "image"));
        machineButton.setActionCommand(sectionName);
        machineButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        machineButton.setHorizontalTextPosition(SwingConstants.CENTER);
        return machineButton;
    }

    private JToggleButton createCustomMachineButton() {
        JToggleButton customMachineButton = new JToggleButton("custom...");
        customMachineButton.setActionCommand(MACHINE_CUSTOM);
        customMachineButton.setVerticalTextPosition(SwingConstants.CENTER);
        customMachineButton.setHorizontalTextPosition(SwingConstants.CENTER);
        customMachineButton.setMargin(new Insets(0, 0, 0, 0));
        return customMachineButton;
    }
}
