package com.nsg.nsgdtlibrary.Classes.util;

import java.math.BigDecimal;
/**
 * Created by sailaja.ch NSGI on 5/10/2019 *
 * Modified on 13/11/2019
 *
 */

public class DecimalUtils {
    public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
                BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
