package com.bhreneer.java.streams.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PrintUtils {

    public static String formatDouble(Double d) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(d);
    }
}
