package org.edgar.neo.demo.service.impl;

import org.edgar.neo.demo.service.IDemoService;
import org.edgar.neo.framework.annotation.NeoService;

/**
 * 核心业务逻辑
 */
@NeoService
public class DemoService implements IDemoService {

	public String get(String name) {
		return "My name is " + name + ",from service.";
	}

}
