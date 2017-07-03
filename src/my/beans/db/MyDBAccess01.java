package my.beans.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDBAccess01 {

  protected Connection cn;
  protected Statement st;
  protected ResultSet rs;
  protected String[][] strArray;

  public MyDBAccess01() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ma4208db02",
          "mysqluser",
          "mysqlpassword");
      this.st = this.cn.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void select() throws SQLException {
    try {
      this.rs = this.st.executeQuery("SELECT * FROM t01_gakusei");
      System.out.println("SQL発行完了");

      // to get row size
      this.rs.last();
      int rowSize = this.rs.getRow();
      this.rs.beforeFirst();

      // to get column size
      int columnSize = this.rs.getMetaData().getColumnCount();

      this.strArray = new String[rowSize][columnSize];
      int rowCount = 0;
      while (this.rs.next() && rowCount < rowSize) {
        for (int i = 0; i < columnSize; i += 1) {
          this.strArray[rowCount][i] = this.rs.getString(i + 1);
        }
        rowCount += 1;
      }
    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
    }
  }

  public String[][] getResult() {
    return this.strArray;
  }

  public void open() {
    try {
      this.cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ma4208db02",
          "mysqluser",
          "mysqlpassword");
      this.st = this.cn.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void close() {
    List<String> statusComment = new ArrayList<>();
    try {
      if (this.rs != null) {
        this.rs.close();
        statusComment.add("ResultSet closed");
      } else {
        statusComment.add("Can not closed ResultSet");
      }
      if (this.st != null) {
        this.st.close();
        statusComment.add("Statement closed");
      } else {
        statusComment.add("Can not closed Statement");
      }
      if (this.cn != null) {
        this.cn.close();
        statusComment.add("Connection closed");
      } else {
        statusComment.add("Can not closed Connection");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(statusComment);
    }
  }
}
