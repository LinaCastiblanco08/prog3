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
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo de municipios: " + e.getMessage());
        }
    }
    
    public int[] difuntosPorGenero(){
        int difuntosPorGenero[] = new int [2];
        int i=0;
        while (i<difuntos.size()){
            Difuntos temp = difuntos.get(i);
            
            switch (temp.sexo){
                case 'M':   difuntosPorGenero[0]+=1;
                            break;
                case 'F':   difuntosPorGenero[1]+=1;
                            break;
                default:    System.out.println("Error: El sexo "+temp.sexo+" no esta dentro de los posibles.");
                            break;
            }
            i++;
        }
        return difuntosPorGenero;
    }
    
    public int[] difuntosMayor48Horas(){
        int difuntos48[] = new int [2];
        int i=0;
        while (i<difuntos.size()){
            Difuntos temp = difuntos.get(i);
            
            if(temp.permanencia.equals("Mayor a 48 Horas")){
                switch (temp.sexo) {
                    case 'M':
                        difuntos48[0] += 1;
                        break;
                    case 'F':
                        difuntos48[1] += 1;
                        break;
                    default:
                        System.out.println("Error: El sexo " + temp.sexo + " no esta dentro de los posibles.");
                        break;
                }
            }
            i++;
        }
        return difuntos48;
    }
   
}
