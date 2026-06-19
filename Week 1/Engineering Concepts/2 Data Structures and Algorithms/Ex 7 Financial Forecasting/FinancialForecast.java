public class FinancialForecast {
    public double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
    public double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        for (int i = 1; i <= years; i++) {
            futureValue = futureValue * (1 + growthRate);
        }
        return futureValue;
    }
}