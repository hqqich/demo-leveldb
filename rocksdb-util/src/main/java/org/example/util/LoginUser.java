package org.example.util;

/**
 * Created by ChenHao on 2022/8/11 is 15:02.
 *
 * @author hqqich <hqqich1314@outlook.com>
 * @version V1.0.0
 * @description
 * @date 2022/8/11
 * @since 1.0
 */

public class LoginUser {


    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;


    public LoginUser() {
    }

    public LoginUser(Long userId, Long deptId) {
        this.userId = userId;
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
            "userId=" + userId +
            ", deptId=" + deptId +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginUser loginUser = (LoginUser) o;

        if (userId != null ? !userId.equals(loginUser.userId) : loginUser.userId != null) {
            return false;
        }
        return deptId != null ? deptId.equals(loginUser.deptId) : loginUser.deptId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        return result;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}