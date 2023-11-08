package org.pet.home.utils;

import org.pet.home.entity.Department;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/29
 **/
public class DepartmentTreeUtil {
    /**
     * list 转 tree
     * @param nodes
     * @return
     */
    public static List<Department> listToTree(List<Department> nodes) {
        // 创建一个根节点
        Department root = new Department();
        root.setId(0L); // 设置根节点的id为0
        root.setParentId(null); // 设置根节点的parentId为null
        root.setChildren(new ArrayList<>()); // 初始化根节点的子节点列表

        // 将根节点添加到nodes列表的开头
        nodes.add(0, root);

        // 将这些非顶级节点的数据按pid进行分组
        Map<Long, List<Department>> nodeMap = nodes.stream()
                .filter(node -> node.getParentId() != null) // 过滤掉根节点
                .collect(Collectors.groupingBy(node -> node.getParent().getId()));

        // 循环设置对应的子节点（根据id = pid）
        nodes.forEach(node -> node.setChildren(nodeMap.getOrDefault(node.getId(), Collections.emptyList())));

        // 过滤第一层不是Pid为零的数据，也就是没有根节点的数据
        List<Department> treeNode = nodes.stream()
                .filter(node -> node.getParentId() == null)
                .collect(Collectors.toList());

        return treeNode;
    }
}
