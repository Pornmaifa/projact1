import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import newpackage.DatabaseUtils;
import model.TeaOrder;


@WebServlet(urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            // ดึงข้อมูลคำสั่งซื้อจาก Session และส่งต่อไปยังหน้า editOrder.jsp
            TeaOrder order = (TeaOrder) request.getSession().getAttribute("order");
            request.setAttribute("order", order);
            request.getRequestDispatcher("editOrder.jsp").forward(request, response);
        } else if ("update".equals(action)) {
            // รับค่าจากฟอร์มแก้ไขและอัปเดตคำสั่งซื้อ
            updateOrder(request);
            // ส่งต่อไปยังหน้าแสดงผล
            TeaOrder order = (TeaOrder) request.getSession().getAttribute("order");
            request.setAttribute("order", order);
            request.getRequestDispatcher("displayOrder.jsp").forward(request, response);
        } else {
            // การสร้างคำสั่งซื้อใหม่
            createOrder(request);
            // ส่งต่อไปยังหน้าแสดงผล
            TeaOrder order = (TeaOrder) request.getSession().getAttribute("order");
            request.setAttribute("order", order);
            request.getRequestDispatcher("displayOrder.jsp").forward(request, response);
        }
    }

    private void createOrder(HttpServletRequest request) {
        // รับค่าจากฟอร์มและสร้างคำสั่งซื้อใหม่
        String customerName = request.getParameter("customerName");
        String[] teaNames = request.getParameterValues("teaName");
        String[] toppings = request.getParameterValues("topping");
        String sweetness = request.getParameter("sweetness");
        double price = Double.parseDouble(request.getParameter("price"));

        String teaName = String.join(", ", teaNames);
        String topping = (toppings != null) ? String.join(", ", toppings) : "ไม่มี";

        TeaOrder order = new TeaOrder(customerName, teaName, topping, sweetness, price);

        // บันทึกคำสั่งซื้อในฐานข้อมูล
        try {
            DatabaseUtils.saveOrder(order);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // เก็บคำสั่งซื้อไว้ใน Session
        request.getSession().setAttribute("order", order);
    }

    private void updateOrder(HttpServletRequest request) {
        // รับค่าจากฟอร์มแก้ไขและอัปเดตคำสั่งซื้อใน Session
        String customerName = request.getParameter("customerName");
        String[] teaNames = request.getParameterValues("teaName");
        String[] toppings = request.getParameterValues("topping");
        String sweetness = request.getParameter("sweetness");
        double price = Double.parseDouble(request.getParameter("price"));

        String teaName = String.join(", ", teaNames);
        String topping = (toppings != null) ? String.join(", ", toppings) : "ไม่มี";

        TeaOrder order = (TeaOrder) request.getSession().getAttribute("order");
        order.setCustomerName(customerName);
        order.setTeaName(teaName);
        order.setTopping(topping);
        order.setSweetness(sweetness);
        order.setPrice(price);

        // บันทึกการแก้ไขในฐานข้อมูล
        try {
            DatabaseUtils.saveOrder(order); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

