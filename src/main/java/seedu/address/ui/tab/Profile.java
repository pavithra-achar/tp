package seedu.address.ui.tab;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.ui.UiPart;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

import java.util.Comparator;

/** Student profile component of the Student Details Tab. */
public class Profile extends UiPart<Region> {

    private static final String FXML = "Profile.fxml";

    @FXML
    private FlowPane tags;

    @FXML
    private TextField nameField;

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField roomField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField emergencyContactField;

    @FXML
    private TextField remarkField;

    public Profile(ObservableValue<Person> selectedPerson) {
        super(FXML);
        selectedPerson.addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                System.out.println("null");
            }
            nameField.setText(newValue.getName().toString());
            studentIdField.setText(newValue.getStudentId().toString());
            roomField.setText(newValue.getRoomNumber().toString());
            emailField.setText(newValue.getEmail().toString());
            emergencyContactField.setText(newValue.getEmergencyContact().toString());
            remarkField.setText(newValue.getRemark().toString());
            tags.getChildren().clear();
            newValue.getTags().values().stream()
                    .sorted(Comparator.comparing(tag -> tag.tagName))
                    .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));

        });
    }
}
