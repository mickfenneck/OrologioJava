package orologio;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author mickfenneck
 */
public class Clock extends Canvas {
    public GraphicsContext gc;
    
    public Clock(int width,int height, String forma)
    {
        super(width,height);
        gc = this.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.setStroke(Color.GREEN);
        if(forma=="cerchio")
            gc.strokeOval(0, 0,  width, height);
        else
            gc.strokeRect(0, 0, width, height);
    }
}
