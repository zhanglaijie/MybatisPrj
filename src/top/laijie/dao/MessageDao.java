package top.laijie.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.spi.LoggerFactory;

import top.laijie.bean.Message;
import top.laijie.db.DbAccess;
/**
 * 和Message相关的数据库操作
 * @author laiji
 *
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
		public List<Message> queryMessageList(String command,String description){
			DbAccess dbAccess = new DbAccess();
			SqlSession sqlSession = null;
			List<Message> messageList = new ArrayList<Message>(); 
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			try {
				sqlSession = dbAccess.getSqlSession();
				//通过sqlSession执行sql语句
				messageList = sqlSession.selectList("Message.queryMessageList",message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(sqlSession!=null)
				sqlSession.close();
			}
			return messageList;
		}
		/**
		 * 删除单条注释
		 * @param id
		 */
		public void deleteOne(int id){
			DbAccess dbAccess = new DbAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				//通过sqlSession执行sql语句
				sqlSession.delete("Message.deleteOne",id);
				sqlSession.commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(sqlSession!=null)
				sqlSession.close();
			}
		}
		public void deleteBatch(List<Integer> ids){
			DbAccess dbAccess = new DbAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				//通过sqlSession执行sql语句
				sqlSession.delete("Message.deleteBatch",ids);
				sqlSession.commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(sqlSession!=null)
				sqlSession.close();
			}
		}
	public static void main(String[] args) {
		MessageDao dao = new MessageDao();
		///dao.queryMessageList(null, null);
		dao.deleteOne(1);
	}
	/*public List<Message> queryMessageList(String command,String description){
		List<Message> messageList = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://laijie.top:3306/wx","root","root");
			StringBuilder sql =new StringBuilder("select id,command,description,content from message where 1=1");
			List<String> params = new ArrayList<String>();
			if(command!=null&&!"".equals(command.trim())){
				sql.append(" and command = ?");
				params.add(command);
			}
			if(description!=null&&!"".equals(description.trim())){
				sql.append(" and description like'%' ? '%'");
				//params.add("%"+description+"%");
				params.add(description);
			}
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			for(int i=0;i<params.size();i++){
				statement.setString(i+1, params.get(i));
			}
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getInt("id"));
				message.setCommand(rs.getString("command"));
				message.setDescription(rs.getString("description"));
				message.setContent(rs.getString("content"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}*/
}
