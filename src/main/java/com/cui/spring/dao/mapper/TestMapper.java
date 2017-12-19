package com.cui.spring.dao.mapper;

import com.cui.spring.model.Test;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by cjs
 * Date： 2017/12/19.
 * Time： 16:59.
 */
@Mapper
public interface TestMapper {

      int addTest(Test test);
}
