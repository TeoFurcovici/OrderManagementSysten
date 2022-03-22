package Model;

/**
 * The type Client.
 */
public class client {
    private int client_id;
    private String firstName;
    private String email;
    private String phoneNumber;

    /**
     * Instantiates a new Client.
     *
     * @param clientID the client id
     * @param name     the name
     * @param email    the email
     * @param phone    the phone
     */
    public client(int clientID, String name, String email, String phone) {
        this.client_id = clientID;
        this.firstName = name;
        this.email = email;
        this.phoneNumber = phone;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return firstName;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.firstName = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phoneNumber;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phoneNumber = phone;
    }
}
