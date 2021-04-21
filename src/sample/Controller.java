package sample;



import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller   implements Initializable {
    public Controller() {
    }

    private final Polygon polygon = new Polygon();
    private int numberOfSides = 3;

    private void paint() {
        ObservableList<Double> list = polygon.getPoints();
        list.clear();
        final double WIDTH = 400, HEIGHT = 400;
        double centerX = WIDTH / 4, centerY = HEIGHT / 4;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;

        // Add points to the polygon list
        for (int i = 0; i < numberOfSides; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / numberOfSides));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / numberOfSides));
        }
    }


    public void regularPolygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;

        polygon.setTranslateX(borderPane.getWidth()+170);
        polygon.setTranslateY(borderPane.getHeight()+70);

        this.borderPane.getChildren().add(polygon);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLUE);
        paint();
    }

    @FXML
    private Button button1;
    public void isButton1(ActionEvent actionEvent) {
        button1.defaultButtonProperty().set(false);
        if (actionEvent != null) {
            volumeDecrease();
        }
    }

    @FXML
    private Button button2;
    public void isButton2(ActionEvent actionEvent) {
        button2.defaultButtonProperty().set(false);
        if (actionEvent != null) {
            volumeIncrease();
        }
    }


   private void volumeDecrease() {
      numberOfSides--;
      paint();
      isLabel();
   }

  private void volumeIncrease() {

      numberOfSides++;
      paint();
      isLabel();

  }




    public void initialize(URL url, ResourceBundle resourceBundle) {
      regularPolygon( numberOfSides);//Calling regularPolygon Method to create new polygon
    }




    @FXML private  Label label;
    public void isLabel() {
            if(numberOfSides==1){
                label.setText("Minimal size reached!");
            }else if(numberOfSides>=15) {
                label.setText("Maximum size reached");
            }
    }



    @FXML
    private ButtonBar buttonBar;
    public void isButtonbar(MouseEvent mouseEvent) {
        buttonBar.setButtonMinWidth(40);
        if (mouseEvent!=null){;
        }
    }
  @FXML  private BorderPane borderPane;
    public void isBorderpane(MouseEvent mouseEvent){
if (mouseEvent!=null){

} }


}