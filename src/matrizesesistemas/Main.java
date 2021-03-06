package matrizesesistemas;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static List<Matrix> matrixes = new ArrayList<>();

    public static void addToMatrixes(File file) throws InvalidMatrixException {
        Matrix matrix = new Matrix(file);
        matrixes.add(matrix);
    }
    
    public static void addToMatrixes(double[][] matrixN) throws InvalidMatrixException {
        Matrix matrix = new Matrix(matrixN);
        matrixes.add(matrix);
    }
    
    public static void removeFromMatrixes() {
        matrixes.remove(0);
    }

    public static List<Matrix> getMatrixes() {
        return matrixes;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        URL arquivoFXML = getClass().getResource("../fxml/select-file.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/matrix-icon.jpg")));
        stage.setScene(new Scene(fxmlParent, 600, 204));
        stage.setTitle("Calculadora de matrizes");
        stage.show();

    }
}
