package ValidatorLayer;

import Model.product;

/**
 * The type Product validator.
 */
public class ProductValidator implements Validator<product> {

    /**
     * Validate product name int.
     *
     * @param productName the product name
     * @return the int
     */
    public static int ValidateProductName(String productName)
    {
        if(productName.equals("") || !(productName.matches("^[^\\s]+( [^\\s]+)+$")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate product stock int.
     *
     * @param stock the stock
     * @return the int
     */
    public static int ValidateProductStock(String stock)
    {
        if(stock.equals("") || !(stock.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate product price int.
     *
     * @param price the price
     * @return the int
     */
    public static int ValidateProductPrice(String price)
    {
        if(price.equals("") || !(price.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate product id int.
     *
     * @param productId the product id
     * @return the int
     */
    public static int ValidateProductID(String productId)
    {
        if(productId.equals("") || !(productId.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }

    @Override
    public boolean validate(product product) {
        if(ValidateProductName(product.getName())==0)
            return  false;
        if(ValidateProductStock(String.valueOf(product.getStock()))==0)
            return false;
        if(ValidateProductPrice(String.valueOf(product.getPrice()))==0)
            return false;
        if(ValidateProductID(String.valueOf(product.getProductID()))==0)
            return false;
        return true;
    }
}
