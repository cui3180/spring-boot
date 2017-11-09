package com.cui.spring.dao.mapper;

import com.cui.spring.model.Collage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by cjs
 * Date： 2017/10/25.
 * Time： 14:30.
 */
@Mapper
@Component("collageMapper")
public interface CollageMapper {
     List<Collage> getCollageList(Map map);

     Integer getCollageCount(Map map);

     Collage getCollageById(Integer id);

     int addCollage(Collage cp);

     int updateCollage(Collage cp);

     int delCollage(Integer id);

}
