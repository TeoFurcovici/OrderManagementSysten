package Presentation;

import Model.order;
import connection.ConnectionFactory;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.OrderDetailsDAO;
import dao.ProductDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;


/**
 * The type Ui.
 */
public class UI extends JFrame {
    private JButton clientTableButton=new JButton("Client Table");
    private JButton orderTableButton=new JButton("Order Table");
    private JButton orderDetailsTableButton=new JButton("Order Details");
    private JButton productTableButton=new JButton("Product Table");
    private JButton updateButtonClient=new JButton("Update data");
    private JButton updateButtonOrder=new JButton("Update data");
    private JButton updateButtonProduct=new JButton("Update data");
    private JButton updateButtonOD=new JButton("Update data");
    private JButton insertDataButtonClient=new JButton("Insert data");
    private JButton insertDataButtonOrder=new JButton("Insert data");
    private JButton insertDataButtonProduct=new JButton("Insert data");
    private JButton insertDataButtonOD=new JButton("Insert data");
    private JButton deleteDataButtonClient=new JButton("Delete Data");
    private JButton deleteDataButtonOrder=new JButton("Delete Data");
    private JButton deleteDataButtonProduct=new JButton("Delete Data");
    private JButton deleteDataButtonOD=new JButton("Delete Data");
    private JButton showModificationButtonClient=new JButton("Show modifications");
    private JButton showModificationButtonOrder=new JButton("Show modifications");
    private JButton showModificationButtonProduct=new JButton("Show modifications");
    private JButton showModificationButtonOD=new JButton("Show modifications");
    private JButton generateBillButton=new JButton("Generate Bill");
    private JButton backButtonClient=new JButton("Go Back");
    private JButton backButtonOrder=new JButton("Go Back");
    private JButton backButtonProduct=new JButton("Go Back");
    private JButton backButtonOD=new JButton("Go Back");

    public void setIdProductText(JTextField idProductText) {
        IdProductText = idProductText;
    }

    public void setBackButtonClient(JButton backButtonClient) {
        this.backButtonClient = backButtonClient;
    }

    public void setOrderIdText(JTextField orderIdText) {
        this.orderIdText = orderIdText;
    }

    public void setQtyOrderText(JTextField qtyOrderText) {
        this.qtyOrderText = qtyOrderText;
    }

    public void setIdOrderDetailsText(JTextField idOrderDetailsText) {
        this.idOrderDetailsText = idOrderDetailsText;
    }

    private JLabel introLabel=new JLabel("Welcome to Database Management Application!");
    /**
     * The Id label.
     */
    public JLabel IDLabel=new JLabel("Client ID:");
    /**
     * The Name label.
     */
    public JLabel nameLabel=new JLabel("Name:");
    /**
     * The Email label.
     */
    public JLabel emailLabel=new JLabel("Email:");
    /**
     * The Phone label.
     */
    public JLabel phoneLabel=new JLabel("Phone:");
    /**
     * The Id product label.
     */
    public JLabel IdProductLabel=new JLabel("Product ID:");
    /**
     * The Name product label.
     */
    public JLabel nameProductLabel=new JLabel("Name:");
    /**
     * The Price product label.
     */
    public JLabel priceProductLabel=new JLabel("Price:");
    /**
     * The Stock product label.
     */
    public JLabel stockProductLabel=new JLabel("Stock:");
    /**
     * The Order id.
     */
    public JLabel orderID=new JLabel("Order ID:");
    /**
     * The Qty label.
     */
    public JLabel qtyLabel=new JLabel("Quantity:");
    /**
     * The Id order details label.
     */
    public JLabel idOrderDetailsLabel=new JLabel("Order Details ID:");
    /**
     * The City details label.
     */
    public JLabel cityDetailsLabel=new JLabel("City:");
    /**
     * The Street details label.
     */
    public JLabel streetDetailsLabel=new JLabel("Street:");
    /**
     * The Id text.
     */
    public JTextField IDText=new JTextField();
    /**
     * The Name text.
     */
    public JTextField nameText=new JTextField();
    /**
     * The Email text.
     */
    public JTextField emailText=new JTextField();
    /**
     * The Phone text.
     */
    public JTextField phoneText=new JTextField();

    /**
     * The Id product text.
     */
    public JTextField IdProductText=new JTextField();
    /**
     * The Name product text.
     */
    public JTextField nameProductText=new JTextField();
    /**
     * The Price product text.
     */
    public JTextField priceProductText=new JTextField();
    /**
     * The Stock product text.
     */
    public JTextField stockProductText=new JTextField();

