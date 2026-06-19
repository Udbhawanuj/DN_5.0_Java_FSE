public class SearchService {
    public Product linearSearch(Product[] products, int targetProductId) {
        for (Product product : products) {
            if (product.getProductId() == targetProductId) {
                return product;
            }
        }
        return null;
    }
    public Product binarySearch(Product[] products, int targetProductId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetProductId) {
                return products[mid];
            }
            if (products[mid].getProductId() < targetProductId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}