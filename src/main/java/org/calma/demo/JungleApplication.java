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
//test
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

        // Ajouter des oiseaux
        for (int i = 0; i < 20; i++) {
            double x = Math.random() * width;
            double y = height - 550 + Math.random() * 50;
            drawBird(gc, x, y);
        }

        // Ajouter des enfants
        drawChild(gc, 300, height - 190);
        drawChild(gc, 500, height - 190);
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
        // Corps
        gc.setFill(Color.ORANGE);
        gc.fillOval(x, y, 20, 10);

        // Aile
        gc.setFill(Color.BROWN);
        gc.fillPolygon(new double[]{x + 5, x + 20, x + 10, x}, new double[]{y, y, y - 5, y}, 4);

        // Queue
        gc.setFill(Color.BLUE);
        gc.fillRect(x + 10, y + 5, 5, 5);

        // Tête
        gc.setFill(Color.YELLOW);
        gc.fillOval(x - 5, y, 10, 10);

        // Œil
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

    private void drawChild(GraphicsContext gc, double x, double y) {
        // Corps
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, 20, 40);

        // Tête
        gc.setFill(Color.PEACHPUFF);
        gc.fillOval(x + 5, y - 10, 10, 10);

        // Bras
        gc.setStroke(Color.PEACHPUFF);
        gc.setLineWidth(3);
        gc.strokeLine(x - 5, y + 10, x - 15, y + 20); // Bras gauche
        gc.strokeLine(x + 25, y + 10, x + 35, y + 20); // Bras droit

        // Jambes
        gc.setFill(Color.BROWN);
        gc.fillRect(x - 5, y + 40, 10, 20);
        gc.fillRect(x + 10, y + 40, 10, 20);

        // Dessiner les yeux
        gc.setFill(Color.BLACK);
        gc.fillOval(x + 8, y - 5, 2, 2);
        gc.fillOval(x + 10, y - 5, 2, 2);
    }

    public static void main(String[] args) {
        launch();
    }
}
