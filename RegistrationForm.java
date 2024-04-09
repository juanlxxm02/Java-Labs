package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This program computes a registration form filled application using JavaFX.
 * Also, it also shows that the fields users can input the username, password, and confirm password.
 * Then, this program is to check for the validity of the input, and the program displays a confirmation message.
 * @author Juan Leem
 * @see <a href="https://docs.oracle.com/en/java/">Java Documentation</a>
 * @version 0.1
 * @since 2024.03.09
 */
public class RegistrationForm extends Application {
    
    private GridPane grid;
    private Scene scene;
    Text formTitle;
    Label username;
    TextField usernameTextField;
    Label password;
    PasswordField passwordField;
    Label confirm;
    PasswordField confirmField;
    Button register;
    Button close;

    /**
     * This sets up the scene by creating UI components and adding them to the gird.
     */
    public void settingScene() {
    
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));
        scene = new Scene(grid, 700, 500);
        grid.setStyle("-fx-background-color: LIGHTSLATEGRAY");
        setupUI();

    }

    /**
     * This sets up the interface by creating texts, labels, text fields, and buttons.
     */
    private void setupUI() {

        formTitle = createText("Registration Form");
        grid.add(formTitle, 0, 0, 4, 1);

        username = createLabel("Username: ");
        grid.add(username, 0, 1);

        usernameTextField = createTextField();
        grid.add(usernameTextField, 1, 1);

        password = createLabel("Password: ");
        grid.add(password, 0, 2);

        passwordField = createPasswordField();
        grid.add(passwordField, 1, 2);

        confirm = createLabel("Confirm Password: ");
        grid.add(confirm, 0, 3);

        confirmField = createPasswordField();
        grid.add(confirmField, 1, 3);

        register = new Button("Register");
        register.setFont(new Font("Arial", 18));
        register.setOnAction(event -> registerButton());
        HBox hbBtn = createHBox(10);
        grid.add(hbBtn, 1, 4);

        close = new Button("Close");
        close.setFont(new Font("Arial", 18));
        close.setOnAction(event -> Platform.exit());

        HBox closeBtn = createClosebtn(10);
        closeBtn.setAlignment(Pos.CENTER_LEFT);
        closeBtn.getChildren().add(close);
        grid.add(closeBtn, 0, 5);

        
    } // setupUI

    /**
     * This method creates a text object with a specific font size and style.
     * @param text The text that displays on the registration form filled.
     * @return The text object.
     */
    private Text createText(String text) {

        Text title = new Text(text);
        title.setFont(Font.font("Arial", 40));
        title.setFill(Color.web("#FFFFF0"));
        return title;

    } // createText

    /**
     * This method creates a label object with the specific text and font style.
     * @param labelText The text that displays on the lable.
     * @return The label object.
     */
    private Label createLabel(String labelText) {

        Label label = new Label(labelText);
        label.setFont(new Font("Arial", 18));
        label.setTextFill(Color.web("#FFFFF0"));
        return label;

    } // createLabel

    /**
     * This method creates a text field object with a specific font style.
     * @return The text field object.
     */
    private TextField createTextField() {

        TextField textField = new TextField();
        textField.setFont(new Font("Arial", 18));
        return textField;

    } // createTextField

    /**
     * This creates a password field object with a specific font style.
     * @return The password field object.
     */
    private PasswordField createPasswordField() {

        PasswordField passwordField = new PasswordField();
        passwordField.setFont(new Font("Arial", 18));
        return passwordField;

    } // createPasswordField

    /**
     * This method creates a horizontal box layout for alignment of components.
     * @param boxSize The spacing between components in the horizontal box.
     * @return The horizontal box layout.
     */
    private HBox createHBox(double boxSize) {

        HBox horizontalBox = new HBox(boxSize);
        horizontalBox.setAlignment(Pos.BOTTOM_RIGHT);
        horizontalBox.getChildren().add(register);
        return horizontalBox;

    } // createHBox

    private HBox createClosebtn(double closebtn) {
        HBox closeBtn = new HBox(closebtn);
        closeBtn.setAlignment(Pos.CENTER_LEFT);
        return closeBtn;      
    }
    /**
     * This method handles the registration button event. Also, it checks for valid inputs from users and 
     * displays the appropriate alert message based on the input validity.
     */
    private void registerButton() {

        if(usernameTextField.getText().isBlank() && passwordField.getLength() < 12) {
            displayAlert(AlertType.ERROR, "**Username is required\n**Password must be at least 12 characters");
        } else if (usernameTextField.getText().isBlank() && passwordField.getLength() >= 12) {
            displayAlert(AlertType.ERROR, "**Username is required");
        } else if(usernameTextField.getText().length() > 0 && passwordField.getLength() < 12) {
            displayAlert(AlertType.ERROR, "**Password must be at least 12 characters");
        } else if(!(passwordField.getText().equals(confirmField.getText()))) {
            displayAlert(AlertType.ERROR, "**Password & confirm password did not match");
        } else {
            Alert successCase = displayAlert(AlertType.INFORMATION, "Your registration was successful.");
            successCase.setHeaderText("Success");
        }

    } // registerButton

    /**
     * This method displays an alert dialog with the specific type and message according to the valid input.
     * @param alertType The type of the alert (e.g. INFORMATION, CONFIRMATION, ERROR).
     * @param message  The message that displays in the alert dialog.
     * @return The created Alert object.
     */
    private Alert displayAlert(AlertType alertType, String message) {

        Alert alert = new Alert(alertType, message);
        alert.setTitle("Registration Form");
        alert.showAndWait();
        return alert;

    } // displayAlert

    /**
     * This method starts the JavaFX application by setting up the scene and displaying the stage.
     * @param stage The main stage for this application.
     */
    @Override
    public void start(Stage stage) {

        try {
    
            settingScene();
            stage.setScene(scene);
            Image icon = new Image("https://upload.wikimedia.org/wikipedia/commons/e/e4/Globe.png");
            stage.getIcons().add(icon);
            stage.setTitle("Registation Form");
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // start

    /**
     * Launching the application is the main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    } // main

    
}