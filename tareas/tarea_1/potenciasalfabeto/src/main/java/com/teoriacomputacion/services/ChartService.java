package com.teoriacomputacion.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartService {
    public void createChart(Map<String, Integer> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Entry<String, Integer> entry : data.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            dataset.addValue(v, "numero de 1's", k);
        }

        JFreeChart chart = ChartFactory.createLineChart("Grafica", "Binario", "numero de 1's", dataset, PlotOrientation.VERTICAL, false, false, false);

        BufferedImage image = chart.createBufferedImage(1000, 800);
        try {
            ImageIO.write(image, "png", new File("xy-chart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
