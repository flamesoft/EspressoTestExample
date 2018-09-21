package com.example.yzhang.simpleexample;

public class MainViewModel {
    private float calculateBMI(float height, float weight) {
        if (height > 0 && weight > 0) {
            return (weight/height/height) * 10000.0f;
        }
        return -1;
    }

    private String getStringFromFloat(float bmi) {
        return String.format("%.1f",bmi);
    }

    public String getBMI(float height, float weight) {
        float bmi = calculateBMI(height, weight);
        return getStringFromFloat(bmi);
    }
}
