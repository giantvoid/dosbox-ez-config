package giantvoid.dosbox.ezconfig.gui;

import giantvoid.dosbox.ezconfig.base.Props;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Frame extends JFrame implements WindowListener {
    public Frame() {
        super();
        initialize();
    }

    private void initialize() {
        initializeFrame();
        initializeListeners();
        initializePanels();
    }

    private void initializeFrame() {
        setTitle(Props.get("application", "name") + ' ' + Props.get("application", "version"));
        setSize(Props.getInt("frame", "width"), Props.getInt("frame", "height"));
        setLocationRelativeTo(null);
    }

    private void initializeListeners() {
        addWindowListener(this);
    }

    private void initializePanels() {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
