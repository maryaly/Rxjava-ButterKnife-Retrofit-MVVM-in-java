package com.example.vosuqjava.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("baseCurrencyShortName")
    @Expose
    private String baseCurrencyShortName;

    @SerializedName("quoteCurrencyShortName")
    @Expose
    private String quoteCurrencyShortName;

    @SerializedName("quantityIncrement")
    @Expose
    private double quantityIncrement;

    @SerializedName("tickSize")
    @Expose
    private double tickSize;

    @SerializedName("takeLiquidityRate")
    @Expose
    private double takeLiquidityRate;

    @SerializedName("provideLiquidityRate")
    @Expose
    private double provideLiquidityRate;

    @SerializedName("feeSide")
    @Expose
    private int feeSide;

    public Item(String symbol, String baseCurrencyShortName, String quoteCurrencyShortName, double quantityIncrement, double tickSize, double takeLiquidityRate, double provideLiquidityRate, int feeSide) {
        this.symbol = symbol;
        this.baseCurrencyShortName = baseCurrencyShortName;
        this.quoteCurrencyShortName = quoteCurrencyShortName;
        this.quantityIncrement = quantityIncrement;
        this.tickSize = tickSize;
        this.takeLiquidityRate = takeLiquidityRate;
        this.provideLiquidityRate = provideLiquidityRate;
        this.feeSide = feeSide;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getBaseCurrencyShortName() {
        return baseCurrencyShortName;
    }

    public String getQuoteCurrencyShortName() {
        return quoteCurrencyShortName;
    }

    public double getQuantityIncrement() {
        return quantityIncrement;
    }

    public double getTickSize() {
        return tickSize;
    }

    public double getTakeLiquidityRate() {
        return takeLiquidityRate;
    }

    public double getProvideLiquidityRate() {
        return provideLiquidityRate;
    }

    public int getFeeSide() {
        return feeSide;
    }
}
