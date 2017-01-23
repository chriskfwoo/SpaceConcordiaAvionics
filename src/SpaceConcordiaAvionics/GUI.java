package SpaceConcordiaAvionics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI {

    private JPanel mainPanel;
    private JFrame groundControl;

    private JPanel headerPanel;
    private JPanel southPanel;
    private JPanel dataPanel;
    private JLabel altitudeLabel;
    private JLabel latitudeLabel;
    private JLabel longitudeLabel;
    private JLabel accelXLabel;
    private JLabel accelYLabel;
    private JLabel accelZLabel;
    private JLabel gyroXLabel;
    private JLabel gyroYLabel;
    private JLabel gyroZLabel;
    private JLabel windVelocityLabel;
    private JLabel finStrainLabel;
    private JLabel logoLabel;
    private JPanel test;

    // TODO getters for graph datas

    public GUI(){
        initialize();
    }

    public JPanel getGraphPanel(){
        return test;
    }

    private void initialize(){
        groundControl = new JFrame("Ground Station");
        groundControl.getContentPane().add(mainPanel);
       // groundControl.setExtendedState(JFrame.MAXIMIZED_BOTH);
        groundControl.setBounds(100, 100, 1233, 836);
        groundControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logoLabel.setIcon(new ImageIcon(getClass().getResource("logo.png")));


        //JPanel jPanel1 = new JPanel();
        //jPanel1.setLayout(new java.awt.BorderLayout());
        test = new JPanel();
        JPanel chartPanel = createChartPanel();
        test.setLayout(new java.awt.BorderLayout());
        test.setBorder(new EmptyBorder(50,50,50,50));
        test.setBackground(new Color(245,245,219));
        test.add(chartPanel, BorderLayout.CENTER);
        test.validate();

        mainPanel.add(test);
        groundControl.setVisible(true);


    }

    public void updateLabels(String[] filterPacket){

        // TODO determine array order and handle edge cases
        altitudeLabel.setText(filterPacket[0]);
        latitudeLabel.setText(filterPacket[1]);
        longitudeLabel.setText(filterPacket[2]);
        accelXLabel.setText(filterPacket[3]);
        accelYLabel.setText(filterPacket[4]);
        accelZLabel.setText(filterPacket[5]);
        gyroXLabel.setText(filterPacket[6]);
        gyroYLabel.setText(filterPacket[7]);
        gyroZLabel.setText(filterPacket[8]);
        windVelocityLabel.setText(filterPacket[9]);
        finStrainLabel.setText(filterPacket[10]);
    }

    private JPanel createChartPanel() {
        // creates a line chart object
        // returns the chart panel
        String chartTitle = "";
        String xAxisLabel = "Time(s)";
        String yAxisLabel = "Altitude(ft)";

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);

        chart.setBackgroundPaint(new Color(245,245,219));
        chart.removeLegend();

        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        ValueAxis xAxis = plot.getDomainAxis();
        yAxis.setRange(1, 12000);

//        NumberAxis yAxisInterval = (NumberAxis) plot.getRangeAxis();
//        yAxisInterval.setTickUnit(new NumberTickUnit(.2));
        //yAxisInterval.setTickUnit(new NumberTickUnit(100));
        //xAxis.setRange(1,10);

        Font font = new Font("Monospace", Font.PLAIN, 12);

        yAxis.setTickLabelFont(font);
        xAxis.setTickLabelFont(font);

        return new ChartPanel(chart);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Object 1");
        XYSeries series2 = new XYSeries("Object 2");
        XYSeries series3 = new XYSeries("Object 3");

        series1.add(0, 0);
        series1.add(3, 3000);
        series1.add(5, 5000);
        series1.add(8, 8000);
        series1.add(10, 10000);
        series1.add(60, 0);

//        series2.add(2.0, 1.0);
//        series2.add(2.5, 2.4);
//        series2.add(3.2, 1.2);
//        series2.add(3.9, 2.8);
//        series2.add(4.6, 3.0);
//
//        series3.add(1.2, 4.0);
//        series3.add(2.5, 4.4);
//        series3.add(3.8, 4.2);
//        series3.add(4.3, 3.8);
//        series3.add(4.5, 4.0);

        dataset.addSeries(series1);
//        dataset.addSeries(series2);
//        dataset.addSeries(series3);

        return dataset;
    }



}
