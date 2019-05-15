package com.kwdz.commons.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果（针对JqGrid前端插件）
 */
@Data
public class PageInfo<V> implements Serializable {
    //   自定义serialVersionUID
    private static final long serialVersionUID = 212726041352680157L;

    private int page;//当前页码
    private int pageSize;//页面大小
    private String sidx;//排序字段
    private String sord;//排序方式
    private V postData;//查询参数

    private List<V> rows;//分页结果
    private int records;//总记录数
    private int total;//总页数
    private String html;//插入代码
}