    /**
     * The Order id text.
     */
    public JTextField orderIdText=new JTextField();
    /**
     * The Qty order text.
     */
    public JTextField qtyOrderText=new JTextField();

    /**
     * The Id order details text.
     */
    public JTextField idOrderDetailsText=new JTextField();
    /**
     * The City details text.
     */
    public JTextField cityDetailsText=new JTextField();
    /**
     * The Street details text.
     */
    public JTextField streetDetailsText=new JTextField();
    /**
     * The Connection.
     */
    Connection connection=ConnectionFactory.getConnection();
    /**
     * The Client dao.
     */
    ClientDAO clientDAO;
    /**
     * The Order dao.
     */
    OrderDAO orderDAO;
    /**
     * The Product dao.
     */
    ProductDAO productDAO;
    /**
     * The Order details dao.
     */
    OrderDetailsDAO orderDetailsDAO;

    /**
     * Gets id text.
     *
     * @return the id text
     */
    public String getIDText() {
        return IDText.getText();
    }

    /**
     * Gets name text.
     *
     * @return the name text
     */
    public String getNameText() {
        return nameText.getText();
    }


    /**
     * Gets email text.
     *
     * @return the email text
     */
    public String getEmailText() {
        return emailText.getText();
    }


    /**
     * Gets phone text.
     *
     * @return the phone text
     */
    public String getPhoneText() {
        return phoneText.getText();
    }


    /**
     * Gets id product text.
     *
     * @return the id product text
     */
    public String getIdProductText() {
        return IdProductText.getText();
    }


    /**
     * Gets name product text.
     *
     * @return the name product text
     */
    public String getNameProductText() {
        return nameProductText.getText();
    }


    /**
     * Gets price product text.
     *
     * @return the price product text
     */
    public String getPriceProductText() {
        return priceProductText.getText();
    }

    /**
     * Gets stock product text.
     *
     * @return the stock product text
     */
    public String getStockProductText() {
        return stockProductText.getText();
    }

    /**
     * Gets order id text.
     *
     * @return the order id text
     */
    public String getOrderIdText() {
        return orderIdText.getText();
    }


    /**
     * Gets qty order text.
     *
     * @return the qty order text
     */
    public String getQtyOrderText() {
        return qtyOrderText.getText();
    }


    /**
     * Gets id order details text.
     *
     * @return the id order details text
     */
    public String getIdOrderDetailsText() {
        return idOrderDetailsText.getText();
    }


    /**
     * Gets city details text.
     *
     * @return the city details text
     */
    public String getCityDetailsText() {
        return cityDetailsText.getText();
    }


    /**
     * Gets street details text.
     *
     * @return the street details text
     */
    public String getStreetDetailsText() {
        return streetDetailsText.getText();
    }

    /**
     * The Frame 1.
     */
    JFrame frame1 = new JFrame();
    /**
     * The Frame 2.
     */
    JFrame frame2 = new JFrame();
    /**
     * The Frame 3.
     */
    JFrame frame3 = new JFrame();
    /**
     * The Frame 4.
     */
    JFrame frame4 = new JFrame();
    /**
     * The Second panel.
     */
    JPanel secondPanel = new JPanel();
    /**
     * The Third panel.
     */
    JPanel thirdPanel = new JPanel();
    /**
     * The Fourth panel.
     */
    JPanel fourthPanel = new JPanel();
    /**
     * The Fifth panel.
     */
    JPanel fifthPanel = new JPanel();

