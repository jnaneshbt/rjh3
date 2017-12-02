/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriber;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraphPlotter extends ApplicationFrame {

    JFreeChart chart;
    XYSeriesCollection data;
    XYSeries series;

    public GraphPlotter(final String title) {

        super(title);
        series = new XYSeries(title);
        /*
        series.add(1.0, 500.2);
        series.add(5.0, 694.1);
        series.add(4.0, 100.0);
        series.add(12.5, 734.4);
        series.add(17.3, 453.2);
        /*        series.add(21.2, 500.2);
        series.add(21.9, null);
        series.add(25.6, 734.4);
        series.add(30.0, 453.2);
         */
        data = new XYSeriesCollection(series);

        chart = ChartFactory.createXYLineChart(
                title,
                "X",
                "Y",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

    }

    int timetick = 20;

    public void addToX(int value) {
        series.add(timetick, value);
        timetick = (timetick + 1);
        System.out.println(timetick+" : "+value);

    }

    public void upgrade() {

        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    public static void main(final String[] args) {

        final GraphPlotter demo = new GraphPlotter("Temperature");
        demo.pack();
        demo.setVisible(true);
        RefineryUtilities.centerFrameOnScreen(demo);
        for (int i = 0; i < 2000; i++) {
           demo.addToX((int) (random() % 750));
            System.out.println(i);
        }
            demo.upgrade();


        try {
            sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GraphPlotter.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 2000; i++) {
           demo.addToX(800+(int) (random() % 750));
            System.out.println(i);
            demo.upgrade();
        }

    }

}
