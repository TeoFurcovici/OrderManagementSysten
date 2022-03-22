package ValidatorLayer;

import Model.order;

/**
 * The type Order validator.
 */
public class OrderValidator implements Validator<order>{
    @Override
    public boolean validate(order order) {
        if(ValidateOrderID(String.valueOf(order.getOrderID()))==0) {
            System.out.println("order id is:"+ValidateOrderID(String.valueOf(order.getOrderID())));
            return false;
        }
        if(ValidateProductID(String.valueOf(order.getProductID()))==0) {
            System.out.println("product id is:"+ValidateProductID(String.valueOf(order.getProductID())));
            return false;
        }
        if(ValidateClientID(String.valueOf(order.getClientID()))==0) {
            System.out.println("client id is:"+ValidateClientID(String.valueOf(order.getClientID())));
            return false;
        }
        if(ValidateQty(String.valueOf(order.getQty()))==0) {
            System.out.println("qty is:"+ValidateQty(String.valueOf(order.getQty())));
            return false;
        }
        return false;
    }

    /**
     * Validate order id int.
     *
     * @param orderID the order id
     * @return the int
     */
    public static int ValidateOrderID(String orderID)
    {
        if(orderID.equals("") || !(orderID.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate client id int.
     *
     * @param clientID the client id
     * @return the int
     */
    public static int ValidateClientID(String clientID)
    {
        if(clientID.equals("") || !(clientID.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate product id int.
     *
     * @param productID the product id
     * @return the int
     */
    public static int ValidateProductID(String productID)
    {
        if(productID.equals("") || !(productID.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate qty int.
     *
     * @param qty the qty
     * @return the int
     */
    public static int ValidateQty(String qty)
    {
        if(qty.equals("") || !(qty.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }
}
