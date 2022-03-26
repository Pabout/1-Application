package fc.controller;

import bean.PageInfo;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/page")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取前端的请求参数
        String parameter = req.getParameter("pageNo");
        int pageNo=1;
        if (parameter!=null){
            pageNo=Integer.parseInt(parameter);
        }
        //每页显示多少条数据
        int pageSize=5;
        //获取一个对象。这个对象中包含了一些前端需要的参数
        //当前页pageNo
        //每页显示多少条pageSize
        //总数据量totalCount
        //总页数pageCount
        //每一页中显示的所有内容list
        //封装成一个对象：pageInfo
        PageInfo pageInfo=null;
        //设置完域对象
        req.setAttribute("pageInfo",pageInfo);
        //发送前端
        req.getRequestDispatcher("page.index").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
