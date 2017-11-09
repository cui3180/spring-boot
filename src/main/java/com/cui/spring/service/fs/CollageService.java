package com.cui.spring.service.fs;

import com.cui.spring.model.Collage;
import com.cui.spring.util.BaseResponseVo;

import java.util.Map;

/**
 * Created by cjs
 * Date： 2017/10/25.
 * Time： 14:38.
 */
public interface CollageService {
    /**
     * 分页获取
     * @param map
     * @return
     */
    BaseResponseVo getCollagePage(Map map);

    BaseResponseVo addCollage(Collage cp);

    BaseResponseVo updateCollage(Collage cp);

    BaseResponseVo delCollage(Integer id);

    BaseResponseVo getCollageById(Integer id);
}
