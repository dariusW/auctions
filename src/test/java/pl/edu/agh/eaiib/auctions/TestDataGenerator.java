package pl.edu.agh.eaiib.auctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: Karol Date: 08.12.13 Time: 16:51
 */
public class TestDataGenerator {

    @Test
    public void test() {

    }

    public static void main(String[] args) {
        Connection connection = null;
        String T_Acution = "CREATE TABLE AUCTION (AUCTION_ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1), AUCTION_OWNER VARCHAR(255), AUCTION_CURRENT_PRICE DOUBLE, AUCTION_DELIVERY_DESC VARCHAR(255), AUCTION_DESC VARCHAR(255), AUCTION_END TIMESTAMP, AUCTION_START TIMESTAMP, AUCTION_START_PRICE DOUBLE, AUCTION_TITLE VARCHAR(255), AUCTION_FINALIZED BIT, AUCTION_FINISHED BIT, AUCTION_WON BIT, PRIMARY KEY (AUCTION_ID)) ";
        String T_Am_Contact = "CREATE TABLE AM_CONTACT (AUCTION_ID BIGINT NOT NULL, BANK VARCHAR(255), BANK_ACCOUNT_NB VARCHAR(26), EMAIL VARCHAR(255), LOGIN VARCHAR(255), NAME VARCHAR(255), PHONE VARCHAR(255), SURNAME VARCHAR(255), PRIMARY KEY (AUCTION_ID))";
        String T_Bet = "CREATE TABLE BET (BET_ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1), BET_PRICE DOUBLE, BET_TIME TIMESTAMP, CLIENT_ID VARCHAR(255), AUCTION_ID BIGINT NOT NULL, PRIMARY KEY (BET_ID)) ";
        String T_Buyer_Contact = "CREATE TABLE BUYER_CONTACT (AUCTION_ID BIGINT NOT NULL, ADDRESS VARCHAR(255), EMAIL VARCHAR(255), LOGIN VARCHAR(255), NAME VARCHAR(255), PHONE VARCHAR(255), SURNAME VARCHAR(255), PRIMARY KEY (AUCTION_ID)) ";
        String T_Image = "CREATE TABLE IMAGE (IMG_ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1), URL VARCHAR(255), AUCTION_ID BIGINT NOT NULL, PRIMARY KEY (IMG_ID))";
        String AuctionSchema = T_Acution + " " + T_Am_Contact + " " + T_Bet + " " + T_Buyer_Contact + " " + T_Image + " ";

        String AuctionColumns = "AUCTION_ID, AUCTION_OWNER, AUCTION_CURRENT_PRICE, AUCTION_DELIVERY_DESC, AUCTION_DESC, AUCTION_END, AUCTION_START, AUCTION_START_PRICE, AUCTION_TITLE, AUCTION_FINALIZED, AUCTION_FINISHED, AUCTION_WON";
        String AMContactColumns = "AUCTION_ID, BANK, BANK_ACCOUNT_NB, EMAIL, LOGIN, NAME, PHONE, SURNAME";
        String BuyerContactColumns = "AUCTION_ID, ADDRESS, EMAIL, LOGIN, NAME, PHONE, SURNAME";
        String BetColumns = "BET_ID, BET_PRICE, BET_TIME, CLIENT_ID, AUCTION_ID";
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:mydb", "SA", "");
            System.out.println("Siema");
            statement = connection.createStatement();
            statement.execute(AuctionSchema);
            ArrayList<String> sqls = new ArrayList<String>();

            // auctions
            sqls.add("INSERT INTO AUCTION ("
                    + AuctionColumns
                    + ") VALUES (1, 'AM', 25, 'Odbiór osobisty', 'Nieużywany kaftan bezpieczeństwa. Z gwarancją. Wszytkie metki zgodne.', CURRENT_TIMESTAMP + 4 DAY, CURRENT_TIMESTAMP - 1 DAY, 10, 'Super kaftan bezpieczeństwa', 0, 0 , 0)");
            sqls.add("INSERT INTO AUCTION ("
                    + AuctionColumns
                    + ") VALUES (2, 'AM', 13430, 'Odbiór osobisty', 'Na sprzedaż samochód marki BentLej. Pochodzi z floty przedstawicieli handlowych wydziału do spraw wali z zombie', CURRENT_TIMESTAMP + 5 DAY + 4 HOUR, CURRENT_TIMESTAMP - 17 HOUR, 10000, 'Najnowszy BentLej', 0, 0 , 0)");
            sqls.add("INSERT INTO AUCTION ("
                    + AuctionColumns
                    + ") VALUES (3, 'AM', 500, 'Przesyłka kurierska', 'Najnowszy NEXUS 5, pełna gwarancja, wszystko cacy.', CURRENT_TIMESTAMP + 5 DAY + 4 HOUR, CURRENT_TIMESTAMP - 1 DAY - 13 HOUR, 100, 'Najnowszy BentLej', 0, 0 , 0)");
            sqls.add("INSERT INTO AUCTION ("
                    + AuctionColumns
                    + ") VALUES (4, 'AM', 240, 'Paczkomat', 'Zegarek rolmex. Zniszczony i niesprawny', CURRENT_TIMESTAMP + 7 DAY + 16 HOUR, CURRENT_TIMESTAMP - 2 DAY + 7 HOUR, 200, 'Super ROLMEX!', 0, 0 , 0)");
            // todo: verify finalized/finished/won flags
            sqls.add("INSERT INTO AUCTION ("
                    + AuctionColumns
                    + ") VALUES (5, 'AM', 2.5, 'Odbiór osobisty', '1 kg mandarynek, w sam raz na prezent!', CURRENT_TIMESTAMP - 1 HOUR, CURRENT_TIMESTAMP - 10 DAY, 1, 'Kilogram mandarynek', 0, 1 , 1)");

            // contact details for aucton managers
            sqls.add("INSERT INTO AM_CONTACT (" + AMContactColumns
                    + ") VALUES (1, 'PEKA�?O BPSA', '65102056980000598645620125', 'AMUser@testmail.com', 'AM', 'AMUser', '854321886', 'am')");
            sqls.add("INSERT INTO AM_CONTACT (" + AMContactColumns
                    + ") VALUES (2, 'BZWmBank', '65102056980000748645620123', 'AMUser@testmail.com', 'AM', 'AMUser', '854321886', 'am')");
            sqls.add("INSERT INTO AM_CONTACT (" + AMContactColumns
                    + ") VALUES (3, 'InteMilenium', '66202056980000748325628877', 'AMUser@testmail.com', 'AM', 'AMUser', '854321886', 'am')");
            sqls.add("INSERT INTO AM_CONTACT (" + AMContactColumns
                    + ") VALUES (4, 'IMG M. Kondrad sp. Zuoo', '65805056630000713447521123', 'AMUser@testmail.com', 'AM', 'AMUser', '854321886', 'am')");
            sqls.add("INSERT INTO AM_CONTACT (" + AMContactColumns
                    + ") VALUES (5, 'BZWmBank', '65102056980000748645620123', 'amuser@testmail.com', 'AM', 'AMUser', '854321886', 'am')");

            // buyer contact
            sqls.add("INSERT INTO BUYER_CONTACT (" + BuyerContactColumns
                    + ") VALUES (5, 'ul. Fioletowa 18, 73-158 Wozitkowo Dolne', 'client@testmail.com', 'client', 'Client', '447529862', 'Kupujący')");

            // bets
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (1, 15, CURRENT_TIMESTAMP - 16 HOUR, 'customer', 1)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (2, 25, CURRENT_TIMESTAMP - 10 HOUR, 'client', 1)");

            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (3, 10500, CURRENT_TIMESTAMP - 15 HOUR, 'customer', 2)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (4, 11500, CURRENT_TIMESTAMP - 15 HOUR + 35 MINUTE, 'customer2', 2)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (5, 12750, CURRENT_TIMESTAMP - 14 HOUR , 'customer', 2)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (6, 13000, CURRENT_TIMESTAMP - 13 HOUR , 'client', 2)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (7, 13200, CURRENT_TIMESTAMP - 6 HOUR , 'customer', 2)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (8, 13430, CURRENT_TIMESTAMP - 1 HOUR , 'client', 2)");

            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (9, 100, CURRENT_TIMESTAMP - 1 DAY , 'client', 3)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (10, 200, CURRENT_TIMESTAMP - 10 HOUR, 'customer', 3)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (11, 250, CURRENT_TIMESTAMP - 5 HOUR, 'client', 3)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (12, 325, CURRENT_TIMESTAMP - 4 HOUR, 'customer', 3)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (13, 390, CURRENT_TIMESTAMP - 4 HOUR + 30 MINUTE, 'client', 3)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (14, 390, CURRENT_TIMESTAMP - 4 HOUR + 30 MINUTE, 'customer2', 3)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (15, 450, CURRENT_TIMESTAMP - 2 HOUR, 'customer', 3)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (16, 500, CURRENT_TIMESTAMP - 30 MINUTE, 'client', 3)");

            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (17, 240, CURRENT_TIMESTAMP - 1 DAY, 'client', 4)");

            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (18, 1, CURRENT_TIMESTAMP - 6 DAY, 'client2', 5)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (19, 1.5, CURRENT_TIMESTAMP - 3 DAY, 'client', 5)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (20, 2, CURRENT_TIMESTAMP - 1 DAY, 'customer', 5)");
            sqls.add("INSERT INTO BET (" + BetColumns + ") VALUES (21, 2.5, CURRENT_TIMESTAMP - 3 HOUR, 'client', 5)");

            try {
                for (String sql : sqls) {
                    statement.executeUpdate(sql);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // test inserts....
            resultSet = statement.executeQuery("SELECT * FROM AUCTION");
            while (resultSet.next()) {
                System.out.print("ID:" + resultSet.getInt("auction_id") + " ");
                System.out.print("Start:" + resultSet.getDate("auction_start").toString() + " ");
                System.out.println("End:" + resultSet.getDate("auction_end").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if ( connection != null ) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
