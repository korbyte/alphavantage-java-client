package com.korbyte.models;

import lombok.Data;

@Data
public class DailyData {
    private double open;
    private double high;
    private double low;
    private double close;
    private long volume;
}
