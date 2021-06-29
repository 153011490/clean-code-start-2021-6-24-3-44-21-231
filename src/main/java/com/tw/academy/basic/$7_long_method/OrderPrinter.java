package com.tw.academy.basic.$7_long_method;

public class OrderPrinter {
    private final String header;
    private StringBuilder receipt = new StringBuilder();

    public OrderPrinter(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void printHeader(){
        receipt.append(this.header);
    }

    public StringBuilder printCustomerInformation(Order order) {
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
        return receipt;
    }
}
