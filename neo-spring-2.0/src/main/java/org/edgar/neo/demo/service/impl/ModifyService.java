package org.edgar.neo.demo.service.impl;

import org.edgar.neo.demo.service.IModifyService;
import org.edgar.neo.framework.annotation.NeoService;

/**
 * 增删改业务
 * @author Tom
 *
 */
@NeoService
public class ModifyService implements IModifyService {

	/**
	 * 增加
	 */
	public String add(String name,String addr) {
		// throw new Exception("测试 这是故意抛出来的异常");
		return "modifyService add,name=" + name + ",addr=" + addr;
	}

	/**
	 * 修改
	 */
	public String edit(Integer id,String name) {
		return "modifyService edit,id=" + id + ",name=" + name;
	}

	/**
	 * 删除
	 */
	public String remove(Integer id) {
		return "modifyService id=" + id;
	}
	
}
