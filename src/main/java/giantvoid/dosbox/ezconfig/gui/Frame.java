package giantvoid.dosbox.ezconfig.gui;

import giantvoid.dosbox.ezconfig.base.Props;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame extends JFrame {
    private JPanel contentPane;

    public Frame() {
        super();
        initialize();
    }

    private void initialize() {
        initializeFrame();
        initializePanels();
    }

    private void initializeFrame() {
        setTitle(Props.get("application", "name") + ' ' + Props.get("application", "version"));
        setSize(Props.getInt("frame", "width"), Props.getInt("frame", "height"));
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }
        });
    }

    private void initializePanels() {
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
    }

    private void quit() {
        System.exit(0);
    }
}
