
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Estudiante
 */
public class XYChartExample {

    public static void main(String[] args) {
// Crear un gráfico xy simple
XYSeries series = new XYSeries("XYGraph");
series.add(1, 1);
series.add(1, 2);
series.add(2, 1);
series.add(3, 9);
series.add(4, 10);
// Agregar las series de datos
XYSeriesCollection dataset = new XYSeriesCollection();
dataset.addSeries(series);
// Generar el gráfico
JFreeChart chart = ChartFactory.createXYLineChart(
"XY Chart", // Título
"Eje x", // etiqueta para el eje x
"Eje y", // etiqueta para el eje y
dataset, // Dataset
PlotOrientation.VERTICAL, // Orientación
true, // Mostrar leyenda
true, // Usar tooltips
false // Configurar para generar URLs
);
// Generar un archivo con el gráfico
try {
ChartUtilities.saveChartAsJPEG(new File("chart.jpg"),
chart, 500, 300);
} catch (IOException e) {
System.err.println("Error al crear el archivo.");
}
    }
}

