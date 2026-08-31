package models;

import utils.TestDataReader;

public record Customer(String firstName, String lastName, String zipCode) {

    public static Customer getStandardCustomer() {
        return new Customer(
                TestDataReader.getProperty("customer.first.name"),
                TestDataReader.getProperty("customer.last.name"),
                TestDataReader.getProperty("customer.zip.code")
        );
    }
}