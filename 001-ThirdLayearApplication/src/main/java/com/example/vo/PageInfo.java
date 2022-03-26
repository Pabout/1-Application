package com.example.entity;

import java.util.List;

public class PageInfo<T> {
    private int pageCount;
    private int totalCount;
    private int pageSize;
    private int pageNo;
    private List<T> list;
    public PageInfo() {
    }

    public PageInfo(int totalCount, int pageSize, int pageNo, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.list = list;
        // 如果数据总数能够整除每页显示的条数
        if (totalCount % pageSize == 0) {
            // 总页数等于数据总条数除以每页显示多少条数据
            this.pageCount = totalCount / pageSize;
        } else {
            // 无法整除，再增加一页
            this.pageCount = totalCount / pageSize + 1;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", list=" + list +
                '}';
    }

}
