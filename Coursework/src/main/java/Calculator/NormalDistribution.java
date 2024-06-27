package Calculator;

import java.util.Arrays;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

public class NormalDistribution {
    private Random random = new Random();
    private double mean; // математическое ожидание
    private double stdDev; // среднеквадратическое отклонение

    public NormalDistribution(double mean, double stdDev) {
        this.mean = mean;
        this.stdDev = stdDev;
    }

    public double nextNormal() {
        // Генерируем случайное число с нормальным распределением с математическим ожиданием 0 и среднеквадратическим отклонением 1
        double gaussian = random.nextGaussian();

        // Масштабируем полученное число, умножая его на среднеквадратическое отклонение
        gaussian *= stdDev;

        // Сдвигаем полученное число, добавляя математическое ожидание
        gaussian += mean;

        return gaussian;
    }

    static void createHistogram(String text, double[] results){
        HistogramDataset dataset = new HistogramDataset();

        // Set the type of histogram to frequency
        dataset.setType(HistogramType.FREQUENCY);

        dataset.addSeries("Histogram", results, 80);

        // Create a JFreeChart instance
        JFreeChart chart = ChartFactory.createHistogram(
                text,
                "Value",
                "Frequency",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        // Display the chart
        ChartFrame frame = new ChartFrame("Histogram", chart);
        frame.pack();
        frame.setVisible(true);
    }
}