package org.student.entity;/**
 * @author yejh
 * @create 2019-09_29 11:08
 */

import java.util.List;

/**
 * @description: TODO
 * @currentPage: 当前页
 * @totalItems: 总数据量
 * @pageSize: 页数大小
 * @totalPage: 总页数，由总数据量和页面大小计算
 * @items: 当前页存放的数据
 **/
public class Page {
    private long currentPage;
    private long totalItems;
    private long pageSize;
    private long totalPage;
    private List<Student> items;

    public Page(long currentPage, long totalItems, long pageSize, List<Student> items) {
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.pageSize = pageSize;
        this.items = items;
        this.totalPage = this.totalPage = totalItems % pageSize == 0 ? totalItems / pageSize : totalItems / pageSize + 1;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
        this.totalPage = totalItems % pageSize == 0 ? totalItems / pageSize : totalItems / pageSize + 1;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public List<Student> getItems() {
        return items;
    }

    public void setItems(List<Student> items) {
        this.items = items;
    }
}
