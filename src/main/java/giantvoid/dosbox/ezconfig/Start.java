package giantvoid.dosbox.ezconfig;

import giantvoid.dosbox.ezconfig.base.Props;
import giantvoid.dosbox.ezconfig.gui.Frame;

import javax.swing.*;
import java.io.InputStreamReader;
import java.util.Objects;

public class Start {
    public static void main(String[] args) {
        try {
            Props.load(new InputStreamReader(Objects.requireNonNull(Start.class.getResourceAsStream("/dosbox-ez-config.ini"))));
            Props.load(new InputStreamReader(Objects.requireNonNull(Start.class.getResourceAsStream("/dosbox_options.ini"))));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    String.format("Read properties failed: %s\nPlease report this issue here: %s", throwable, "https://github.com/giantvoid/dosbox-ez-config/issues"),
                    "Error reading properties", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        new Frame().setVisible(true);
    }
}