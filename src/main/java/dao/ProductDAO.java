package dao;

import Model.product;
import Presentation.UI;
import ValidatorLayer.ClientValidator;
import ValidatorLayer.ProductValidator;
import connection.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * The type Product dao.
 */
public class ProductDAO extends AbstractDAO<product> {
    private Connection connectionP;
    private UI uiProduct;
    private Statement statementP;

    /**
     * Instantiates a new Product dao.
     *
     * @param connectionP the connection p
     * @param ui          the ui
     * @throws SQLException the sql exception
     */
    public ProductDAO(Connection connectionP, UI ui) throws SQLException {
        this.connectionP = connectionP;
        this.uiProduct = ui;
        this.statementP = connectionP.createStatement();

    }

    /**
     * Gets products.
     *
     * @return the products
     * @throws SQLException the sql exception
     */
    public Vector<product> getProducts() throws SQLException {
        ResultSet rs = statementP.executeQuery("SELECT * FROM pt3_database.product");

        Vector<product> products = new Vector<>();
        while (rs.next()) {
            product newProduct = new product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("price"),
                    rs.getInt("stock"));
            products.add(newProduct);
        }
        ConnectionFactory.close(rs);
        return products;
    }

    /**
     * Sets product table for list.
     *
     * @param productTable the product table
     * @return the product table for list
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public JTable setProductTableForList(JTable productTable) throws SQLException, IllegalAccessException {

        ResultSet rs = statementP.executeQuery("SELECT * FROM pt3_database.product");

        Vector<product> products = new Vector<>();
        while (rs.next()) {
            product newProduct = new product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("price"),
                    rs.getInt("stock"));
            products.add(newProduct);
        }
        ConnectionFactory.close(rs);
        productTable = create(products);
        return productTable;
    }

    /**
     * Insert product.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void insertProduct() throws SQLException, IllegalAccessException {
        String productId = uiProduct.getIdProductText();
        String productName = uiProduct.getNameProductText();
        String price = uiProduct.getPriceProductText();
        String stock = uiProduct.getStockProductText();
        int intProductId = 0;
        int intPrice = 0;
        int intStock = 0;
        boolean allValid = true;
        ProductValidator productValidator=new ProductValidator();
        if (ProductValidator.ValidateProductID(productId) == 1)
            intProductId = Integer.parseInt(productId);
        else
            allValid = false;
        if (ProductValidator.ValidateProductPrice(price) == 1)
            intPrice = Integer.parseInt(price);
        else
            allValid = false;
        if (ProductValidator.ValidateProductStock(stock) == 1)
            intStock = Integer.parseInt(stock);
        else
            allValid = false;
       // if (productValidator.validate(new product(intProductId,productName,intPrice,intStock))) {
        if (allValid) {
            insertIntoTable(new product(intProductId, productName, intPrice, intStock));
        } else
            JOptionPane.showMessageDialog(null, "Some data are invalid!");
    }

    /**
     * Delete product.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void deleteProduct() throws SQLException, IllegalAccessException {
        String productId = uiProduct.getIdProductText();
        int intProductId = 0;
        product searchedProduct = null;
        Vector<product> products = getProducts();
        if (ClientValidator.ValidateClientID(productId) == 1) {
            intProductId = Integer.parseInt(productId);
            for (product currProduct : products) {
                if (currProduct.getProductID() == intProductId)
                    searchedProduct = currProduct;
            }
            deleteFromTable(searchedProduct);
        }
    }

    /**
     * Update product.
     *
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void updateProduct() throws SQLException, IllegalAccessException {
        String productId = uiProduct.getIdProductText();
        String productName = uiProduct.getNameProductText();
        String price = uiProduct.getPriceProductText();
        String stock = uiProduct.getStockProductText();
        int intProductId = 0;
        int intPrice = 0;
        int intStock = 0;
        boolean allValid = true;
        product searchedProduct = null;
        ProductValidator productValidator = new ProductValidator();
        Vector<product> products = getProducts();
        if (ProductValidator.ValidateProductID(productId) == 1)
            intProductId = Integer.parseInt(productId);
        else
            allValid = false;
        if (ProductValidator.ValidateProductStock(stock) == 1)
            intStock = Integer.parseInt(stock);
        else
            allValid = false;
        if (ProductValidator.ValidateProductPrice(price) == 1)
            intPrice = Integer.parseInt(price);
        else
            allValid = false;
       // if (productValidator.validate(new product(intProductId, productName, intPrice, intStock))) {
            if (allValid)
                for (product currProduct : products) {
                    if (currProduct.getProductID() == intProductId)
                        searchedProduct = currProduct;
                }
            searchedProduct.setProduct_id(intProductId);
            searchedProduct.setName(productName);
            searchedProduct.setPrice(intPrice);
            searchedProduct.setStock(intStock);
            updateTable(searchedProduct);
        //}
    }
}

