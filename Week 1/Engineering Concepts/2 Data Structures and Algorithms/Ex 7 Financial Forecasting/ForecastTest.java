public class ForecastTest {
    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate = 0.10;
        int years = 5;
        FinancialForecast forecast = new FinancialForecast();
        double futureValue = forecast.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Present Value: " + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value: %.2f%n", futureValue);
    }
}