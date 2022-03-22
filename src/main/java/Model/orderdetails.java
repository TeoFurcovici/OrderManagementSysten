package Model;

/**
 * The type Orderdetails.
 */
public class orderdetails {
    private int orderDetails_id;
    private int orderID;
    private String city;
    private String street;

    /**
     * Instantiates a new Orderdetails.
     *
     * @param orderDetailsID the order details id
     * @param orderID        the order id
     * @param city           the city
     * @param street         the street
     */
    public orderdetails(int orderDetailsID, int orderID, String city, String street) {
        this.orderDetails_id = orderDetailsID;
        this.orderID = orderID;
        this.city = city;
        this.street = street;
    }

    /**
     * Gets order details id.
     *
     * @return the order details id
     */
    public int getOrderDetailsID() {
        return orderDetails_id;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets order details id.
     *
     * @param orderDetails_id the order details id
     */
    public void setOrderDetails_id(int orderDetails_id) {
        this.orderDetails_id = orderDetails_id;
    }

    /**
     * Sets order id.
     *
     * @param orderID the order id
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }
}
