package com.lyh.zone.dto;

/**
 * 项目名称：zone
 * 类名称：MenuDTO
 * 类描述：
 */
public class MenuDTO {

    private Integer uid;
    /**
     * 图标
     */
    private String menuIcon;

    private String menuName;

    private Integer menuSort;

    private String menuTarget;

    private String menuUrl;

    public MenuDTO(Integer uid, String menuIcon, String menuName, Integer menuSort, String menuTarget, String menuUrl) {
        this.uid = uid;
        this.menuIcon = menuIcon;
        this.menuName = menuName;
        this.menuSort = menuSort;
        this.menuTarget = menuTarget;
        this.menuUrl = menuUrl;
    }

    public MenuDTO() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
