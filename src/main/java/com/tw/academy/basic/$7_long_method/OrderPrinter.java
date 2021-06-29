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

    public StringBuilder printHeader(){
        receipt.append(this.header);
        return receipt;
    }
}
