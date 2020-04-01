package org.github.iamsrr;

/**
 * @Description:
 * @Author: Shihy
 * @Date: 2018/7/25 12:44
 */
public class PagerVo {

    /**
     * 请求页
     */
    private Integer pageNum = 1;
    /**
     * 每页记录数
     */
    private Integer pageSize = 20;
    /**
     * 请求记录
     */
    private Integer offset = 0;
    /**
     * 每页记录数
     */
    private Integer limit = 20;
    /**
     * 排序
     */
    private String order;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
