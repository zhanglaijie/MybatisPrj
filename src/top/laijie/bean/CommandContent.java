package top.laijie.bean;
/**
 * 命令内容
 * @author laijie
 */
public class CommandContent {
	/**
	 * 自增长字段
	 */
	int id;
	/**
	 * 内容字段
	 */
	String content;
	/**
	 * 指令ID
	 */
	int commandid;
	/**
	 * 指令
	 * @return
	 */
	Command command;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommandid() {
		return commandid;
	}
	public void setCommandid(int commandid) {
		this.commandid = commandid;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
}
