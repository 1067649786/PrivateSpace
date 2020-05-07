package com.lyh.zone.common.enums;

/**
 * 项目名称：zone
 * 类名称：ResultEnum
 */
public enum ResultEnum {

    SUCCESS("0000","操作成功"),
    FAIL("0001","操作失败"),
    NICKNAME_EXIST("0002","昵称已经存在"),
    USER_NOT_LOGIN("0003","用户未登陆"),
    BIND_CODE_ERROR("00004","绑定码错误"),
    PARAM_NULL("0005","参数不能为空~"),

    STR_LENGTH_TOO_LONG("0008","字符串长度超过限制了~"),
    USER_NOT_SAME("0009","用户信息不一致~"),
    PASSWORD_LENGTH_ERROR("0010","密码长度必须是6~20位~"),
    USERNAME_EXIST("0012","账号名称已经存在~"),
    FILE_TOO_LARGE("0014","上传文件过大"),
    PASSWORD_TOO_SIMPLE("0015","密码太过简单"),
    VERIFY_CODE_NOT_CORRECT("0020","验证码不正确"),
    USERNAME_OR_PASSWORD_ERROR("0026","用户名或密码错误"),
    PIC_EXTNAME_NOT_RIGHT("0029","图片后缀名不正确"),

    ;

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
