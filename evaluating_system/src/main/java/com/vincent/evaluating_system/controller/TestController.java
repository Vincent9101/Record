package com.vincent.evaluating_system.controller;

import com.vincent.evaluating_system.entity.EntityPermission;
import com.vincent.evaluating_system.entity.EntityRole;
import com.vincent.evaluating_system.service.EntityPermissionService;
import com.vincent.evaluating_system.service.EntityRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.Date;

/**
 * Created by IDEA on 2019/4/4
 * User: Vincent
 * Time：22:25
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private EntityRoleService roleService;
    @Autowired
    private EntityPermissionService permissionService;

//    @GetMapping("/addRole")
//    public Boolean add(@RequestParam(value = "value") String roleValue, @RequestParam(value = "desc") String roleDesc) {
//        EntityRole role = new EntityRole();
//        role.setCreated(new Date());
//        role.setRoleDesc(roleDesc);
//        role.setRoleValue(roleValue);
//        return roleService.insert(role);
//    }
//
//    @GetMapping("/addPerm")
//    public Boolean addPermission(@RequestParam(value = "value") String permValue, @RequestParam(value = "desc") String permDesc) {
//        return permissionService.insert(new EntityPermission(permValue, permDesc, new Date()));
//    }


//    @RequestMapping("/test")
//    @ResponseBody
//    public String test() {
//        return "这是一个测试";
//    }
//
//    @RequestMapping("/hello")
//    @ResponseBody
//    @RequiresRoles("")
//    @RequiresPermissions("")
//    public String hello() {
//        return "您好哦啊";
//    }

}
