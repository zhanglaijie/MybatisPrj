package top.laijie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.laijie.bean.Command;
import top.laijie.bean.Message;
import top.laijie.server.MessageServer;


/**
 * 列表页面初始化控制
 * @author laijie
 *
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
	
		try {
			doPost(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String content = req.getParameter("content");
		MessageServer server = new MessageServer();
		//List<Message> messageList = server.queryMessageList(command, description);
		String command = server.queryByCommand(content);
		PrintWriter out = resp.getWriter();
		out.write(command);
		out.flush();
		out.close();
	}
}
