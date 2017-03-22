package com.cache.server;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastDstServer {

	private static final String prefix = "servr2";

	public static void main(String args[]) {

		buildCache();
	}

	public static void buildCache() {
		Config config = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);

		Map<String, String> cacheMap = instance.getMap("time");
		AtomicLong atomicLong = new AtomicLong(1);
		while (true) {
			try {
				Thread.sleep(2000);
				String key = prefix + "-" + atomicLong.getAndIncrement();
				cacheMap.put("tt", prefix + System.currentTimeMillis());
				System.out.println("data inserted for:" + key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
