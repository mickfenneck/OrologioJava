
package orologio;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SecondWindow {
    
    private static SecondWindow finestra;
    Stage printStage;
    StackPane pannello;
    Scene scene;
    Clock orologio;
    HBox hBox;
    VBox vBox;
    
    private SecondWindow(String forma, String tipo)
    {
        printStage = new Stage();
        pannello = new StackPane();
        scene = new Scene(pannello, 400, 400);
        
        if(tipo=="manuale")
            newWindowMan(forma);
        else
            newWindowAuto(forma);
        
        printStage.setTitle("Orologio");
        printStage.setScene(scene);
        
        printStage.setOnCloseRequest(new EventHandler(){

            @Override
            public void handle(Event t) {
                finestra = null;
                System.gc();    //forzatura per cancellare finestra dalla memoria
            }
        });
        printStage.show();
        
        
    }
    
    
    public static void getInstance(String forma,String tipo){
        
        if (finestra==null)
            finestra = new SecondWindow(forma,tipo);
        else {
            if(tipo=="manuale")
            finestra.newWindowMan(forma);
        else
            finestra.newWindowAuto(forma);
        }
    }
    
    private void newWindowAuto(String forma)
    {
        removeChildren();
        
        orologio = new Clock(400,400,forma);
        pannello.getChildren().add(orologio); 

    }
    
    private void newWindowMan(String forma)
    {
        removeChildren();
        
        orologio = new Clock(400,400,forma);
        pannello.getChildren().add(orologio); 
    }
    
    private void removeChildren()
    {
        if(orologio!=null) 
            pannello.getChildren().remove(orologio);
        if(vBox!=null)
            pannello.getChildren().remove(vBox);
        if(hBox!=null)
            pannello.getChildren().remove(hBox);
    }
}
