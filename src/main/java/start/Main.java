package start;

import Presentation.UI;
import dao.OrderDAO;

import java.io.IOException;
import java.sql.SQLException;

public class Main {



    public static void main(String[] args) throws SQLException, IOException {

//        UI ui = new UI();
        Class myObjClass= UI.class;
        System.out.println(myObjClass.getSimpleName());

    }
}