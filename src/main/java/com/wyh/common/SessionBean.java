package com.wyh.common;


import com.wyh.entity.User;
import lombok.Data;
import privilege.PrivilegeBean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangwj on 16/3/5.
 */
@Data
public class SessionBean {

    private User user;

    private Set<PrivilegeBean> privileges = new HashSet<>();

}

