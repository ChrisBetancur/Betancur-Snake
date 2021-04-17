package UserInterface;

import Engine.GameEngine;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainMenuWindow {

    JFrame mainMenuFrame;
    JPanel buttonPanel;

    JButton playButton;
    JButton settingsButton;
    JButton aboutButton;
    JButton exitButton;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,650);
    private final static Dimension BUTTON_PANEL_DIMENSION = new Dimension(200,200);

    public MainMenuWindow() {
        mainMenuFrame = new JFrame();
        mainMenuFrame.setSize(OUTER_FRAME_DIMENSION);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.NORTH;

        JLabel title = new JLabel("<html><h1><strong><i>Snake Game</i></strong></h1><hr></html>");
        title.setVerticalAlignment(JLabel.TOP);

        jPanel.add(title, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());

        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuFrame.setVisible(false);
                GameEngine gameEngine = new GameEngine();
                gameEngine.run();


            }
        });
        settingsButton = new JButton("Settings");
        aboutButton = new JButton("About");
        exitButton = new JButton("Exit");

        buttons.add(playButton, constraints);
        buttons.add(settingsButton, constraints);
        buttons.add(aboutButton, constraints);
        buttons.add(exitButton, constraints);

        constraints.weighty = 1;
        jPanel.add(buttons, constraints);

        mainMenuFrame.add(jPanel);

        //mainMenuFrame.pack();
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);

    }

}
