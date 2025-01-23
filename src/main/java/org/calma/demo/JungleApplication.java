package org.calma.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JungleApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Dimensions de la fenêtre
        int width = 800;
        int height = 600;

        // Création de la scène et du canvas
        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Dessiner le paysage tropical
        drawTropicalLandscape(gc, width, height);

        root.getChildren().add(canvas);
        stage.setTitle("Paysage Tropical");
        stage.setScene(scene);
        stage.show();
    }

    private void drawTropicalLandscape(GraphicsContext gc, int width, int height) {
        // Dessiner le ciel
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, width, height);

        // Dessiner le sol
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, height - 150, width, 150);

        // Dessiner le soleil
        gc.setFill(Color.YELLOW);
        gc.fillOval(width - 150, 50, 100, 100);

        // Dessiner un palmier
        drawPalmTree(gc, 200, height - 200);
        drawPalmTree(gc, 600, height - 200);

        // Ajouter des détails (herbe, buissons, etc.)
        gc.setFill(Color.DARKGREEN);
        for (int i = 0; i < 20; i++) {
            double x = Math.random() * width;
            double y = height - 150 + Math.random() * 50;
            gc.fillOval(x, y, 30, 15);
        }
    }

    private void drawPalmTree(GraphicsContext gc, double x, double y) {
        // Dessiner le tronc
        gc.setFill(Color.SADDLEBROWN);
        gc.fillRect(x, y, 20, 100);

        // Dessiner les feuilles
        gc.setFill(Color.FORESTGREEN);
        for (int i = 0; i < 5; i++) {
            gc.fillArc(x - 40, y - 40, 100, 50, i * 30, 30, javafx.scene.shape.ArcType.ROUND);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
