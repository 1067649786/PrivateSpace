package com.lyh.zone.common.constant;

import com.google.common.collect.Lists;
import com.lyh.zone.entity.TbMenu;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：zone
 * 类名称：CommonConstant
 */
@Configuration
public class CommonConstant {

    public static String USER_ID_COOKIE = "lyh_ygy";
    public static String USER_COOKIE_SECRET = "lyh11";

    public static String DOMAIN_URL = "";
    public static String FILE_NAME_PREFIX = "lyh_";

    public static String ICON_UPLOAD_PATH="E:/毕业设计/情侣空间/lyh/upload/icon";
    public static String IMAGE_UPLOAD_PATH="E:/毕业设计/情侣空间/lyh/upload/image";

    /**
     * 最大页码
     */
    public static final int MAX_PAGE=100;

    /**
     * 分页条数
     */
    public static final int POST_INDEX_LIMIT=12;

    /**
     * 所有设置选项
     */
    public static Map<String,String> OPTIONS=new HashMap<>();

    /**
     * 所有菜单
     */
    public static List<TbMenu> MENUS=new ArrayList<>();

    public final static List<String> picExtList = Lists.newArrayList("jpg","png","gif","bmp","jpeg");
}
