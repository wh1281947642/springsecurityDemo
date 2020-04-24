package com.itheima.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <code>UserDetailsService</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/04/23 14:51
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("经过UserDetailsServiceImpl");
        //实际项目中应该从数据库中提取用户的角色列表
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(s, "$2a$10$vYbs4YPhIsJ65V/IMJsfROp4ypMjyN8Ia.noS8C/cJducGYUPU07G", grantedAuths);
    }
}
