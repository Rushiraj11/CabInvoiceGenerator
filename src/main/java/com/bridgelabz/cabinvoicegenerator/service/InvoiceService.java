package com.bridgelabz.cabinvoicegenerator.service;
import com.bridgelabz.cabinvoicegenerator.model.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.model.Ride;

import java.util.HashMap;
import java.util.Map;

public class InvoiceService {
    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MIN = 1;
    private static final double MIN_FARE = 5.0;

    public double calculateFare(double distance, int time) {

        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MIN_FARE); // if totalfare is less then minfare, then minfare is returned as totalfare
    }
    public double calculateTotalFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare = calculateFare(ride.getDistance(), ride.getTime());
        }

        return totalFare;
    }
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        System.out.println("Total rides="+rides.length);
        System.out.println("Totalfare="+totalFare);
        return new InvoiceSummary(rides.length, totalFare);
    }

        public InvoiceSummary getInvoice(int userId) {
            Map<Integer, Ride[]> map = new HashMap<>();
            Ride[] rides1 = {new Ride(3.0, 30),
                    new Ride(0.1, 1)
            };
            Ride[] rides2 = {new Ride(5.0, 10),
                    new Ride(1, 1)
            };

            Ride[] rides3 = {new Ride(4.0, 15),
                    new Ride(2, 10)
            };
            map.put(1, rides1);
            map.put(2, rides2);
            map.put(3, rides3);

            for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
                if (userId == entry.getKey()) {
                    System.out.println(entry.getKey());
                    Ride[] ridesArray = entry.getValue();
                    return calculateFare(ridesArray);
                }
            }
            return null;
        }
    }

