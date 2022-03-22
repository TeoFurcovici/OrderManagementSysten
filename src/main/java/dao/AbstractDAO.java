package dao;

import connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

/**
 * The type Abstract dao.
 *
 * @param <T> the type parameter
 */
public class AbstractDAO<T> {
    /**
     * The Default table model.
     */
    DefaultTableModel defaultTableModel=new DefaultTableModel();
    /**
     * The J table.
     */
    JTable jTable;
    /**
     * The Query.
     */
    StringBuilder query;

    private StringBuilder createInsertQuery(String tableName)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT ");
        sb.append("INTO ");
        sb.append("pt3_database.");
        sb.append(tableName);
        sb.append(" VALUES (");
        return sb;
    }

    /**
     * Create delete query string builder.
     *
     * @param tableName the table name
     * @param field     the field
     * @return the string builder
     */
    public StringBuilder createDeleteQuery(String tableName,String field)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("DELETE ");
        sb.append("FROM ");
        sb.append("pt3_database.");
        sb.append(tableName);
        sb.append(" WHERE ");
        sb.append(field);
        sb.append(" = ");
        return sb;
    }

    /**
     * Create update query string builder.
     *
     * @param tableName the table name
     * @return the string builder
     */
    public StringBuilder createUpdateQuery(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("pt3_database.");
        sb.append(tableName);
        sb.append(" SET ");
        return sb;
    }

    /**
     * Insert into table.
     *
     * @param obj the obj
     * @throws IllegalAccessException the illegal access exception
     * @throws SQLException           the sql exception
     */
    public void insertIntoTable(Object obj) throws IllegalAccessException, SQLException {
        String table=obj.getClass().getSimpleName();
        Field[] allFields=obj.getClass().getDeclaredFields();
        StringBuilder query=createInsertQuery(table);
        for (int i = 0; i < allFields.length; i++) {
            allFields[i].setAccessible(true);
            Object valueToBeInserted=allFields[i].get(obj);
            String fieldType=allFields[i].getType().getSimpleName();
            if(fieldType.equals("String"))
            {
                query.append("'"+valueToBeInserted+"'");
            }
            else
                query.append(valueToBeInserted);
            if(i!=allFields.length-1)
                query.append(",");
            else
                query.append("");
        }
        query.append(" )");
        System.out.println(query.toString());
        Connection connection= ConnectionFactory.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate(query.toString());
        ConnectionFactory.close(connection);
        ConnectionFactory.close(statement);
    }

    /**
     * Delete from table.
     *
     * @param obj the obj
     * @throws IllegalAccessException the illegal access exception
     * @throws SQLException           the sql exception
     */
    public void deleteFromTable(Object obj) throws IllegalAccessException, SQLException {
        String table=obj.getClass().getSimpleName();
        Field[] allFields=obj.getClass().getDeclaredFields();
        for (int i = 0; i < allFields.length; i++) {
            allFields[i].setAccessible(true);
            Object valueToBeInserted=allFields[0].get(obj);
            String fieldType=allFields[0].getType().getSimpleName();
            if(fieldType.equals("int"))
            {
                query=createDeleteQuery(table,allFields[0].getName());
                query.append(valueToBeInserted);
            }
        }
         System.out.println(query.toString());
        Connection connection= ConnectionFactory.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate(query.toString());
        ConnectionFactory.close(connection);
        ConnectionFactory.close(statement);

    }

    /**
     * Update table.
     *
     * @param obj the obj
     * @throws SQLException           the sql exception
     * @throws IllegalAccessException the illegal access exception
     */
    public void updateTable(Object obj) throws SQLException, IllegalAccessException {
        String table=obj.getClass().getSimpleName();
        Field[] allFields=obj.getClass().getDeclaredFields();
        StringBuilder query=createUpdateQuery(table);
        for (int i = 0; i < allFields.length; i++) {
            allFields[i].setAccessible(true);
            String currFieldName=allFields[i].getName();
            query.append(currFieldName+" = ");
            Object valueToBeInserted=allFields[i].get(obj);
            String fieldType=allFields[i].getType().getSimpleName();
            if(fieldType.equals("String"))
            {
                query.append("'"+valueToBeInserted+"'");
            }
            else
                query.append(valueToBeInserted);
            if(i!=allFields.length-1)
                query.append(", ");
            else
                query.append("");
        }
        query.append(" where ");
        allFields[0].setAccessible(true);
        query.append(allFields[0].getName() +" = ");
        Object valueToBeInserted=allFields[0].get(obj);
        query.append(valueToBeInserted);
         System.out.println(query.toString());
        Connection connection= ConnectionFactory.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate(query.toString());
        ConnectionFactory.close(connection);
    }

    /**
     * Create j table.
     *
     * @param genericList the generic list
     * @return the j table
     * @throws IllegalAccessException the illegal access exception
     */
    public JTable create(Vector<T> genericList) throws IllegalAccessException {
        String[] columnsTable=new String[genericList.get(0).getClass().getDeclaredFields().length];
        int i=0;
        for(Field field:genericList.get(0).getClass().getDeclaredFields())
        {
            columnsTable[i++]= field.getName();
        }
        defaultTableModel.setColumnIdentifiers(columnsTable);
        for (Object currObject:genericList) {
            Vector<Object> genericListObject=new Vector<>();
            genericListObject.setSize(genericList.get(0).getClass().getDeclaredFields().length);
            int currColumnToAddTo=0;
            for (Field field:currObject.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    genericListObject.set(currColumnToAddTo,field.get(currObject));
                    currColumnToAddTo++;
            }
            defaultTableModel.addRow(genericListObject);
        }
        jTable=new JTable(defaultTableModel);
        return  jTable;
    }

}
