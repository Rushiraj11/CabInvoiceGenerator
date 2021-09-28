package com.bridgelabz.cabinvoicegenerator.service;

import com.bridgelabz.cabinvoicegenerator.model.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.model.Ride;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest  {
    InvoiceService invoiceService;

    @Before
    public void setup() {
        invoiceService = new InvoiceService();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare,0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5.0, totalFare,0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
        Ride[] rides = {
                new Ride(5.0, 10),
                new Ride(0.1, 1),
                new Ride(4.0,30)
        };

        double totalFare = invoiceService.calculateTotalFare(rides);
        Assert.assertEquals(70, totalFare, 0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(3,5),
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides );
        InvoiceSummary expectedInvoices = new InvoiceSummary(3, 65.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {

        InvoiceSummary invoiceSummary = invoiceService.getInvoice(1);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2,65.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }


    @Test
     public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {

    double distance = 2.0;
    int time = 5;
    String type = "normal";
    double fare = invoiceService.calculateFare(distance, time, type);
    Assert.assertEquals(25, fare, 0.0);

}

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        String type = "normal";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String type = "normal";
        double totalFare = invoiceService.calculateFare(rides, type);
        Assert.assertEquals(30.0, totalFare, 0.0);
    }


    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        String type = "premium";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(40, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        String type = "premium";
        double fare = invoiceService.calculateFare(distance, time, type);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String type = "premium";
        double totalFare = invoiceService.calculateFare(rides, type);
        Assert.assertEquals(60, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        String type = "Normal";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {
        String type = "Premium";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

}
