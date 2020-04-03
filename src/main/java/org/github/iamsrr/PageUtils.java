package org.github.iamsrr;

import java.util.List;

/**
 * @Description:
 * @Author: Shihy
 * @Date: 2017/8/25 12:56
 */
public class PageUtils<T> {

    private Integer minPage = 1;//
    private Integer maxPage;//

    private Integer prePage;
    private Integer currentPage;
    private Integer nextPage;
    private Integer count;//
    private Integer pageSize;//

    private Integer startPage;
    private Integer startCount;

    private List<?> list;

    private T t;

    private Integer serialNumber;


    public PageUtils(Integer count, Integer pageSize, Integer startPage) {
        this.count = count;
        if (pageSize == null) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
        if (count == null || count == 0) {
            this.maxPage = 1;
        } else {
            setMaxPage(this.count % this.pageSize > 0 ? this.count / this.pageSize + 1 : this.count / this.pageSize);
        }
        if (null == startPage || 0 == startPage) {
            setStartPage(0);
        } else {
            setStartPage(startPage);
        }
        this.serialNumber = this.pageSize * (this.startPage - 1) + 1;
    }

    public PageUtils(Integer count, String pageSize, String startPage) {
        this.count = count;

        if (null == pageSize) {
            this.pageSize = 10;
        } else {
            this.pageSize = Integer.parseInt(pageSize);
        }
        if (count == null || count == 0) {
            this.maxPage = 1;
        } else {
            setMaxPage(this.count % this.pageSize > 0 ? this.count / this.pageSize + 1 : this.count / this.pageSize);
        }
        if (null == startPage) {
            setStartPage(0);
        } else {
            setStartPage(Integer.parseInt(startPage));
        }
        this.serialNumber = this.pageSize * (this.startPage - 1) + 1;
    }

    public static String toLike(String str) {
        if (null == str) {
            return null;
        }
        str = str.trim();
        if (str.equals("") || str.equals("null")) {
            return null;
        }
        return new String("%").concat(str).concat("%");
    }

    public static String toFullLike(String str) {
        if (null == str) {
            return null;
        }
        str = str.trim();
        if (str.equals("") || str.equals("null")) {
            return null;
        }
        char[] chars = str.toCharArray();
        String s = new String();
        for (int i = 0; i < chars.length; i++) {
            s = s.concat("%").concat(chars[i] + "");
        }
        return s.concat("%");
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Integer getStartCount() {
        return this.startCount;
    }

    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }

    public Integer getMinPage() {
        return minPage;
    }

    public void setMinPage(Integer minPage) {
        this.minPage = minPage;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        if (prePage <= this.minPage) {
            this.prePage = this.minPage;
        } else {
            this.prePage = prePage;
        }
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage >= this.maxPage) {
            this.currentPage = this.maxPage;
        } else if (currentPage <= this.minPage) {
            this.currentPage = this.minPage;
        } else {
            this.currentPage = currentPage;
        }
        setPrePage(this.currentPage - 1);
        setNextPage(this.currentPage + 1);
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        if (nextPage >= this.maxPage) {
            this.nextPage = this.maxPage;
        } else {
            this.nextPage = nextPage;
        }
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        if (startPage == null) {
            startPage = 1;
        }
        if (startPage <= this.minPage) {
            this.startPage = this.minPage;
        } else if (startPage >= this.maxPage) {
            this.startPage = this.maxPage;
        } else {
            this.startPage = startPage;
        }
        setStartCount((this.startPage - 1) * this.pageSize);
        setCurrentPage(this.startPage);
    }

}
