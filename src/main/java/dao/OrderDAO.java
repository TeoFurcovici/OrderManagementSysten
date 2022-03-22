package dao;

import Model.client;
import Model.order;
import Model.product;
import Presentation.UI;
import ValidatorLayer.ClientValidator;
import ValidatorLayer.OrderValidator;
import connection.ConnectionFactory;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * The type Order dao.
 */
public class OrderDAO extends AbstractDAO<order> {
    private Connection connectionO;
    private UI uiOrder;
    private Statement statementO;

    /**
     * Instantiates a new Order dao.
     *
     * @param connectionO the connection o
     * @param ui          the ui
     * @throws SQLException the sql exception
     */
    public OrderDAO(Connection connectionO, UI ui) throws SQLException {
        this.connectionO = connectionO;
        this.uiOrder = ui;
        this.statementO = connectionO.createStatement();

    }

    /**
     * Gets orders.
     *
     * @return the orders
     * @throws SQLException the sql exception
     */
    public Vector<order> getOrders() throws SQLException {
        ResultSet rs = statementO.executeQuery("SELECT * FROM pt3_database.order");

        Vector<order> orders = new Vector<>();
        while (rs.next()) {
            order newOrder = new order(rs.getInt("order_id"), rs.getInt("client_id"), rs.getInt("product_id"),
                    rs.getInt("qty"));
            orders.add(newOrder);
        }
        ConnectionFactory.close(rs);
        return orders;
    }

    /**
     * Sets order table for list.
     *
     * @param orderTable the order table
     * @return the order table for list
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public JTable setOrderTableForList(JTable orderTable) throws SQLException, IllegalAccessException {

        ResultSet rs = statementO.executeQuery("SELECT * FROM pt3_database.order");

        Vector<order> orders = new Vector<>();
        while (rs.next()) {
            order newOrder = new order(rs.getInt("order_id"), rs.getInt("client_id"), rs.getInt("product_id"),
                    rs.getInt("qty"));
            orders.add(newOrder);
        }
        ConnectionFactory.close(rs);
        orderTable = create(orders);
        return orderTable;
    }

    /**
     * Insert order.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void insertOrder() throws SQLException, IllegalAccessException {
        String orderID = uiOrder.getOrderIdText();
        String clientID = uiOrder.getIDText();
        String productID = uiOrder.getIdProductText();
        String qtyOrder = uiOrder.getQtyOrderText();
        int intOrderID = 0;
        int intClientId = 0;
        int intProductID = 0;
        int intQtyOrder = 0;
        boolean allValidate = true;
        if (OrderValidator.ValidateClientID(clientID) == 1)
            intClientId = Integer.parseInt(clientID);
        else
            allValidate = false;
        if (OrderValidator.ValidateOrderID(orderID) == 1)
            intOrderID = Integer.parseInt(orderID);
        else
            allValidate = false;
        if (OrderValidator.ValidateProductID(productID) == 1)
            intProductID = Integer.parseInt(productID);
        else
            allValidate = false;
        if (OrderValidator.ValidateQty(qtyOrder) == 1)
            intQtyOrder = Integer.parseInt(qtyOrder);
        else
            allValidate = false;
        if (allValidate) {
            insertIntoTable(new order(intOrderID, intClientId, intProductID, intQtyOrder));
        } else
            JOptionPane.showMessageDialog(null, "Some data are invalid!");
    }

    /**
     * Delete order.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void deleteOrder() throws SQLException, IllegalAccessException {
        String orderID = uiOrder.getOrderIdText();
        int intOrderId = 0;
        order searchedOrder = null;
        Vector<order> orders = getOrders();
        if (ClientValidator.ValidateClientID(orderID) == 1) {
            intOrderId = Integer.parseInt(orderID);
            for (order currOrder : orders) {
                if (currOrder.getOrderID() == intOrderId)
                    searchedOrder = currOrder;
            }
            deleteFromTable(searchedOrder);
        }
    }

    /**
     * Update order.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void updateOrder() throws SQLException, IllegalAccessException {
        String orderID = uiOrder.getOrderIdText();
        String clientID = uiOrder.getIDText();
        String productID = uiOrder.getIdProductText();
        String qtyOrder = uiOrder.getQtyOrderText();
        int intOrderId = 0;
        int intClientId = 0;
        int intProductId = 0;
        int intQty = 0;
        order searchedOrder = null;
        boolean allValidate = true;
        Vector<order> orders = getOrders();
        if (OrderValidator.ValidateClientID(clientID) == 1)
            intClientId = Integer.parseInt(clientID);
        else
            allValidate = false;
        if (OrderValidator.ValidateOrderID(orderID) == 1)
            intOrderId = Integer.parseInt(orderID);
        else
            allValidate = false;
        if (OrderValidator.ValidateProductID(productID) == 1)
            intProductId = Integer.parseInt(productID);
        else
            allValidate = false;
        if (OrderValidator.ValidateQty(qtyOrder) == 1)
            intQty = Integer.parseInt(qtyOrder);
        else
            allValidate = false;
        if (allValidate) {
            for (order currOrder : orders) {
                if (currOrder.getOrderID() == intOrderId)
                    searchedOrder = currOrder;
            }
        }
        searchedOrder.setOrderID(intOrderId);
        searchedOrder.setClientID(intClientId);
        searchedOrder.setProductID(intProductId);
        searchedOrder.setQty(intQty);
        updateTable(searchedOrder);
    }

    /**
     * Create file.
     */
    public void createFile() {
        try {
            File myFile = new File("bill.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created:" + myFile.getName());
            } else
                System.out.println("File exists!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Write file.
     *
     * @param s the s
     */
    public void writeFile(String s) {
        try {
            FileWriter fileWriter = new FileWriter("bill.txt");
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Something happened");
            e.printStackTrace();
        }
    }

    /**
     * Generate bill.
     *
     * @throws SQLException the sql exception
     */
    public void generateBill() throws SQLException {
        StringBuilder sb = new StringBuilder();
        Vector<order> orderArrayList;
        orderArrayList = getOrders();
        createFile();
        for (order currOrder : orderArrayList) {
            sb.append("Order: " +currOrder.getOrderID() + "\n");
            int clientId = currOrder.getClientID();
            int productId = currOrder.getProductID();
            ClientDAO clientDAO = new ClientDAO(connectionO, uiOrder);
            client searchedClient = null;
            Vector<client> clients;
            clients = clientDAO.getClients();
            for (client currClient : clients) {
                if (currClient.getClientID() == clientId)
                    searchedClient = currClient;
            }
            if(searchedClient!=null)
                    sb.append("Client Name: "+searchedClient.getName()+"\n");
            ProductDAO productDAO=new ProductDAO(connectionO,uiOrder);
            product searchedProduct=null;
            Vector<product> products;
            products=productDAO.getProducts();
            for (product currProduct : products) {
                if (currProduct.getProductID() == productId)
                    searchedProduct = currProduct;
            }
            if(searchedProduct!=null)
                sb.append("Product Name: "+searchedProduct.getName()+"\n");
            sb.append("Quantity : " + currOrder.getQty() + "\n");
            sb.append("Price : " + searchedProduct.getPrice()+"\n\n");
        }
        System.out.println(sb.toString());
        writeFile(sb.toString());
    }
}

