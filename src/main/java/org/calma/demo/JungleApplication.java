package org.calma.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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

        // Dessiner des palmiers
        drawPalmTree(gc, 200, height - 200);
        drawPalmTree(gc, 600, height - 200);

        // Ajouter des détails (herbe, buissons, etc.)
        gc.setFill(Color.DARKGREEN);
        for (int i = 0; i < 20; i++) {
            double x = Math.random() * width;
            double y = height - 150 + Math.random() * 50;
            gc.fillOval(x, y, 30, 15);
        }

        // Dessiner un éléphant
        drawElephant(gc, 400, height - 200);

        for (int i = 0; i < 20; i++) {
            double x = Math.random() * width;
            double y = height - 550 + Math.random() * 50;
            drawBird(gc, x, y);
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

    private void drawBird(GraphicsContext gc, double x, double y) {
        // Body
        gc.setFill(Color.ORANGE);
        gc.fillOval(x, y, 20, 10);

        // Wing
        gc.setFill(Color.BROWN);
        gc.fillPolygon(new double[]{x + 5, x + 20, x + 10, x}, new double[]{y, y, y - 5, y}, 4);

        // Tail
        gc.setFill(Color.BLUE);
        gc.fillRect(x + 10, y + 5, 5, 5);

        // Head
        gc.setFill(Color.YELLOW);
        gc.fillOval(x - 5, y, 10, 10);

        // Eye
        gc.setFill(Color.BLACK);
        gc.fillOval(x, y + 3, 2, 2);
    }

    private void drawElephant(GraphicsContext gc, double x, double y) {
        // Dessiner le corps de l'éléphant
        gc.setFill(Color.GRAY);
        gc.fillOval(x, y, 120, 60);

        // Dessiner la tête
        gc.fillOval(x - 40, y + 10, 50, 40);

        // Dessiner les pattes
        gc.fillRect(x + 10, y + 50, 20, 40);
        gc.fillRect(x + 90, y + 50, 20, 40);

        // Dessiner la trompe
        gc.fillRect(x - 40, y + 30, 10, 30);

        // Dessiner les oreilles
        gc.fillOval(x - 50, y, 30, 30);

        // Dessiner les yeux
        gc.setFill(Color.BLACK);
        gc.fillOval(x - 30, y + 20, 5, 5);
    }

    public static void main(String[] args) {
        launch();
    }
}
