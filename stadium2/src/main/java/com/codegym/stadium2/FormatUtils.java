package com.example.stadium;

import java.text.DecimalFormat;

public class FormatUtils {
    public static String formatPrice(long price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,### đ");
        return decimalFormat.format(price);
    }
}
