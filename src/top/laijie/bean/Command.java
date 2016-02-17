package top.laijie.bean;

import java.util.List;

/**
 * 命令
 * @author laijie
 *
 */
public class Command {
	/**
	 * 主键
	 */
	private int id;
	private String name;
	private String description;
	/**
	 * 一条指令对应的自动回复内容列表
	 */
	private List<CommandContent> contentList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CommandContent> getContentList() {
		return contentList;
	}
	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}
	
}
