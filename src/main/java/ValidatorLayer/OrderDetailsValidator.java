package ValidatorLayer;

import Model.orderdetails;

/**
 * The type Order details validator.
 */
public class OrderDetailsValidator implements Validator<orderdetails> {
    /**
     * Validate street int.
     *
     * @param street the street
     * @return the int
     */
    public static int ValidateStreet(String street)
    {
        if(street.equals("") || !(street.matches("^(\\b\\D+\\b)?\\s*(\\b.*?\\d.*?\\b)\\s*(\\b\\D+\\b)?$")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate city int.
     *
     * @param city the city
     * @return the int
     */
    public static int ValidateCity(String city)
    {
        if(city.equals("") || !(city.matches("^(\\b\\D+\\b)?\\s*")))
        {
            return 0;
        }
        return  1;
    }

    @Override
    public boolean validate(orderdetails orderdetails) {

        if(ValidateStreet(orderdetails.getStreet())==0)
            return  false;
        return true;
    }

    /**
     * Validate id int.
     *
     * @param id the id
     * @return the int
     */
    public static int ValidateID(String id)
    {
        if(id.equals("") || !(id.matches("[0-9]+")))
        {
            return 0;
        }
        return  1;
    }
}
