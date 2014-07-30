package orologio;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Orologio extends Application {
    
    RadioButton rbCerchio = new RadioButton("Cerchio");
    RadioButton rbQuadrato = new RadioButton("Quadrato");
    Button btnManuale = new Button("Manuale");
    Button btnAutomatico = new Button("Automatico");
    ToggleGroup rbToggle = new ToggleGroup();
    
    
    HBox hbTop = new HBox();
    HBox hbBottom = new HBox();
    VBox vBox = new VBox();
    
    
    @Override
    public void start(Stage primaryStage) {
        
        rbCerchio.setToggleGroup(rbToggle);
        rbCerchio.setSelected(true);
        rbQuadrato.setToggleGroup(rbToggle);
        
        hbTop.getChildren().addAll(rbCerchio,rbQuadrato);
        hbBottom.getChildren().addAll(btnAutomatico,btnManuale);
        vBox.getChildren().addAll(hbTop,hbBottom);
        
        //evento manuale
        btnManuale.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(rbCerchio.isSelected())
                    SecondWindow.getInstance("cerchio", "auto");
                else
                    SecondWindow.getInstance("quadrato", "auto");
                    
            }
        });
        
        //evento automatico
        btnAutomatico.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(rbCerchio.isSelected())
                    SecondWindow.getInstance("cerchio", "manuale");
                else
                    SecondWindow.getInstance("quadrato", "manuale");
            }
        });        
        
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        
        Scene scene = new Scene(root, 400, 350);
        
        primaryStage.setTitle("Intro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
