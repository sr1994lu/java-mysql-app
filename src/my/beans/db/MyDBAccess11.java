package my.beans.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyDBAccess11 extends MyDBAccess01 {

  protected PreparedStatement pst;
  public static final int GAKUSEKI = 101;
  public static final int KURASU = 102;
  public static final int SHUSSEKI = 103;
  public static final int SHIMEI = 104;
  public static final int NENREI = 105;

  public MyDBAccess11() {
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

  public void select(int CONST, String param) {
    try {
      String executeQuery = "executeQuery";
      switch (CONST) {
        case 101:
          this.pst = this.cn.prepareStatement("SELECT * FROM t01_gakusei WHERE GAKUSEKI = ?");
          this.pst.setString(1, param);
          break;
        case 102:
          this.pst = this.cn.prepareStatement("SELECT * FROM t01_gakusei WHERE KURASU = ?");
          this.pst.setString(1, param);
          break;
        case 103:
          this.pst = this.cn.prepareStatement("SELECT * FROM t01_gakusei WHERE SHUSSEKI = ?");
          this.pst.setString(1, param);
          break;
        case 104:
          this.pst = this.cn.prepareStatement("SELECT * FROM t01_gakusei WHERE SHIMEI = ?");
          this.pst.setString(1, param);
          break;
        case 105:
          this.pst = this.cn.prepareStatement("SELECT * FROM t01_gakusei WHERE NENREI = ?");
          this.pst.setString(1, param);
          break;
        default:
          executeQuery = "ignoredExecuteQuery";
          break;
      }
      switch (executeQuery) {
        case "executeQuery":
          this.rs = this.pst.executeQuery();

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
          break;
        case "ignoredExecuteQuery":
          break;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public boolean update(String GAKUSEKIparam, int CONST, String param) {
    boolean result = false;
    try {
      String executeQuery = "executeQuery";
      switch (CONST) {
        case 101:
          this.pst = this.cn
              .prepareStatement("UPDATE t01_gakusei SET GAKUSEKI = ? WHERE GAKUSEKI = ?");
          this.pst.setString(1, param);
          this.pst.setString(2, GAKUSEKIparam);
          break;
        case 102:
          this.pst = this.cn
              .prepareStatement("UPDATE t01_gakusei SET KURASU = ? WHERE GAKUSEKI = ?");
          this.pst.setString(1, param);
          this.pst.setString(2, GAKUSEKIparam);
          break;
        case 103:
          this.pst = this.cn
              .prepareStatement("UPDATE t01_gakusei SET SHUSSEKI = ? WHERE GAKUSEKI = ?");
          this.pst.setString(1, param);
          this.pst.setString(2, GAKUSEKIparam);
          break;
        case 104:
          this.pst = this.cn
              .prepareStatement("UPDATE t01_gakusei SET SHIMEI = ? WHERE GAKUSEKI = ?");
          this.pst.setString(1, param);
          this.pst.setString(2, GAKUSEKIparam);
          break;
        case 105:
          this.pst = this.cn
              .prepareStatement("UPDATE t01_gakusei SET NENREI = ? WHERE GAKUSEKI = ?");
          this.pst.setString(1, param);
          this.pst.setString(2, GAKUSEKIparam);
          break;
        default:
          executeQuery = "ignoredExecuteQuery";
          break;
      }
      switch (executeQuery) {
        case "executeQuery":
          pst.executeUpdate();
          result = true;
          break;
        case "ignoredExecuteQuery":
          result = false;
          break;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
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
      if (this.pst != null) {
        this.pst.close();
        statusComment.add("PrepareStatement closed");
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
