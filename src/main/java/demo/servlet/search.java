package demo.servlet;

import demo.util.Db;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhenya.1291813139.com
 * on 2017/6/10.
 * IpSearch_1702.
 */
public class search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String min = req.getParameter("min");
        String max = req.getParameter("max");
        String geo = req.getParameter("geo");

        Connection connection = Db.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sqlMin = "SELECT * FROM db_ip.search WHERE min = ?";
            if (connection != null) {
                statement = connection.prepareStatement(sqlMin);
            } else {
                return;
            }
            statement.setString(1, min);
            resultSet = statement.executeQuery();
            boolean isMinExist = resultSet.next();

            String sqlMax = "SELECT * FROM db_ip.search WHERE max = ?";
            statement = connection.prepareStatement(sqlMax);
            statement.setString(1, max);
            resultSet = statement.executeQuery();
            boolean isMaxExist = resultSet.next();

            if (isMinExist) {
            req.setAttribute("message", "166.111.3.111");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            } else if (isMaxExist) {
            req.setAttribute("message", "166.111.3.111");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "您的IP地址不存在");
                resp.sendRedirect("index.jsp");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Db.close(resultSet,statement, (com.mysql.jdbc.Connection) connection);
        }
    }
}
