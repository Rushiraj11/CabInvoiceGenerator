package com.bridgelabz.cabinvoicegenerator.model;
import java.util.Objects;
public class InvoiceSummary {

    int numberOfRides;
    double totalFare;
    double avgFare;



    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
    }

    public InvoiceSummary getInvoiceSummary() {
        this.avgFare = this.totalFare / this.numberOfRides;
        return this;
    }


    // creating equals() and hashcode() to avoid 2 different instances while comparing the objects

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRides, totalFare, avgFare);
    }
}
