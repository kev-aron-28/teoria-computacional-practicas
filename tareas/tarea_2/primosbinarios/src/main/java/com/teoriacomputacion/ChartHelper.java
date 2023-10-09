package com.teoriacomputacion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartHelper {
    public void createChart(DefaultCategoryDataset data) {
        JFreeChart chart = ChartFactory.createLineChart("Grafica", "Binario", "numero de 1's", data, PlotOrientation.VERTICAL, false, false, false);

        BufferedImage image = chart.createBufferedImage(1000, 800);
        try {
            ImageIO.write(image, "png", new File("xy-chart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
