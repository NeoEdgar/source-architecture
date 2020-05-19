package org.edgar.neo.demo.action;

import org.edgar.neo.demo.service.IDemoService;
import org.edgar.neo.framework.annotation.NeoAutowired;
import org.edgar.neo.framework.annotation.NeoController;
import org.edgar.neo.framework.annotation.NeoRequestMapping;
import org.edgar.neo.framework.annotation.NeoRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//虽然，用法一样，但是没有功能
@NeoController
@NeoRequestMapping("/demo")
public class DemoAction {

  	@NeoAutowired
	private IDemoService demoService;

	@NeoRequestMapping("/query")
	public void query(HttpServletRequest req, HttpServletResponse resp,
                      @NeoRequestParam("name") String name){
		String result = demoService.get(name);
//		String result = "My name is " + name;
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@NeoRequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp,
                    @NeoRequestParam("a") Integer a, @NeoRequestParam("b") Integer b){
		try {
			resp.getWriter().write(a + "+" + b + "=" + (a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@NeoRequestMapping("/sub")
	public void add(HttpServletRequest req, HttpServletResponse resp,
                    @NeoRequestParam("a") Double a, @NeoRequestParam("b") Double b){
		try {
			resp.getWriter().write(a + "-" + b + "=" + (a - b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@NeoRequestMapping("/remove")
	public String  remove(@NeoRequestParam("id") Integer id){
		return "" + id;
	}

}