    /**
     * Instantiates a new Ui.
     *
     * @throws HeadlessException the headless exception
     * @throws SQLException      the sql exception
     * @throws IOException       the io exception
     */
    public UI() throws HeadlessException, SQLException, IOException {
        JFrame frame = new JFrame();
        frame.setSize(550, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel firstPanel = new JPanel();
        firstPanel.setBackground(Color.decode("#ccd9ff"));
        firstPanel.setLayout(null);
        frame.add(firstPanel);
        frame1.setSize(800, 400);
        frame1.setTitle("Client");
        frame2.setSize(800, 420);
        frame2.setTitle("Orders");
        frame3.setSize(800, 400);
        frame3.setTitle("Order Details");
        frame4.setSize(800, 400);
        frame4.setTitle("Products");

        this.clientButtonActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                secondPanel.setBackground(Color.decode("#ccd9ff"));
                secondPanel.setLayout(null);
                frame1.add(secondPanel);
                IDLabel.setBounds(7,7,70,30);
                IDText.setBounds(100,7,100,25);
                nameLabel.setBounds(7,47,70,25);
                nameText.setBounds(100,47,100,25);
                emailLabel.setBounds(7,87,70,25);
                emailText.setBounds(100,87,100,25);
                phoneLabel.setBounds(7,127,70,25);
                phoneText.setBounds(100,127,100,25);
                updateButtonClient.setBounds(7,187,120,25);
                insertDataButtonClient.setBounds(7,227,120,25);
                deleteDataButtonClient.setBounds(7,267,120,25);
                showModificationButtonClient.setBounds(7,307,165,25);
                backButtonClient.setBounds(600,307,165,25);

                IDLabel.setFont(new Font("Serif",Font.BOLD,15));
                nameLabel.setFont(new Font("Serif",Font.BOLD,15));
                emailLabel.setFont(new Font("Serif",Font.BOLD,15));
                phoneLabel.setFont(new Font("Serif",Font.BOLD,15));
                updateButtonClient.setFont(new Font("Serif",Font.BOLD,15));
                insertDataButtonClient.setFont(new Font("Serif",Font.BOLD,15));
                deleteDataButtonClient.setFont(new Font("Serif",Font.BOLD,15));
                showModificationButtonClient.setFont(new Font("Serif",Font.BOLD,15));
                backButtonClient.setFont(new Font("Serif",Font.BOLD,15));

                secondPanel.add(IDLabel);
                secondPanel.add(IDText);
                secondPanel.add(nameLabel);
                secondPanel.add(nameText);
                secondPanel.add(emailLabel);
                secondPanel.add(emailText);
                secondPanel.add(phoneLabel);
                secondPanel.add(phoneText);
                secondPanel.add(updateButtonClient);
                secondPanel.add(insertDataButtonClient);
                secondPanel.add(deleteDataButtonClient);
                secondPanel.add(showModificationButtonClient);
                secondPanel.add(backButtonClient);
               setShowModificationButtonActionListenerClient (new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       try {
                           ClientInterface(connection);
                           JScrollPane myScrollPane = new JScrollPane();
                           myScrollPane.setBounds(250, 20, 500, 250);
                           JTable clientTable = new JTable();
                           clientTable= clientDAO.setCLientTableForList(clientTable);
                           clientTable.setEnabled(true);
                           clientTable.setVisible(true);
                           myScrollPane.setViewportView(clientTable);
                           secondPanel.add(myScrollPane);
                       } catch (SQLException | IllegalAccessException exception) {
                           exception.printStackTrace();
                       }
                   }
               });
               insertButtonActionListenerClient(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       try {
                           ClientInterface(connection);
                           clientDAO.insertClient();
                           JOptionPane.showMessageDialog(null,"The data was successfully inserted!");
                       } catch (SQLException | IllegalAccessException exception) {
                           exception.printStackTrace();
                       }
                   }
               });
               deleteButtonActionListenerClient(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       try {
                           ClientInterface(connection);
                           clientDAO.deleteClient();
                           JOptionPane.showMessageDialog(null,"The data was successfully deleted!");
                       } catch (SQLException | IllegalAccessException exception) {
                           exception.printStackTrace();
                       }
                   }
               });
               updateButtonActionListenerClient(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       try {
                           ClientInterface(connection);
                           clientDAO.updateClient();
                           JOptionPane.showMessageDialog(null,"The data was successfully updated!");
                       } catch (SQLException | IllegalAccessException exception) {
                           exception.printStackTrace();
                       }

                   }
               });
               backButtonActionListenerClient(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       frame1.setVisible(false);
                   }
               });
            }
        });
        this.orderButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame2.setVisible(true);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thirdPanel.setBackground(Color.decode("#ccd9ff"));
                thirdPanel.setLayout(null);
                frame2.add(thirdPanel);
                orderID.setBounds(7,7,70,30);
                orderIdText.setBounds(100,7,100,25);
                IDLabel.setBounds(7,47,70,25);
                IDText.setBounds(100,47,100,25);
                IdProductLabel.setBounds(7,87,80,25);
                IdProductText.setBounds(100,87,100,25);
                qtyLabel.setBounds(7,127,70,25);
                qtyOrderText.setBounds(100,127,100,25);
                updateButtonOrder.setBounds(7,187,120,25);
                insertDataButtonOrder.setBounds(7,227,120,25);
                deleteDataButtonOrder.setBounds(7,267,120,25);
                showModificationButtonOrder.setBounds(7,307,165,25);
                generateBillButton.setBounds(600,307,165,25);
                backButtonOrder.setBounds(600,347,165,25);

                orderID.setFont(new Font("Serif",Font.BOLD,15));
                IDLabel.setFont(new Font("Serif",Font.BOLD,15));
                IdProductLabel.setFont(new Font("Serif",Font.BOLD,15));
                qtyLabel.setFont(new Font("Serif",Font.BOLD,15));
                updateButtonOrder.setFont(new Font("Serif",Font.BOLD,15));
                insertDataButtonOrder.setFont(new Font("Serif",Font.BOLD,15));
                deleteDataButtonOrder.setFont(new Font("Serif",Font.BOLD,15));
                showModificationButtonOrder.setFont(new Font("Serif",Font.BOLD,15));
                generateBillButton.setFont(new Font("Serif",Font.BOLD,15));
                backButtonOrder.setFont(new Font("Serif",Font.BOLD,15));

                thirdPanel.add(orderID);
                thirdPanel.add(orderIdText);
                thirdPanel.add(IDLabel);
                thirdPanel.add(IDText);
                thirdPanel.add(IdProductLabel);
                thirdPanel.add(IdProductText);
                thirdPanel.add(qtyLabel);
                thirdPanel.add(qtyOrderText);
                thirdPanel.add(updateButtonOrder);
                thirdPanel.add(insertDataButtonOrder);
                thirdPanel.add(deleteDataButtonOrder);
                thirdPanel.add(showModificationButtonOrder);
                thirdPanel.add(generateBillButton);
                thirdPanel.add(backButtonOrder);

                setShowModificationButtonActionListenerOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderInterface(connection);
                            JScrollPane myScrollPane = new JScrollPane();
                            myScrollPane.setBounds(250, 20, 500, 250);
                            JTable orderTable = new JTable();
                            orderTable= orderDAO.setOrderTableForList(orderTable);
                            orderTable.setEnabled(true);
                            orderTable.setVisible(true);
                            myScrollPane.setViewportView(orderTable);
                            thirdPanel.add(myScrollPane);
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                insertButtonActionListenerOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderInterface(connection);
                            orderDAO.insertOrder();
                            JOptionPane.showMessageDialog(null,"The order was successfully inserted!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                deleteButtonActionListenerOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderInterface(connection);
                            orderDAO.deleteOrder();
                            JOptionPane.showMessageDialog(null,"The order was successfully deleted!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                updateButtonActionListenerOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderInterface(connection);
                            orderDAO.updateOrder();
                            JOptionPane.showMessageDialog(null,"The order was successfully updated!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                generateBillButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderInterface(connection);
                            orderDAO.generateBill();
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                backButtonActionListenerOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                    }
                });
            }
        });
        this.orderDetailsButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame3.setVisible(true);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fourthPanel.setBackground(Color.decode("#ccd9ff"));
                fourthPanel.setLayout(null);
                frame3.add(fourthPanel);
                idOrderDetailsLabel.setBounds(7,7,116,30);
                idOrderDetailsText.setBounds(127,7,100,25);
                orderID.setBounds(7,47,70,25);
                orderIdText.setBounds(100,47,100,25);
                cityDetailsLabel.setBounds(7,87,80,25);
                cityDetailsText.setBounds(100,87,100,25);
                streetDetailsLabel.setBounds(7,127,70,25);
                streetDetailsText.setBounds(100,127,100,25);
                updateButtonOD.setBounds(7,187,120,25);
                insertDataButtonOD.setBounds(7,227,120,25);
                deleteDataButtonOD.setBounds(7,267,120,25);
                showModificationButtonOD.setBounds(7,307,165,25);
                backButtonOD.setBounds(600,307,165,25);


                idOrderDetailsLabel.setFont(new Font("Serif",Font.BOLD,15));
                orderID.setFont(new Font("Serif",Font.BOLD,15));
                cityDetailsLabel.setFont(new Font("Serif",Font.BOLD,15));
                streetDetailsLabel.setFont(new Font("Serif",Font.BOLD,15));
                updateButtonOD.setFont(new Font("Serif",Font.BOLD,15));
                insertDataButtonOD.setFont(new Font("Serif",Font.BOLD,15));
                deleteDataButtonOD.setFont(new Font("Serif",Font.BOLD,15));
                showModificationButtonOD.setFont(new Font("Serif",Font.BOLD,15));
                backButtonOD.setFont(new Font("Serif",Font.BOLD,15));


                fourthPanel.add(idOrderDetailsLabel);
                fourthPanel.add(idOrderDetailsText);
                fourthPanel.add(orderID);
                fourthPanel.add(orderIdText);
                fourthPanel.add(cityDetailsLabel);
                fourthPanel.add(cityDetailsText);
                fourthPanel.add(streetDetailsLabel);
                fourthPanel.add(streetDetailsText);
                fourthPanel.add(updateButtonOD);
                fourthPanel.add(insertDataButtonOD);
                fourthPanel.add(deleteDataButtonOD);
                fourthPanel.add(showModificationButtonOD);
                fourthPanel.add(backButtonOD);
                setShowModificationButtonActionListenerOD (new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderDetailsInterface(connection);
                            JScrollPane myScrollPane = new JScrollPane();
                            myScrollPane.setBounds(250, 20, 500, 250);
                            JTable orderDetailsTable = new JTable();
                            orderDetailsTable= orderDetailsDAO.setOrderDetailsTableForList(orderDetailsTable);
                            orderDetailsTable.setEnabled(true);
                            orderDetailsTable.setVisible(true);
                            myScrollPane.setViewportView(orderDetailsTable);
                            fourthPanel.add(myScrollPane);
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                insertButtonActionListenerOD(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderDetailsInterface(connection);
                            orderDetailsDAO.insertOrderDetail();
                            JOptionPane.showMessageDialog(null,"The order detail was successfully inserted!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                deleteButtonActionListenerOD(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderDetailsInterface(connection);
                            orderDetailsDAO.deleteOrderDetail();
                            JOptionPane.showMessageDialog(null,"The order detail was successfully deleted!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                updateButtonActionListenerOD(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            OrderDetailsInterface(connection);
                            orderDetailsDAO.updateOrderDetail();
                            JOptionPane.showMessageDialog(null,"The order detail was successfully updated!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                backButtonActionListenerOD(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame3.setVisible(false);
                    }
                });
            }
        });
        this.productButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame4.setVisible(true);
                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fifthPanel.setBackground(Color.decode("#ccd9ff"));
                fifthPanel.setLayout(null);
                frame4.add(fifthPanel);
                IdProductLabel.setBounds(7,7,80,30);
                IdProductText.setBounds(100,7,100,25);
                nameProductLabel.setBounds(7,47,70,25);
                nameProductText.setBounds(100,47,100,25);
                priceProductLabel.setBounds(7,87,70,25);
                priceProductText.setBounds(100,87,100,25);
                stockProductLabel.setBounds(7,127,70,25);
                stockProductText.setBounds(100,127,100,25);
                updateButtonProduct.setBounds(7,187,120,25);
                insertDataButtonProduct.setBounds(7,227,120,25);
                deleteDataButtonProduct.setBounds(7,267,120,25);
                showModificationButtonProduct.setBounds(7,307,165,25);
                backButtonProduct.setBounds(600,307,165,25);

                IdProductLabel.setFont(new Font("Serif",Font.BOLD,15));
                nameProductLabel.setFont(new Font("Serif",Font.BOLD,15));
                priceProductLabel.setFont(new Font("Serif",Font.BOLD,15));
                stockProductLabel.setFont(new Font("Serif",Font.BOLD,15));
                updateButtonProduct.setFont(new Font("Serif",Font.BOLD,15));
                insertDataButtonProduct.setFont(new Font("Serif",Font.BOLD,15));
                deleteDataButtonProduct.setFont(new Font("Serif",Font.BOLD,15));
                showModificationButtonProduct.setFont(new Font("Serif",Font.BOLD,15));
                backButtonProduct.setFont(new Font("Serif",Font.BOLD,15));

                fifthPanel.add(IdProductLabel);
                fifthPanel.add(IdProductText);
                fifthPanel.add(nameProductLabel);
                fifthPanel.add(nameProductText);
                fifthPanel.add(priceProductLabel);
                fifthPanel.add(priceProductText);
                fifthPanel.add(stockProductLabel);
                fifthPanel.add(stockProductText);
                fifthPanel.add(updateButtonProduct);
                fifthPanel.add(insertDataButtonProduct);
                fifthPanel.add(deleteDataButtonProduct);
                fifthPanel.add(showModificationButtonProduct);
                fifthPanel.add(backButtonProduct);
                setShowModificationButtonActionListenerProduct (new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ProductInterface(connection);
                            JScrollPane myScrollPane = new JScrollPane();
                            myScrollPane.setBounds(250, 20, 500, 250);
                            JTable productTable = new JTable();
                            productTable= productDAO.setProductTableForList(productTable);
                            productTable.setEnabled(true);
                            productTable.setVisible(true);
                            myScrollPane.setViewportView(productTable);
                            fifthPanel.add(myScrollPane);
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                insertButtonActionListenerProduct(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ProductInterface(connection);
                            productDAO.insertProduct();
                            JOptionPane.showMessageDialog(null,"The product was successfully inserted!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                deleteButtonActionListenerProduct(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ProductInterface(connection);
                            productDAO.deleteProduct();
                            JOptionPane.showMessageDialog(null,"The product was successfully deleted!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                updateButtonActionListenerProduct(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ProductInterface(connection);
                            productDAO.updateProduct();
                            JOptionPane.showMessageDialog(null,"The product was successfully updated!");
                        } catch (SQLException | IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                backButtonActionListenerProduct(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame4.setVisible(false);
                    }
                });
            }
        });


        clientTableButton.setBounds(107,157,140,30);
        orderDetailsTableButton.setBounds(287,157,140,30);
        orderTableButton.setBounds(107,207,140,30);
        productTableButton.setBounds(287,207,140,30);
        introLabel.setBounds(120,47,350,30);

        clientTableButton.setFont(new Font("Serif",Font.BOLD,15));
        orderTableButton.setFont(new Font("Serif",Font.BOLD,15));
        orderDetailsTableButton.setFont(new Font("Serif",Font.BOLD,15));
        productTableButton.setFont(new Font("Serif",Font.BOLD,15));
        introLabel.setFont(new Font("Serif",Font.BOLD,15));

        firstPanel.add(clientTableButton);
        firstPanel.add(orderDetailsTableButton);
        firstPanel.add(orderTableButton);
        firstPanel.add(productTableButton);
        firstPanel.add(introLabel);

    }

    /**
     * Client button action listener.
     *
     * @param actionListener the action listener
     */
    public void clientButtonActionListener(final ActionListener actionListener)
    {
        clientTableButton.addActionListener(actionListener);
    }

    /**
     * Order details button action listener.
     *
     * @param actionListener the action listener
     */
    public void orderDetailsButtonActionListener(final ActionListener actionListener)
    {
        orderDetailsTableButton.addActionListener(actionListener);
    }

    /**
     * Order button action listener.
     *
     * @param actionListener the action listener
     */
    public void orderButtonActionListener(final ActionListener actionListener)
    {
        orderTableButton.addActionListener(actionListener);
    }

    /**
     * Product button action listener.
     *
     * @param actionListener the action listener
     */
    public void productButtonActionListener(final ActionListener actionListener)
    {
        productTableButton.addActionListener(actionListener);
    }

    /**
     * Insert button action listener client.
     *
     * @param actionListener the action listener
     */
    public void insertButtonActionListenerClient(final ActionListener actionListener)
    {
        insertDataButtonClient.addActionListener(actionListener);
    }

    /**
     * Delete button action listener client.
     *
     * @param actionListener the action listener
     */
    public void deleteButtonActionListenerClient(final ActionListener actionListener)
    {
        deleteDataButtonClient.addActionListener(actionListener);
    }

    /**
     * Update button action listener client.
     *
     * @param actionListener the action listener
     */
    public void updateButtonActionListenerClient(final ActionListener actionListener)
    {
        updateButtonClient.addActionListener(actionListener);
    }

    /**
     * Sets show modification button action listener client.
     *
     * @param actionListener the action listener
     */
    public void setShowModificationButtonActionListenerClient(final ActionListener actionListener)
    {
        showModificationButtonClient.addActionListener(actionListener);
    }

    /**
     * Back button action listener client.
     *
     * @param actionListener the action listener
     */
    public void backButtonActionListenerClient(final ActionListener actionListener)
    {
        backButtonClient.addActionListener(actionListener);
    }

    /**
     * Insert button action listener order.
     *
     * @param actionListener the action listener
     */
