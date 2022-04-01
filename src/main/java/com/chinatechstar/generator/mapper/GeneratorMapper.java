package com.chinatechstar.generator.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.chinatechstar.generator.entity.Generator;

/**
 * 代码信息的数据持久接口层
 * 
 * @版权所有 广东国星科技有限公司 www.mscodecloud.com
 */
public interface GeneratorMapper {

	/**
	 * 查询代码信息分页或导出数据
	 * 
	 * @param paramMap 参数Map
	 * @return
	 */
	List<LinkedHashMap<String, Object>> queryGenerator(Map<String, Object> paramMap);

	/**
	 * 根据ID查询代码信息
	 * 
	 * @param id 代码信息ID
	 * @return
	 */
	List<LinkedHashMap<String, Object>> queryGeneratorById(Long[] id);

	/**
	 * 根据代码信息ID查询对应的实体字段
	 * 
	 * @param generatorId 代码信息ID
	 * @return
	 */
	List<LinkedHashMap<String, Object>> queryFieldByGeneratorId(Long generatorId);

	/**
	 * 查询数据表信息分页或导出数据
	 * 
	 * @param paramMap 参数Map
	 * @return
	 */
	List<LinkedHashMap<String, Object>> queryGeneratorTable(Map<String, Object> paramMap);

	/**
	 * 新增代码信息
	 * 
	 * @param generator 代码信息对象
	 * @return
	 */
	int insertGenerator(Generator generator);

	/**
	 * 新增实体字段信息
	 * 
	 * @param id          实体字段ID
	 * @param fieldType   类型
	 * @param field       实体字段
	 * @param generatorId 代码信息ID
	 * @return
	 */
	int insertGeneratorField(Long id, String fieldType, String field, Long generatorId);

	/**
	 * 编辑代码信息
	 * 
	 * @param generator 代码信息对象
	 * @return
	 */
	int updateGenerator(Generator generator);

	/**
	 * 删除代码信息
	 * 
	 * @param id 代码信息ID
	 * @return
	 */
	int deleteGenerator(Long[] id);

	/**
	 * 删除实体字段信息
	 * 
	 * @param generatorId 代码信息ID
	 * @return
	 */
	int deleteGeneratorField(Long[] generatorId);

}
