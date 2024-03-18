package javafx;

/**
 * This program designs the smiley face and axes with particular points as seen in the lab manual using JavaFX.
 * @author Juan Leem
 * @see <a href="https://docs.oracle.com/en/java/">Java Documentation</a>
 * @version 0.1
 * @since 2024-02-23
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SmileyFace extends Application {

    /**
     * This part is to start the JavaFx application.
     * @param stage The main stage for this application.
     */
    public void start(Stage stage) {

        Pane root = new Pane();

        // Display the text statment for the title.
        Text title = createTitle(140, 150, "Computer Graphic Axes", Color.rgb(71, 140, 117), new Font(45));

        // Draw Face
        Circle face = createCircle(400, 400, 200, Color.rgb(130, 130, 5), Color.BLACK);

        // Draw Pupils
        Circle rightPupil = createCircle(320, 320, 10, Color.BLACK, Color.TRANSPARENT);
        Circle leftPupil = createCircle(480, 320, 10, Color.BLACK, Color.TRANSPARENT);
 
        // Draw Eyes
        Circle rightEye = createCircle(320, 320, 35, Color.rgb(184, 184, 133), Color.BLACK);
        Circle leftEye = createCircle(480, 320, 35, Color.rgb(184, 184, 133), Color.BLACK);

        // Draw mouth
        QuadCurve mouth = createMouth(290, 500, 400, 600, 510, 500, Color.rgb(130, 130, 5), Color.BLACK, 3);

        root.getChildren().addAll(title, face, rightEye, leftEye, rightPupil, leftPupil, mouth);

        drawAxes(root);                 // Display X and Y axes

        drawAxisPixel(root);                    // Display X and Y axes' pixel markers

        drawXAxisPoints(root, 100, 800, 100);                   // Diplay X-Axis Points

        drawYAxisPoints(root, 100, 800, 100);                   // Display Y-Axis Points



        Scene scene = new Scene(root, 800, 800, Color.rgb(0,0,0));
        stage.setTitle("Smiley Face");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.sizeToScene(); 
        stage.show();

    } // start

    /**
     * This method creates a text node for the title.
     * @param x The x-coordinate of the title.
     * @param y The y-coordinate of the title.
     * @param text The text content of the title.
     * @param stroke The color of the title's stroke.
     * @param font The font size of the title.
     * @return It returns the creating title text node.
     */
    private Text createTitle(double x, double y, String text, Color stroke, Font font) {

        Text title = new Text(x, y, text);
        title.setStroke(stroke);
        title.setFont(font);
        return title;

    } // createTitle

    /**
     * This method creates circle shapes which are used to draw the smiley face.
     * @param centerX The x-coordinate of the center of the circle which is a face. 
     * @param centerY The y-coordinate of the center of the circle which is a face.
     * @param radius  The radius of the circle which is a face.
     * @param fill The color which fills the circle (face).
     * @param stroke The stroke color of the circle (face).
     * @return It returns the creating circle (face) shape.
     */
    private Circle createCircle(double centerX, double centerY, double radius, Color fill, Color stroke) {

        Circle circles = new Circle(centerX, centerY, radius);
        circles.setFill(fill);
        circles.setStroke(stroke);
        return circles;

    } // createCircle

    /**
     * This method creates shape of the mouth using a quadratic curve shape.
     * @param startX The x-coordinate of the starting point of the curve (mouth).
     * @param startY The y-coordinate of the starting point of the curve (mouth).
     * @param controlX The x-coordinate of the control point of the curve (mouth).
     * @param controlY The y-coordinate of the control point of the curve (mouth).
     * @param endX The x-coordinate of the end point of the curve (mouth).
     * @param endY The y-coordinate of the end point of the curve (mouth).
     * @param fill The color which fills the curve (mouth).
     * @param stroke The stroke color of the curve (mouth).
     * @param width The stroke width of the curve (mouth).
     * @return It returns the creating quadratic curve shape representing mouth.
     */
    private QuadCurve createMouth(double startX, double startY, double controlX, double controlY, double endX, double endY, Color fill, Color stroke, double width) {

        QuadCurve mouth = new QuadCurve(startX, startY, controlX, controlY, endX, endY);
        mouth.setFill(fill);
        mouth.setStroke(stroke);
        mouth.setStrokeWidth(width);
        return mouth;

    } // createMouth

    /**
     * This method creates a line shape.
     * @param startX The x-coordinate of the starting point of the line.
     * @param startY The y-coordinate of the starting point of the line.
     * @param endX The x-coordinate of the end point of the line.
     * @param endY The y-coordinate of the end point of the line.
     * @param stroke The stroke color of the line.
     * @param storkeWidth The stroke width of the line.
     * @return It returns the creating line shape.
     */
    private Line getLine(double startX, double startY, double endX, double endY, Color stroke, double storkeWidth) {

        Line lines = new Line(startX, startY, endX, endY);
        lines.setStroke(stroke);
        lines.setStrokeWidth(storkeWidth);
        return lines;

    } // getLine

    /**
     * This method draws the X and Y axes.
     * @param root The root pane to which the axes will be added
     */
    private void drawAxes(Pane root) {

        root.getChildren().addAll(
            getLine(0, 0, 800, 0, Color.web("9ACD32"), 10), 
            getLine(0, 0, 0, 800, Color.web("9ACD32"), 10));

    } // drawAxes

    /**
     * This method draws pixel markers along the X and Y axes.
     * @param root
     */
    private void drawAxisPixel(Pane root) {

        for(int i = 100; i <= 800; i+= 100) {

            root.getChildren().addAll(getLine(i, 9, i, 10, Color.rgb(157, 4, 4), 8));

            root.getChildren().addAll(getLine(4, i, 10, i, Color.rgb(157, 4, 4, 0.7), 8));

        }
    }

    /**
     * This method draws axis points along the X-axis.
     * @param root The root pane to which the axis points will be added.
     * @param start The starting position of the axis.
     * @param end The end position of the axis.
     * @param step The intervakl between consecutive axis points.
     */
    private void drawXAxisPoints(Pane root, int start, int end, int step) {
        
        Font fonts = new Font(10);

        for(int i = start; i <= end; i+= step) {
            
            Text axisPoint = new Text(i, 30, Integer.toString(i));
            axisPoint.setFont(fonts);
            axisPoint.setStroke(Color.rgb(101, 204, 170));
            root.getChildren().addAll(axisPoint);
        }

    } // drawXAxisPoints

    /**
     * This method draws axis points along the Y-axis.
     * @param root The root pane to which the axis points will be added.
     * @param start The starting position of the axis.
     * @param end The end position of the axis.
     * @param step The intervakl between consecutive axis points.
     */
    private void drawYAxisPoints(Pane root, int start, int end, int step) {

        Font fonts = new Font(10);

        for(int i = start; i <= end; i+= step) {
            
            Text axisPoint = new Text(30, i, Integer.toString(i));
            axisPoint.setFont(fonts);
            axisPoint.setStroke(Color.rgb(101, 204, 170));
            root.getChildren().addAll(axisPoint);
        }
        
    } // drawYAxisPoints

    public static void main(String[] args) {
        Application.launch(args);
    }
}
