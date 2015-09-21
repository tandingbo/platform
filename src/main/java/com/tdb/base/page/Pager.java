package com.tdb.base.page;

import java.util.List;

/**
 * ClassName: Pager
 * Description:
 * Author: Tandingbo
 * Date: 2015/9/21 9:37
 */
public class Pager<T> {
    private List<T> list; //�����¼�����
    private int total = 0; // �ܼ�¼��
    private int limit = 20; // ÿҳ��ʾ��¼��
    private int pages = 1; // ��ҳ��
    private int pageNumber = 1; // ��ǰҳ

    private boolean isFirstPage = false;        //�Ƿ�Ϊ��һҳ
    private boolean isLastPage = false;         //�Ƿ�Ϊ���һҳ
    private boolean hasPreviousPage = false;   //�Ƿ���ǰһҳ
    private boolean hasNextPage = false;       //�Ƿ�����һҳ

    private int navigatePages = 8; //����ҳ����
    private int[] navigatePageNumbers;  //���е���ҳ��

    public Pager(int total, int pageNumber) {
        init(total, pageNumber, limit);
    }

    public Pager(int total, int pageNumber, int limit) {
        init(total, pageNumber, limit);
    }

    private void init(int total, int pageNumber, int limit) {
        //���û�������
        this.total = total;
        this.limit = limit;
        this.pages = (this.total - 1) / this.limit + 1;

        //����������ܴ���ĵ�ǰ��������Զ�����
        if (pageNumber < 1) {
            this.pageNumber = 1;
        } else if (pageNumber > this.pages) {
            this.pageNumber = this.pages;
        } else {
            this.pageNumber = pageNumber;
        }

        //���������趨֮����е���ҳ��ļ���
        calcNavigatePageNumbers();

        //�Լ�ҳ��߽���ж�
        judgePageBoudary();
    }

    /**
     * ���㵼��ҳ
     */
    private void calcNavigatePageNumbers() {
        //����ҳ��С�ڻ���ڵ���ҳ����ʱ
        if (pages <= navigatePages) {
            navigatePageNumbers = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatePageNumbers[i] = i + 1;
            }
        } else { //����ҳ�����ڵ���ҳ����ʱ
            navigatePageNumbers = new int[navigatePages];
            int startNum = pageNumber - navigatePages / 2;
            int endNum = pageNumber + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(��ǰnavigatePagesҳ
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNumbers[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //���navigatePagesҳ
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatePageNumbers[i] = endNum--;
                }
            } else {
                //�����м�ҳ
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNumbers[i] = startNum++;
                }
            }
        }
    }

    /**
     * �ж�ҳ��߽�
     */
    private void judgePageBoudary() {
        isFirstPage = pageNumber == 1;
        isLastPage = pageNumber == pages && pageNumber != 1;
        hasPreviousPage = pageNumber > 1;
        hasNextPage = pageNumber < pages;
    }


    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * �õ���ǰҳ������
     *
     * @return {List}
     */
    public List<T> getList() {
        return list;
    }

    /**
     * �õ���¼����
     *
     * @return {int}
     */
    public int getTotal() {
        return total;
    }

    /**
     * �õ�ÿҳ��ʾ��������¼
     *
     * @return {int}
     */
    public int getLimit() {
        return limit;
    }

    /**
     * �õ�ҳ������
     *
     * @return {int}
     */
    public int getPages() {
        return pages;
    }

    /**
     * �õ���ǰҳ��
     *
     * @return {int}
     */
    public int getPageNumber() {
        return pageNumber;
    }


    /**
     * �õ����е���ҳ��
     *
     * @return {int[]}
     */
    public int[] getNavigatePageNumbers() {
        return navigatePageNumbers;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public boolean hasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean hasNextPage() {
        return hasNextPage;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[")
                .append("total=").append(total)
                .append(",pages=").append(pages)
                .append(",pageNumber=").append(pageNumber)
                .append(",limit=").append(limit)
                .append(",isFirstPage=").append(isFirstPage)
                .append(",isLastPage=").append(isLastPage)
                .append(",hasPreviousPage=").append(hasPreviousPage)
                .append(",hasNextPage=").append(hasNextPage)
                .append(",navigatePageNumbers=");
        int len = navigatePageNumbers.length;
        if (len > 0) sb.append(navigatePageNumbers[0]);
        for (int i = 1; i < len; i++) {
            sb.append(" " + navigatePageNumbers[i]);
        }
        sb.append(",list.size=" + list.size());
        sb.append("]");
        return sb.toString();
    }
}
