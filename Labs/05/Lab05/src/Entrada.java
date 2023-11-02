import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Entrada {

    private List<Difuntos> difuntos;

    public Entrada() {
        difuntos = new ArrayList<>();
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        try (Scanner scanner = new Scanner(new File("defunciones.csv"))) {
            while (scanner.hasNextLine()) {
                String[] datosDifuntos = scanner.nextLine().split(",");
                Difuntos temp = new Difuntos(datosDifuntos[0].charAt(0), datosDifuntos[1], datosDifuntos[2], datosDifuntos[3], datosDifuntos[4], datosDifuntos[5], datosDifuntos[6]);
                difuntos.add(temp);
            }
        
