package com.tsinghuait.logistics.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class CreateIdHelp {
	@Resource
	private JedisPool jsd;// 得到缓存对象

	public String getHallarrivllist_id(String hid) {// 这里就不只自增1，当语句添成功后在往redis里添加
		Jedis jd = jsd.getResource();
		String ac = jd.get(hid);// 先查看缓存里又没有
		if (ac == null) {
			ac = hid + "_1";
		} else {
			String[] a = ac.split("_");
			String b = String.valueOf(Integer.valueOf(a[1]) + 1);
			ac = a[0] + "_" + b;
		}

		return ac;

	}

	public String getHallarrllist_ids(String hid, int c) {// 配合事物回滚用的
		Jedis jd = jsd.getResource();
		String ac = jd.get(hid);// 先查看缓存里又没有
		String[] a = ac.split("_");
		int cc = Integer.valueOf(a[1]) - c;
		String b = null;
		if (cc == 0) {
			ac = null;
		} else {
			b = String.valueOf(cc);
			ac = a[0] + "_" + b;

		}

		return ac;
	}
}
