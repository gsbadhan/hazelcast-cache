package com.cache.server;

import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastDstServer {

	public static void main(String args[]) {
		buildCache();
	}

	public static void buildCache() {
		Config config = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);

		Map<Integer, String> customerMap = instance.getMap("customers");
        customerMap.put(1, "Bangalore");
        customerMap.put(2, "Chennai");
        customerMap.put(3, "Hyderabad");
        
	}

}
