package privilege;

/**
 * Created by zhangwj on 16/3/5.
 */
public enum PrivilegeBean {

    USER_ADD("添加用户", "USER", "用户权限相关"),
    USER_ALTER("修改用户", "USER", "用户权限相关"),
    USER_DELETE("删除用户", "USER", "用户权限相关");

    private PrivilegeBean(String key, String group, String description) {
        this.key = key;
        this.description = description;
        this.group = group;
    }

    private final String key;
    private final String description;
    private final String group;

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public String getGroup() {
        return group;
    }

}
