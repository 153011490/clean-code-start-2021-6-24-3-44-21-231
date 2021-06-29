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

    public String printReceipt() {
        StringBuilder receipt;

        String orderHeader = "======Printing Orders======\n";
        OrderPrinter orderPrinter = new OrderPrinter(orderHeader);
        receipt = orderPrinter.printHeader();

        printCustomerInformation(receipt, order);

        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            printItems(receipt, lineItem);

            double rateOne = .10;
            double salesTax = calculateSalesTax(lineItem, rateOne);
            totalSalesTax += salesTax;

            totalAmount += calculateTotalAmount(lineItem, salesTax);
        }

        String salesTax = "Sales Tax";
        printStateTax(receipt, totalSalesTax, salesTax);

        String totalAmountStr = "Total Amount";
        printTotalAmount(receipt, totalAmount, totalAmountStr);
        return receipt.toString();
    }

    private StringBuilder printTotalAmount(StringBuilder receipt, double totalAmount, String totalAmountStr) {
        return receipt.append(totalAmountStr).append('\t').append(totalAmount);
    }

    private StringBuilder printStateTax(StringBuilder receipt, double totalSalesTax, String salesTax) {
        return receipt.append(salesTax).append('\t').append(totalSalesTax);
    }

    private double calculateTotalAmount(LineItem lineItem, double salesTax) {
        return lineItem.totalAmount() + salesTax;
    }

    private double calculateSalesTax(LineItem lineItem, double rate) {
        return lineItem.totalAmount() * rate;
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

    private void printCustomerInformation(StringBuilder receipt, Order order) {
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
    }

    private StringBuilder printHeader(StringBuilder receipt, OrderPrinter orderPrinter) {
        return receipt.append(orderPrinter.getHeader());
    }
}