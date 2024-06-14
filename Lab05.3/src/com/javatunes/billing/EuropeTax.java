/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * European orders are taxed as follows:
 * VAT is 17% of taxable amount.
 * Luxury tax is an additional 25% on amount over $100.
 * 
 * TODO: implement this algorithm.
 */
public class EuropeTax implements TaxCalculator{
    private static final double VAT = .17;
    private static final double LUXURY_TAX = .25;
    private static final double LUXARY_FREE_AMOUNT = 100.0;

    @Override
    public double taxAmount(double taxable) {
        double vat = taxable * VAT;
        double luxury = 0;
        if (taxable > LUXARY_FREE_AMOUNT) {
            luxury = (taxable - LUXARY_FREE_AMOUNT) * LUXURY_TAX;
        }

        return vat + luxury;
    }
}