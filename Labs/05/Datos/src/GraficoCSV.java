import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

public class GraficoCSV {
    public static void main(String[] args) {
        try {
            // Cargar datos desde el archivo CSV
            BufferedReader br = new BufferedReader(new FileReader("Defunciones_HLMP_20231026.csv"));
            String line;
            DefaultXYDataset dataset = new DefaultXYDataset();

            // Definir las series de datos
            double[] xData = new double[0];
            double[] yData = new double[0];

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String sexo = parts[0];
                    String edadString = parts[1].replaceAll("A", "").replaceAll("M", "");
                    int edad = Integer.parseInt(edadString);

                    if (sexo.equals("F") && edad >= 30 && edad <= 40) {
                        // Agregar los datos que cumplen con las condiciones
                        double[] newxData = new double[xData.length + 1];
                        double[] newyData = new double[yData.length + 1];
                        System.arraycopy(xData, 0, newxData, 0, xData.length);
                        System.arraycopy(yData, 0, newyData, 0, yData.length);
                        newxData[xData.length] = xData.length + 1;
                        newyData[yData.length] = edad;
                        xData = newxData;
                        yData = newyData;
                    }
                }
            }

            dataset.addSeries("Edades", new double[][] { xData, yData });

            // Crear la gráfica
            JFreeChart chart = ChartFactory.createXYLineChart("Edades de mujeres entre 30 y 40 años", "Número de datos", "Edad", (XYDataset) dataset, PlotOrientation.VERTICAL, true, true, false);

            // Configurar apariencia de la gráfica
            XYPlot plot = (XYPlot) chart.getPlot();
            plot.setBackgroundPaint(Color.white);
            plot.setDomainGridlinePaint(Color.lightGray);
            plot.setRangeGridlinePaint(Color.lightGray);
            plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
            renderer.setSeriesPaint(0, Color.blue);

            // Guardar la gráfica como una imagen
            ChartUtilities.saveChartAsPNG(new File("grafico.png"), chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
