package ValidatorLayer;

import Model.client;

/**
 * The type Client validator.
 */
public class ClientValidator implements Validator<client> {
    /**
     * Validate client name int.
     *
     * @param clientName the client name
     * @return the int
     */
    public static int ValidateClientName(String clientName)
    {
        if(clientName.equals("") || !(clientName.matches("^[^\\s]+( [^\\s]+)+$")))
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate client phone int.
     *
     * @param clientPhone the client phone
     * @return the int
     */
    public static int ValidateClientPhone(String clientPhone)
    {
        if(clientPhone.equals("") || !(clientPhone.matches("[0-9]+")) || clientPhone.length()!=10)
        {
            return 0;
        }
        return  1;
    }

    /**
     * Validate client email int.
     *
     * @param clientEmail the client email
     * @return the int
     */
    public static int ValidateClientEmail(String clientEmail)
    {
        if(clientEmail.equals("") || !(clientEmail.matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)")))
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

    @Override
    public boolean validate(client client) {
        if(ValidateClientPhone(client.getPhone())==0){
            return  false;
        }
        if(ValidateClientName(client.getName())==0) {
            return false;
        }
        if(ValidateClientEmail(client.getEmail())==0) {
            return false;
        }
        if(ValidateClientID(String.valueOf(client.getClientID()))==0)
            return false;
        return true;
    }
}
