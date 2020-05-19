package org.edgar.neo.demo.action;

import org.edgar.neo.demo.service.IModifyService;
import org.edgar.neo.demo.service.IQueryService;
import org.edgar.neo.framework.annotation.NeoAutowired;
import org.edgar.neo.framework.annotation.NeoController;
import org.edgar.neo.framework.annotation.NeoRequestMapping;
import org.edgar.neo.framework.annotation.NeoRequestParam;
import org.edgar.neo.framework.webmvc.servlet.NeoModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 公布接口url
 *
 */
@NeoController
@NeoRequestMapping("/web")
public class MyAction {

	@NeoAutowired
	IQueryService queryService;
	@NeoAutowired
	IModifyService modifyService;

	@NeoRequestMapping("/query.json")
	public NeoModelAndView query(HttpServletRequest request, HttpServletResponse response,
								 @NeoRequestParam("name") String name){
		String result = queryService.query(name);
		return out(response,result);
	}

	@NeoRequestMapping("/add*.json")
	public NeoModelAndView add(HttpServletRequest request,HttpServletResponse response,
							  @NeoRequestParam("name") String name,@NeoRequestParam("addr") String addr){
		String result = modifyService.add(name,addr);
		return out(response,result);
	}

	@NeoRequestMapping("/remove.json")
	public NeoModelAndView remove(HttpServletRequest request, HttpServletResponse response,
								 @NeoRequestParam("id") Integer id){
		String result = modifyService.remove(id);
		return out(response,result);
	}

	@NeoRequestMapping("/edit.json")
	public NeoModelAndView edit(HttpServletRequest request,HttpServletResponse response,
							   @NeoRequestParam("id") Integer id,
							   @NeoRequestParam("name") String name){
		String result = modifyService.edit(id,name);
		return out(response,result);
	}



	private NeoModelAndView out(HttpServletResponse resp,String str){
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
