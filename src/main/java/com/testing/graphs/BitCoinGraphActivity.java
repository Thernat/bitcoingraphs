package com.testing.graphs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.androidplot.xy.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitCoinGraphActivity extends Activity
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // fun little snippet that prevents users from taking screenshots
        // on ICS+ devices :-)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);

        setContentView(R.layout.simple_xy_plot_example);
        XYPlot plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        Graph graph = new Graph(this,plot);
        List<Number>graphPoints = new ArrayList<Number>();
        graphPoints.add(1);
        graphPoints.add(3);
        graph.createGraph(graphPoints);
        requestForData();
    }
    private void requestForData(){
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://www.quandl.com/api/v1/datasets/PRAGUESE/PX.json?trim_start=2014-06-02&collapse=weekly";

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        parseData(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );
        queue.add(getRequest);
    }

    private void parseData(JSONObject json){
        try {
            JSONArray dataChainArray = json.getJSONArray("data");
            JSONArray dateAndPriceArray = dataChainArray.getJSONArray(0);
            PointGraphJavaObject pointGraphJavaObject = new PointGraphJavaObject();
            pointGraphJavaObject.setDay(dateAndPriceArray.getString(0));
            pointGraphJavaObject.setPrice(dateAndPriceArray.getString(1));
            pointGraphJavaObject.setRise(dateAndPriceArray.getString(2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