////
    public void insertButtonActionListenerOrder(final ActionListener actionListener)
    {
        insertDataButtonOrder.addActionListener(actionListener);
    }

    /**
     * Delete button action listener order.
     *
     * @param actionListener the action listener
     */
    public void deleteButtonActionListenerOrder(final ActionListener actionListener)
    {
        deleteDataButtonOrder.addActionListener(actionListener);
    }

    /**
     * Update button action listener order.
     *
     * @param actionListener the action listener
     */
    public void updateButtonActionListenerOrder(final ActionListener actionListener)
    {
        updateButtonOrder.addActionListener(actionListener);
    }

    /**
     * Sets show modification button action listener order.
     *
     * @param actionListener the action listener
     */
    public void setShowModificationButtonActionListenerOrder(final ActionListener actionListener)
    {
        showModificationButtonOrder.addActionListener(actionListener);
    }

    /**
     * Back button action listener order.
     *
     * @param actionListener the action listener
     */
    public void backButtonActionListenerOrder(final ActionListener actionListener)
    {
        backButtonOrder.addActionListener(actionListener);
    }

    /**
     * Insert button action listener product.
     *
     * @param actionListener the action listener
     */
////
    public void insertButtonActionListenerProduct(final ActionListener actionListener)
    {
        insertDataButtonProduct.addActionListener(actionListener);
    }

    /**
     * Delete button action listener product.
     *
     * @param actionListener the action listener
     */
    public void deleteButtonActionListenerProduct(final ActionListener actionListener)
    {
        deleteDataButtonProduct.addActionListener(actionListener);
    }

    /**
     * Update button action listener product.
     *
     * @param actionListener the action listener
     */
    public void updateButtonActionListenerProduct(final ActionListener actionListener)
    {
        updateButtonProduct.addActionListener(actionListener);
    }

    /**
     * Sets show modification button action listener product.
     *
     * @param actionListener the action listener
     */
    public void setShowModificationButtonActionListenerProduct(final ActionListener actionListener)
    {
        showModificationButtonProduct.addActionListener(actionListener);
    }

    /**
     * Back button action listener product.
     *
     * @param actionListener the action listener
     */
    public void backButtonActionListenerProduct(final ActionListener actionListener)
    {
        backButtonProduct.addActionListener(actionListener);
    }

    /**
     * Insert button action listener od.
     *
     * @param actionListener the action listener
     */
