package com.ldd.dao.entity.role;

/**
 * <p>功能描述：</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 刘大德</p>
 *
 * @author Mr.Liu
 * @version 1.0 2016/5/10 10:20
 */
public class TbRole {
    private int roleId;
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
