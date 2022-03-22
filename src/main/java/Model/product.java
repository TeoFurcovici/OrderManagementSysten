package Model;

/**
 * The type Product.
 */
public class product {
    private int product_id;
    private String name;
    private int price;
    private int stock;

    /**
     * Instantiates a new Product.
     *
     * @param productID the product id
     * @param name      the name
     * @param price     the price
     * @param stock     the stock
     */
    public product(int productID, String name, int price, int stock) {
        this.product_id = productID;
        this.stock = stock;
        this.name = name;
        this.price = price;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public int getProductID() {
        return product_id;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets product id.
     *
     * @param product_id the product id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
