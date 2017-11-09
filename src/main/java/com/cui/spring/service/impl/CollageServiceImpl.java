package com.cui.spring.service.impl;

import com.cui.spring.dao.mapper.CollageMapper;
import com.cui.spring.model.Collage;
import com.cui.spring.service.fs.CollageService;
import com.cui.spring.util.BaseResponseVo;
import com.cui.spring.util.PageInfo;
import com.cui.spring.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cjs
 * Date： 2017/10/25.
 * Time： 14:43.
 */
@Service("collageService")
public class CollageServiceImpl implements CollageService{

    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class.getName());

    @Autowired
    private CollageMapper collageMapper;
    /**
     * 分页获取
     *
     * @param map
     * @return
     */
    @Override
    public BaseResponseVo getCollagePage(Map map) {
        logger.info("Begin--getCollagePage--map={}",map);
        BaseResponseVo baseResponseVo =new BaseResponseVo();
        try{
            Integer pageIndex = (Integer)map.get("pageIndex");
            Integer collageCount = collageMapper.getCollageCount(map);
            PageInfo pageInfo=new PageInfo();
            PageUtil.setPageInfo(pageInfo,collageCount,pageIndex,30);
            int startIndex = PageUtil.getStartIndex(pageIndex, 30);
            map.put("pageIndex",startIndex);
            map.put("pageSize",30);
            List<Collage> collageList = collageMapper.getCollageList(map);
            baseResponseVo.setData(collageList);
            baseResponseVo.setPageInfo(pageInfo);
            baseResponseVo.setIsSuccess(true);
        }catch (Exception e){
            logger.error("error--getCollagePage--e={}",e);
            baseResponseVo.setIsSuccess(false);
        }
        return baseResponseVo;
    }

    @Override
    public BaseResponseVo addCollage(Collage cp) {
        logger.info("Begin--addCollage--cp={}",cp);
        BaseResponseVo baseResponseVo =new BaseResponseVo();
        try {
            int i = collageMapper.addCollage(cp);
            if(i<1){
                baseResponseVo.setIsSuccess(false);
                return   baseResponseVo;
            }
            baseResponseVo.setIsSuccess(true);
        }catch (Exception e){
           logger.error("error--addCollage--e{}",e);
            baseResponseVo.setIsSuccess(false);
        }
        return baseResponseVo;
    }

    @Override
    public BaseResponseVo updateCollage(Collage cp) {
        logger.info("Begin--updateCollage--cp={}",cp);
        BaseResponseVo baseResponseVo =new BaseResponseVo();
        try {
            int i = collageMapper.updateCollage(cp);
            if(i<1){
                baseResponseVo.setIsSuccess(false);
                return   baseResponseVo;
            }
            baseResponseVo.setIsSuccess(true);
        }catch (Exception e){
            logger.error("error--updateCollage--e{}",e);
            baseResponseVo.setIsSuccess(false);
        }
        return baseResponseVo;
    }

    @Override
    public BaseResponseVo delCollage(Integer id) {
        logger.info("Begin--delCollage--id={}",id);
        BaseResponseVo baseResponseVo =new BaseResponseVo();
        try {
            int i = collageMapper.delCollage(id);
            if(i<1){
                baseResponseVo.setIsSuccess(false);
                return   baseResponseVo;
            }
            baseResponseVo.setIsSuccess(true);
        }catch (Exception e){
            logger.error("error--delCollage--e{}",e);
            baseResponseVo.setIsSuccess(false);
        }
        return baseResponseVo;
    }

    @Override
    public BaseResponseVo getCollageById(Integer id) {
        logger.info("Begin--getCollageById--id={}",id);
        BaseResponseVo baseResponseVo =new BaseResponseVo();
        try {
            Collage cp = collageMapper.getCollageById(id);
            baseResponseVo.setIsSuccess(true);
            baseResponseVo.setData(cp);
        }catch (Exception e){
            logger.error("error--delCollage--e{}",e);
            baseResponseVo.setIsSuccess(false);
        }
        return baseResponseVo;
    }
}
