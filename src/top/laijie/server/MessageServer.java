package top.laijie.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import top.laijie.bean.Command;
import top.laijie.bean.CommandContent;
import top.laijie.bean.Message;
import top.laijie.dao.CommandDao;
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
	public List<Command> queryCommandList(String command,String description){
		CommandDao dao = new CommandDao();
		return dao.queryCommandList(command, description);
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
	public String queryByCommand(String content) {
		CommandDao dao = new CommandDao();
		List<Command> commandList = dao.queryCommandList(content, null);
		if(commandList.size()>0){
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return "暂无该指令,请重新输入~~~";
	}
}
