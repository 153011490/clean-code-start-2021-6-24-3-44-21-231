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

        printHeader(receipt, "======Printing Orders======\n");

        printCustomerInformation(receipt);

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printItems(receipt, lineItem);

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

    private void printItems(StringBuilder receipt, LineItem lineItem) {
        receipt.append(lineItem.getDescription());
        receipt.append('\t');
        receipt.append(lineItem.getPrice());
        receipt.append('\t');
        receipt.append(lineItem.getQuantity());
        receipt.append('\t');
        receipt.append(lineItem.totalAmount());
        receipt.append('\n');
    }

    private void printCustomerInformation(StringBuilder receipt) {
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
    }

    private StringBuilder printHeader(StringBuilder receipt, String s) {
        return receipt.append(s);
    }
}