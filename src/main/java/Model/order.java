package Model;

/**
 * The type Order.
 */
public class order {
    private int order_id;
    private int client_id;
    private int product_id;
    private int qty;

    /**
     * Instantiates a new Order.
     */
    public order() {
    }

    /**
     * Instantiates a new Order.
     *
     * @param orderID   the order id
     * @param clientID  the client id
     * @param productID the product id
     * @param qty       the qty
     */
    public order(int orderID, int clientID, int productID, int qty) {
        this.order_id = orderID;
        this.client_id = clientID;
        this.product_id = productID;
        this.qty = qty;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderID() {
        return order_id;
    }

    /**
     * Sets order id.
     *
     * @param orderID the order id
     */
    public void setOrderID(int orderID) {
        this.order_id = orderID;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientID() {
        return client_id;
    }

    /**
     * Sets client id.
     *
     * @param clientID the client id
     */
    public void setClientID(int clientID) {
        this.client_id = clientID;
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
     * Sets product id.
     *
     * @param productID the product id
     */
    public void setProductID(int productID) {
        this.product_id = productID;
    }

    /**
     * Gets qty.
     *
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * Sets qty.
     *
     * @param qty the qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
}
