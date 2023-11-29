package ru.kuzinatra.projectmotorcycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Calculate {
    private static final long MULTIPLIER = 100_000_000L; //Множитель для ухода от float и double. Рассчеты ведем в long
    private static int annualPercentage;
    private static List<String> capitalList;

    public static int monthsToDream(int dreamPrice, int startAmount, int extraMonthlyIncome, int annualBankPercentage) {
        capitalList = new ArrayList<>();
        annualPercentage = annualBankPercentage;

        int monthCounter = 0;
        long result = startAmount * MULTIPLIER;
        addToCapitalList(result);

        while (result <= dreamPrice * MULTIPLIER) {
            result += (result * getMonthlyPercentage()) / MULTIPLIER + extraMonthlyIncome * MULTIPLIER;
            addToCapitalList(result);
            monthCounter++;
        }
        return monthCounter;
    }

    private static long getMonthlyPercentage() {
        return annualPercentage * MULTIPLIER / 1200;
    }

    public static List<String> getCapitalList() {
        return Objects.requireNonNullElse(Collections.unmodifiableList(capitalList), new ArrayList<>());
    }

    private static void addToCapitalList(long value) {
        capitalList.add(String.valueOf(value / MULTIPLIER));
    }
}
