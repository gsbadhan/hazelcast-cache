package com.cache.client;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelcastClient {

	public static void main(String[] args) {
		try {
			ClientConfig clientConfig = new ClientConfig();
			ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
			networkConfig.addAddress("127.0.0.1");
			HazelcastInstance client = com.hazelcast.client.HazelcastClient.newHazelcastClient(clientConfig);
			IMap<Object, Object> map = client.getMap("time");
			while (true) {
				System.out.println("client got:" + map.get("tt"));
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
