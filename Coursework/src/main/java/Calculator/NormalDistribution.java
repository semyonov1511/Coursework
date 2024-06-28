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
    private double mean;
    private double stdDev;

    public NormalDistribution(double mean, double stdDev) {
        this.mean = mean;
        this.stdDev = stdDev;
    }

    /**
     * Возвращает случайную double величину по закону нормального распределения с заданными в конструкторе
     * класса математическим ожиданием и отклонением
     *
     * @return случайную двоичную величину
     */
    public double nextNormal() {
        double gaussian = random.nextGaussian();
        gaussian *= stdDev;
        gaussian += mean;
        return gaussian;
    }

    /**
     * Создает гисторамму по данному массиву результатов и отображает в новом окне
     *
     * @param text название гистограммы
     *
     * @param results массив данных, на основе которых нужно построить гистограммы
     */
    public void createHistogram(String text, double[] results){
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("Histogram", results, 50);
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
        ChartFrame frame = new ChartFrame("Histogram", chart);
        frame.pack();
        frame.setVisible(true);
    }
}