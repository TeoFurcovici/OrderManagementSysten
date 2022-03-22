package dao;

import Model.client;
import Presentation.UI;
import ValidatorLayer.ClientValidator;
import connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * The type Client dao.
 */
public class ClientDAO extends AbstractDAO<client> {
    private Connection connectionC;
    private UI uiClient;
    private Statement statementC;

    /**
     * Instantiates a new Client dao.
     *
     * @param connectionC the connection c
     * @param ui          the ui
     * @throws SQLException the sql exception
     */
    public ClientDAO(Connection connectionC, UI ui) throws SQLException {
        this.connectionC = connectionC;
        this.uiClient = ui;
        this.statementC = connectionC.createStatement();

    }

    /**
     * Gets clients.
     *
     * @return the clients
     * @throws SQLException the sql exception
     */
    public Vector<client> getClients() throws SQLException {
        ResultSet rs = statementC.executeQuery("SELECT * FROM pt3_database.client");

        Vector<client> clients = new Vector<>();
        while (rs.next()) {
            client newClient = new client(rs.getInt("client_id"), rs.getString("firstName"), rs.getString("email"),
                    rs.getString("phoneNumber"));
            clients.add(newClient);
        }
        ConnectionFactory.close(rs);
        return clients;
    }

    /**
     * Sets c lient table for list.
     *
     * @param clientTable the client table
     * @return the c lient table for list
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public JTable setCLientTableForList(JTable clientTable) throws SQLException, IllegalAccessException {

        ResultSet rs = statementC.executeQuery("SELECT * FROM pt3_database.client");

        Vector<client> clients = new Vector<>();
        while (rs.next()) {
            client newClient = new client(rs.getInt("client_id"), rs.getString("firstName"), rs.getString("email"),
                    rs.getString("phoneNumber"));
            clients.add(newClient);
        }
        ConnectionFactory.close(rs);
        clientTable = create(clients);
        return clientTable;
    }

    /**
     * Insert client.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void insertClient() throws SQLException, IllegalAccessException {
        String clientID = uiClient.getIDText();
        String clientName = uiClient.getNameText();
        String clientEmail = uiClient.getEmailText();
        String clientPhone = uiClient.getPhoneText();
        int intClientId = 0;
        ClientValidator clientValidator = new ClientValidator();
        if (ClientValidator.ValidateClientID(clientID) == 1)
            intClientId = Integer.parseInt(clientID);
        if (clientValidator.validate(new client(intClientId, clientName, clientEmail, clientPhone))) {
            insertIntoTable(new client(intClientId, clientName, clientEmail, clientPhone));
        } else
            JOptionPane.showMessageDialog(null, "Some data are invalid!");
    }

    /**
     * Delete client.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void deleteClient() throws SQLException, IllegalAccessException {
        String clientID = uiClient.getIDText();
        int intClientId = 0;
        client searchedClient = null;
        Vector<client> clients = getClients();
        if (ClientValidator.ValidateClientID(clientID) == 1) {
            intClientId = Integer.parseInt(clientID);
            for (client currClient : clients) {
                if (currClient.getClientID() == intClientId)
                    searchedClient = currClient;
            }
        }
        deleteFromTable(searchedClient);
    }

    /**
     * Update client.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void updateClient() throws SQLException, IllegalAccessException {
        String clientID = uiClient.getIDText();
        String clientName = uiClient.getNameText();
        String clientEmail = uiClient.getEmailText();
        String clientPhone = uiClient.getPhoneText();
        int intClientId = 0;
        client searchedClient = null;
        Vector<client> clients = getClients();
        ClientValidator clientValidator = new ClientValidator();
        if (ClientValidator.ValidateClientID(clientID) == 1)
            intClientId = Integer.parseInt(clientID);
        if (clientValidator.validate(new client(intClientId, clientName, clientEmail, clientPhone))) {
            for (client currClient : clients) {
                if (currClient.getClientID() == intClientId)
                    searchedClient = currClient;
            }
            searchedClient.setClientID(intClientId);
            searchedClient.setEmail(clientEmail);
            searchedClient.setName(clientName);
            searchedClient.setPhone(clientPhone);
            updateTable(searchedClient);
        }
    }
}

