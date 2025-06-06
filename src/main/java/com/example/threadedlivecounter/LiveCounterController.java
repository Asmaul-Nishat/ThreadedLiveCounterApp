package com.example.threadedlivecounter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LiveCounterController {

    @FXML
    private Label updateCounterTextField;

    @FXML
    private TextField inputTextField;

    private volatile long counter = 0;
    private Thread displayThread;
    private volatile boolean paused = false; // New pause flag

    @FXML
    public void initialize() {
        // Fast counter increment thread
        Thread incrementThread = new Thread(() -> {
            while (true) {
                if (!paused) {
                    counter++;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        incrementThread.setDaemon(true);
        incrementThread.start();

        // Start with default display interval
        startDisplayThread(1000);
    }

    @FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {
        try {
            long newInterval = Long.parseLong(inputTextField.getText());
            startDisplayThread(newInterval);
        } catch (NumberFormatException e) {
            inputTextField.setText("Invalid number");
        }
    }

    private void startDisplayThread(long intervalMs) {
        if (displayThread != null) {
            displayThread.interrupt();
        }

        displayThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(intervalMs);
                } catch (InterruptedException e) {
                    break;
                }

                long value = counter;
                Platform.runLater(() -> updateCounterTextField.setText("Counter: " + value));
            }
        });

        displayThread.setDaemon(true);
        displayThread.start();
    }

    @FXML
    public void pauseButtonOnAction(ActionEvent actionEvent) {
        paused = !paused; // Toggle pause/resume
        System.out.println(paused ? "Paused" : "Resumed");
    }
}
