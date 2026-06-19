import java.util.Arrays;
import java.util.Comparator;
public class EcommerceSearchTest {
        public static void main(String[] args) {
        Product[] products = {
            new Product(104, "Laptop", "Electronics"),
            new Product(101, "Shoes", "Fashion"),
            new Product(105, "Mobile Phone", "Electronics"),
            new Product(102, "Notebook", "Stationery"),
            new Product(103, "Watch", "Accessories")
        };
        SearchService searchService = new SearchService();
        Product linearResult = searchService.linearSearch(products, 103);
        System.out.println("Linear Search Result:");
        System.out.println(linearResult != null ? linearResult : "Product not found");
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        Product binaryResult = searchService.binarySearch(products, 105);
        System.out.println("\nBinary Search Result:");
        System.out.println(binaryResult != null ? binaryResult : "Product not found");
    }
}