///
    public void insertButtonActionListenerOD(final ActionListener actionListener)
    {
        insertDataButtonOD.addActionListener(actionListener);
    }

    /**
     * Delete button action listener od.
     *
     * @param actionListener the action listener
     */
    public void deleteButtonActionListenerOD(final ActionListener actionListener)
    {
        deleteDataButtonOD.addActionListener(actionListener);
    }

    /**
     * Update button action listener od.
     *
     * @param actionListener the action listener
     */
    public void updateButtonActionListenerOD(final ActionListener actionListener)
    {
        updateButtonOD.addActionListener(actionListener);
    }

    /**
     * Sets show modification button action listener od.
     *
     * @param actionListener the action listener
     */
    public void setShowModificationButtonActionListenerOD(final ActionListener actionListener)
    {
        showModificationButtonOD.addActionListener(actionListener);
    }

    /**
     * Back button action listener od.
     *
     * @param actionListener the action listener
     */
    public void backButtonActionListenerOD(final ActionListener actionListener)
    {
        backButtonOD.addActionListener(actionListener);
    }

    /**
     * Generate bill button action listener.
     *
     * @param actionListener the action listener
     */
////
    public void generateBillButtonActionListener(final ActionListener actionListener)
    {
        generateBillButton.addActionListener(actionListener);
    }

    /**
     * Client interface.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    public void ClientInterface(Connection connection) throws SQLException {
        clientDAO=new ClientDAO(connection,this);
    }

    /**
     * Order interface.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    public void OrderInterface(Connection connection) throws SQLException {
        orderDAO=new OrderDAO(connection,this);
    }

    /**
     * Product interface.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    public void ProductInterface(Connection connection) throws SQLException {
        productDAO=new ProductDAO(connection,this);
    }

    /**
     * Order details interface.
     *
     * @param connection the connection
     * @throws SQLException the sql exception
     */
    public void OrderDetailsInterface(Connection connection) throws SQLException {
        orderDetailsDAO=new OrderDetailsDAO(connection,this);
    }
}
