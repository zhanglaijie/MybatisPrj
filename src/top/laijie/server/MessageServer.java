package top.laijie.server;

import java.util.ArrayList;
import java.util.List;

import top.laijie.bean.Message;
import top.laijie.dao.MessageDao;

public class MessageServer {
	private MessageDao dao;
	public MessageServer(){
		dao = new MessageDao();
	}
	public List<Message> queryMessageList(String command,String description){
		//MessageDao dao = new MessageDao();
		return dao.queryMessageList(command, description);
	}
	public void deleteOne(String id){
		if(id!=null&&!"".equals(id.trim())){
			int idInt = Integer.parseInt(id); 
			dao.deleteOne(idInt);
		}
	}
	public void deleteBatch(String[] ids){
		List<Integer> idlist = new ArrayList<Integer>();
		for(String id:ids){
			idlist.add(Integer.parseInt(id));
		}
		dao.deleteBatch(idlist);
	}
}
