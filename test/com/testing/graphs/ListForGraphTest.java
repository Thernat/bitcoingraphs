package com.testing.graphs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListForGraphTest {
    private ListsForGraph listsForGraph;
    @Before
    public void setUp() throws Exception {
        listsForGraph = new ListsForGraph();
    }

   @Test
   public void testGetListPrices(){
       List<String>prices = listsForGraph.getPrices();
       Assert.assertNotNull(prices);
       Assert.assertTrue(!prices.isEmpty());
   }


    @After
    public void tearDown() throws Exception {


    }
}