package com.cui.spring.util.query;

import com.cui.spring.util.page.PageInfo;
import lombok.Data;

import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/9/18.
 * Time： 15:42.
 */
@Data
public class QueryStudent extends PageInfo {
    private Integer id;
    private String name;
    private String phone;
    private Date startTime;
    private Date endTime;
}
