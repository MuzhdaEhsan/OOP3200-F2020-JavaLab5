package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        DecimalFormat df2 = new DecimalFormat("#.##");
        primaryStage.setTitle("Java Lab 5");

        // Lable and TextField for Height
        Label myHeight = new Label("My Height");
        final TextField txtHeight = new TextField();

        // Lable and TextField for Weight
        Label myHWeight = new Label("My Weight");
        final TextField txtWeight = new TextField();
        // text field for BMI calculation
        final TextField txtCalculate = new TextField();

        Button btnCalculate = new Button("Calculate BMI");

        // step #1.2 -  set event for buttons
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                // get the textfields values
                Double height = Double.parseDouble(txtHeight.getText());
                Double weight = Double.parseDouble(txtWeight.getText());

                // calculate the BMI and store in result variable
                Double result = (weight / (height * height));
                //result = Math.round(result*100);

                // set the result into Calculate textfield
                txtCalculate.setText(String.valueOf(df2.format(result)));
            }
        });

        VBox vBoxHeight = new VBox(10, myHeight,txtHeight,myHWeight,txtWeight,txtCalculate,btnCalculate);

        // lable for title
        Label BMI = new Label("BMI Scale");
        Label BMIresult = new Label("Result");

        // lable for underweight
        Label underWeight = new Label("Underweight");
        Label underWeightValue = new Label("less than 18.5");

        // lable for normal
        Label normal = new Label("Normal");
        Label normalValue = new Label("between 18.5 and 24.9");

        // lable for overweight
        Label overweight = new Label("Overweight");
        Label overweightValue = new Label("between 25 and 29.9");

        // lable for Obese
        Label obese = new Label("Obese");
        Label obeseValue = new Label("30 or greater");

        HBox hBox = new HBox(10, BMI, BMIresult);
        HBox hBox1 = new HBox(10, underWeight, underWeightValue);
        HBox hBox2 = new HBox(10, normal, normalValue);
        HBox hBox3 = new HBox(10, overweight, overweightValue);
        HBox hBox4 = new HBox(10, obese, obeseValue);

        GridPane verifyTable = new GridPane();
        verifyTable.setStyle("-fx-border-color: #000000; -fx-font-size: 20; -fx-font-family: Consolas;");

        verifyTable.add(hBox, 0,1);
        verifyTable.add(hBox1, 0,2);
        verifyTable.add(hBox2, 0,3);
        verifyTable.add(hBox3, 0,4);
        verifyTable.add(hBox4, 0,5);


        GridPane gridPane = new GridPane();

        // set font size
        gridPane.setStyle("-fx-font: 20 arial;");

        gridPane.add(vBoxHeight, 0, 0);
        gridPane.add(verifyTable, 0, 2);
        //gridPane.add(hBox2, 0, 3);

        Scene scene = new Scene(gridPane, 500, 480);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
