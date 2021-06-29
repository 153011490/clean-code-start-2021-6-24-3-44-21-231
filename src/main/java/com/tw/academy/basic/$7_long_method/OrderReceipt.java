package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        // print headers
        receipt.append("======Printing Orders======\n");

        // print date, bill no, customer name
//        receipt.append("Date - " + order.getDate();
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
//        receipt.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription());
            receipt.append('\t');
            receipt.append(lineItem.getPrice());
            receipt.append('\t');
            receipt.append(lineItem.getQuantity());
            receipt.append('\t');
            receipt.append(lineItem.totalAmount());
            receipt.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        receipt.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        receipt.append("Total Amount").append('\t').append(tot);
        return receipt.toString();
    }
}