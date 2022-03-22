package dao;

import Model.orderdetails;
import Presentation.UI;
import ValidatorLayer.OrderDetailsValidator;
import connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * The type Order details dao.
 */
public class OrderDetailsDAO extends AbstractDAO<orderdetails> {
    private Connection connectionOd;
    private UI uiOrderDetails;
    private Statement statementOd;

    /**
     * Instantiates a new Order details dao.
     *
     * @param connectionOd the connection od
     * @param ui           the ui
     * @throws SQLException the sql exception
     */
    public OrderDetailsDAO(Connection connectionOd, UI ui) throws SQLException {
        this.connectionOd = connectionOd;
        this.uiOrderDetails = ui;
        this.statementOd = connectionOd.createStatement();

    }

    /**
     * Gets order details.
     *
     * @return the order details
     * @throws SQLException the sql exception
     */
    public Vector<orderdetails> getOrderDetails() throws SQLException {
        ResultSet rs = statementOd.executeQuery("SELECT * FROM pt3_database.orderdetails");

        Vector<orderdetails> orderdetails = new Vector<>();
        while (rs.next()) {
            orderdetails newOrderDetail = new orderdetails(rs.getInt("orderDetails_id"), rs.getInt("orderID"), rs.getString("city"),
                    rs.getString("street"));
            orderdetails.add(newOrderDetail);
        }
        ConnectionFactory.close(rs);
        return orderdetails;
    }

    /**
     * Sets order details table for list.
     *
     * @param orderDetailsTable the order details table
     * @return the order details table for list
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public JTable setOrderDetailsTableForList(JTable orderDetailsTable) throws SQLException, IllegalAccessException {

        ResultSet rs = statementOd.executeQuery("SELECT * FROM pt3_database.orderdetails");

        Vector<orderdetails> orderdetails = new Vector<>();
        while (rs.next()) {
            orderdetails newOrderDetail = new orderdetails(rs.getInt("orderDetails_id"), rs.getInt("orderID"), rs.getString("city"),
                    rs.getString("street"));
            orderdetails.add(newOrderDetail);
        }
        ConnectionFactory.close(rs);
        orderDetailsTable = create(orderdetails);
        return orderDetailsTable;
    }

    /**
     * Insert order detail.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void insertOrderDetail() throws SQLException, IllegalAccessException {
        String orderDetails_id = uiOrderDetails.getIdOrderDetailsText();
        String orderID = uiOrderDetails.getOrderIdText();
        String city = uiOrderDetails.getCityDetailsText();
        String street = uiOrderDetails.getStreetDetailsText();
        int intOrderDetailsId = 0;
        int intOrderId = 0;
        boolean allValid = true;
        if (OrderDetailsValidator.ValidateID(orderDetails_id) == 1)
            intOrderDetailsId = Integer.parseInt(orderDetails_id);
        else
            allValid = false;
        if (OrderDetailsValidator.ValidateID(orderID) == 1)
            intOrderId = Integer.parseInt(orderID);
        else
            allValid = false;
       if(OrderDetailsValidator.ValidateStreet(street)==0)
                allValid=false;
       if(OrderDetailsValidator.ValidateCity(city)==0)
            allValid=false;
        if (allValid) {
                insertIntoTable(new orderdetails(intOrderDetailsId, intOrderId, city, street));
            }
        else
            JOptionPane.showMessageDialog(null, "Some data are invalid!");
    }

    /**
     * Delete order detail.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void deleteOrderDetail() throws SQLException, IllegalAccessException {
        String orderDetails_id = uiOrderDetails.getIdOrderDetailsText();
        int intOrderDetailsId = 0;
        orderdetails searchedOrderDetail = null;
        Vector<orderdetails> orderdetailsVector = getOrderDetails();
        if (OrderDetailsValidator.ValidateID(orderDetails_id) == 1) {
            intOrderDetailsId = Integer.parseInt(orderDetails_id);
            for (orderdetails currOrderDetail : orderdetailsVector) {
                if (currOrderDetail.getOrderDetailsID() == intOrderDetailsId)
                    searchedOrderDetail = currOrderDetail;
            }
        }
        deleteFromTable(searchedOrderDetail);
    }

    /**
     * Update order detail.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void updateOrderDetail() throws SQLException, IllegalAccessException {
        String orderDetails_id = uiOrderDetails.getIdOrderDetailsText();
        String orderID = uiOrderDetails.getOrderIdText();
        String city = uiOrderDetails.getCityDetailsText();
        String street = uiOrderDetails.getStreetDetailsText();
        int intOrderDetailsId = 0;
        int intOrderId = 0;
        boolean allValid = true;
        orderdetails searchedOrderDetail = null;
        OrderDetailsValidator orderDetailsValidator = new OrderDetailsValidator();
        Vector<orderdetails> orderdetailsVector = getOrderDetails();
        if (OrderDetailsValidator.ValidateID(orderDetails_id) == 1)
            intOrderDetailsId = Integer.parseInt(orderDetails_id);
        else
            allValid = false;
        if (OrderDetailsValidator.ValidateID(orderID) == 1)
            intOrderId = Integer.parseInt(orderID);
        else
            allValid = false;
        if(OrderDetailsValidator.ValidateStreet(street)==0)
            allValid=false;
        if(OrderDetailsValidator.ValidateCity(city)==0)
            allValid=false;
        if (orderDetailsValidator.validate(new orderdetails(intOrderDetailsId, intOrderId, city, street))) {
            if (allValid)
                for (orderdetails currOrderDetail : orderdetailsVector) {
                    if (currOrderDetail.getOrderDetailsID() == intOrderDetailsId)
                        searchedOrderDetail = currOrderDetail;
                }
            searchedOrderDetail.setOrderDetails_id(intOrderDetailsId);
            searchedOrderDetail.setOrderID(intOrderId);
            searchedOrderDetail.setCity(city);
            searchedOrderDetail.setStreet(street);
            updateTable(searchedOrderDetail);
        }
    }

}
