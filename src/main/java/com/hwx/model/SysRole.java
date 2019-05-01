package com.hwx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author hwx
 * @since 2019-04-30
 */
@TableName("sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("role_name")
    private String roleName;
    private Integer avilable;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getAvilable() {
        return avilable;
    }

    public void setAvilable(Integer avilable) {
        this.avilable = avilable;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                ", id=" + id +
                ", roleName=" + roleName +
                ", avilable=" + avilable +
                "}";
    }
}
