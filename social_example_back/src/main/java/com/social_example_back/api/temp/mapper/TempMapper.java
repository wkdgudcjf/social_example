package com.social_example_back.api.temp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.social_example_back.api.temp.dto.TempDTO;
import com.social_example_back.config.db.MysqlDatasourceSelector;

@MysqlDatasourceSelector.Temp
@Mapper
public interface TempMapper {
	List<TempDTO> selectTempByEmail(String email);
}
