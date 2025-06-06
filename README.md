# ThreadedLiveCounterApp
🧵 ThreadedLiveCounterApp

A simple JavaFX desktop application that demonstrates multithreading, live UI updates, and user interaction through a threaded counter system.
✨ Features

    🔢 Live counter that increments rapidly using a background thread.

    ⏸ Pause and resume the counter anytime.

    🔁 Reset the counter to zero with a click.

    ⏱ Update how frequently the counter label is refreshed (in milliseconds).

    💡 Responsive JavaFX UI built using Scene Builder.


🛠 Technologies Used

    Java 17+

    JavaFX

    FXML (designed in Scene Builder)

    IntelliJ IDEA

    Git for version control

🚀 Getting Started

    Clone the repo:

    git clone https://github.com/your-username/ThreadedLiveCounterApp.git

    Open in IntelliJ:

        File → Open → Select the project folder

    Run the app:

        Run the Main class (with JavaFX set up)

📂 Project Structure

src/
├── com.example.threadedlivecounter
│   ├── LiveCounterController.java
│   ├── Main.java
│   └── counter_layout.fxml

📌 Learning Objectives

This app is a beginner-friendly introduction to:

    JavaFX UI development

    Working with threads in Java

    Safely updating UI from background threads (Platform.runLater)

    Event-driven programming (buttons, text inputs, etc.)

📄 License

You can add an open-source license like MIT if you'd like. To add a license file on GitHub:

    Go to your repo → Add file → Create new file → Name it LICENSE

    Choose a template (MIT is common)
