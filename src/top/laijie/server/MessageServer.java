package top.laijie.server;

import java.util.List;

import top.laijie.bean.Message;
import top.laijie.dao.MessageDao;

public class MessageServer {
	
	public List<Message> queryMessageList(String command,String description){
		MessageDao dao = new MessageDao();
		return dao.queryMessageList(command, description);
	}
}
