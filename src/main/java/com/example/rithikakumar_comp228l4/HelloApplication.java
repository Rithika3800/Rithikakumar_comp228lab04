package com.example.rithikakumar_comp228l4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application
{
    public TextField fullName,
            address,
            city,
            province,
            postalCode,
            phone,
            email;
    public RadioButton computerscienceRadioButton,
            businessRadioButton;
    public ComboBox<String> coursesComboBox;
    public ListView<String> coursesListView;
    public TextArea studentInfoTextArea;
    public CheckBox activitiesCheckBox1,
            activitiesCheckBox2;

    @Override
    public void start(Stage Stage)
    {
        fullName = new TextField();
        address = new TextField();
        city = new TextField();
        province = new TextField();
        postalCode = new TextField();
        phone = new TextField();
        email = new TextField();

        computerscienceRadioButton = new RadioButton("Computer Science");
        businessRadioButton = new RadioButton("Business");

        coursesComboBox = new ComboBox<>();
        coursesListView = new ListView<>();

        activitiesCheckBox1 = new CheckBox("Dance");
        activitiesCheckBox2 = new CheckBox("Paint");

        studentInfoTextArea = new TextArea();

        ToggleGroup group = new ToggleGroup();
        computerscienceRadioButton.setToggleGroup(group);
        businessRadioButton.setToggleGroup(group);

        computerscienceRadioButton.setOnAction(events -> Courses("ComputerScience"));
        businessRadioButton.setOnAction(events -> Courses("Business"));

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Student's Full Name:"),0,0);
        gridPane.add(fullName, 1, 0);
        gridPane.add(new Label("Student's Address:"), 0, 1);
        gridPane.add(address, 1, 1);
        gridPane.add(new Label("Student's City:"), 0, 2);
        gridPane.add(city, 1, 2);
        gridPane.add(new Label("Student's Province:"), 0, 3);
        gridPane.add(province, 1, 3);
        gridPane.add(new Label("Student's Postal Code:"), 0, 4);
        gridPane.add(postalCode, 1, 4);
        gridPane.add(new Label("Student's Phone:"), 0, 5);
        gridPane.add(phone, 1, 5);
        gridPane.add(new Label("Student's Email:"), 0, 6);
        gridPane.add(email, 1, 6);

        VBox majorSelectionBox = new VBox(computerscienceRadioButton,
                businessRadioButton);

        Button submitButton = new Button("Submit-->");
        submitButton.setOnAction(event -> StudentInfo());

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gridPane);
        borderPane.setLeft(majorSelectionBox);
        borderPane.setCenter(coursesComboBox);
        borderPane.setRight(coursesListView);
        borderPane.setBottom(studentInfoTextArea);

        Scene scene = new Scene(borderPane, 600, 400);
        Stage.setTitle("Student Details");
        Stage.setScene(scene);
        Stage.show();
    }
    String program;
    private void Courses(String program)
    {
        if ("ComputerScience".equals(program))
        {
            coursesComboBox.getItems().setAll("Java Programming", "Web application development","database");
            coursesListView.getItems().setAll("Java Programming", "Web application development","database");
        }
        else if ("Business".equals(program))
        {
            coursesComboBox.getItems().setAll("Business Management", "Accounting","Operating system");
            coursesListView.getItems().setAll("Business Management", "Accounting","Operating system");
        }
    }
    String studentInfo;
    private void StudentInfo()
    {
        String studentInfo = "Student's Full Name: " + fullName.getText() + "\n"
                + "Student's Address: " + address.getText() + "\n"
                + "Student's City: " + city.getText() + "\n"
                + "Student's Province: " + province.getText() + "\n"
                + "Student's Postal Code: " + postalCode.getText() + "\n"
                + "Student's Phone: " + phone.getText() + "\n"
                + "Student's Email: " + email.getText() + "\n"
                + "Student's Major: " + (computerscienceRadioButton.isSelected() ? "Computer Science" : "Business") + "\n"
                + "Student's Courses: " + String.join(", ", coursesListView.getItems()) + "\n"
                + "Student's Activities: " + (activitiesCheckBox1.isSelected() ? "Dance" : "")
                + (activitiesCheckBox2.isSelected() ? ", Paint" : "");

        studentInfoTextArea.setText(studentInfo);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
