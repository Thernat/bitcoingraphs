package com.testing.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariusz on 2014-06-28.
 */
public class ListsForGraph {
    private List<String> prices;

    public ListsForGraph() {
        this.prices = new ArrayList<String>();
    }

    public List<String> getPrices() throws Exception {
        if (!prices.isEmpty()) {
            return prices;
        } else {
            throw new Exception("there are no prices to show");
        }
    }
}
