package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Random;

public class Controller {


    @FXML
    private TextArea txtOutput;

    @FXML
    private MenuItem btn_Import;

    @FXML
    private MenuItem btn_Save;

    @FXML
    private MenuItem btn_Exit;



    @FXML
    private Button btn_Copy;




    @FXML
    public void onClick_btn_Copy(ActionEvent e) {
        String myText = txtOutput.getText().toString();
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();

        content.putString(myText);
        clipboard.setContent(content);
    }



    @FXML
    public void fontSize(ActionEvent event) {txtOutput.setStyle("-fx-font-size: 45;");}
    @FXML
    public void setArial(ActionEvent event) {
        txtOutput.setStyle("-fx-font-family: arial;");
    }
    @FXML
    public void setTahoma(ActionEvent event) {
        txtOutput.setStyle("-fx-font-family: tahoma;");
    }
    @FXML
    public void setVerdana(ActionEvent event) {
        txtOutput.setStyle("-fx-font-family: verdana;");
    }

    @FXML
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setHeaderText("What i should write? Emmmm, you can call me Anri. Will Völkermord. Ich hasse Menschen.");
        alert.show();
    }

    @FXML
    private void onUniversity() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setHeaderText("This is an university project 'Text editor'");
        alert.show();
    }

    @FXML
    public void onClick_btn_Exit(ActionEvent e) {
        Platform.exit();
    }

    @FXML
    public void onClick_btn_Save(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save File");
        File selectedFile = chooser.showSaveDialog(stage);
        FileWriter FW = new FileWriter(selectedFile.getAbsolutePath());
        FW.write(txtOutput.getText().toString());
        FW.close();
    }

    @FXML
    public void onClick_btn_Import(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File selectedFile = chooser.showOpenDialog(stage);

        FileReader FR = new FileReader(selectedFile.getAbsolutePath().toString());
        BufferedReader BR = new BufferedReader(FR);

        StringBuilder sb = new StringBuilder();

        String myText = "";

        while((myText = BR.readLine()) != null) {
            sb.append(myText).append("\n");
        }
        txtOutput.setText(sb.toString());
    }
}