package com.bootdo.system.service;

import com.bootdo.system.domain.ConfigDO;

import java.util.List;
import java.util.Map;

/**
 * 请求路径配置
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-31 18:38:42
 */
public interface ConfigService {
	
	ConfigDO get(Long id);
	
	List<ConfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ConfigDO config);
	
	int update(ConfigDO config);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    List<ConfigDO> listAvailable();
}
