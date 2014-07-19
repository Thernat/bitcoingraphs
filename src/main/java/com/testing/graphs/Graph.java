package com.testing.graphs;

import android.content.Context;
import com.androidplot.xy.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mariusz on 2014-06-22.
 */
public class Graph {
    // initialize our XYPlot reference:

    private XYPlot plot;
    private Context context;
    public Graph(Context context,XYPlot plot) {
            this.plot = plot;
            this.context = context;


        // Turn the above arrays into XYSeries':

    }
    public void createGraph(List<Number>GraphPoints){
        XYSeries series1 = new SimpleXYSeries(
                GraphPoints,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Series1");                             // Set the display title of the series

        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(context,
                R.xml.line_point_formatter_with_plf1);

        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);

        // same as above:
        LineAndPointFormatter series2Format = new LineAndPointFormatter();
        series2Format.setPointLabelFormatter(new PointLabelFormatter());
        series2Format.configure(context,
                R.xml.line_point_formatter_with_plf2);

        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
    }
}
