package org.crazyit.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.impl.persistence.deploy.DeploymentCache;

public class MyCacheBean<T> implements DeploymentCache<T> {
	
	public Map<String, T> cache;

	public MyCacheBean() {
		cache = new HashMap<String, T>();
	}
	public T get(String id) {
		return cache.get(id);
	}
	public boolean contains(String id) {
		return cache.containsKey(id);
	}
	public void add(String id, T object) {
		cache.put(id, object);
	}
	public void remove(String id) {
		cache.remove(id);
	}
	public void clear() {
		cache.clear();
	}
}
