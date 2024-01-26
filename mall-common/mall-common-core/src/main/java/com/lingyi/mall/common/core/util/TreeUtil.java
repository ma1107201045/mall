package com.lingyi.mall.common.core.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/26 12:13
 * @Description:
 */
public class TreeUtil {


    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class Tree<ID extends Number, N extends Tree<ID, N>> extends BaseIdVO<ID> {
        @Serial
        private static final long serialVersionUID = -8241116141835987022L;

        @Schema(description = "父级id")
        private ID parentId;

        @Schema(description = "子节点")
        private List<N> children;


    }

    public static <ID extends Number, N extends Tree<ID, N>> List<N> build(ID parentId, List<N> nodes) {
        return nodes.stream()
                .filter(tree -> tree.getParentId().equals(parentId))
                .peek(tree -> tree.setChildren(build(tree.getId(), nodes)))
                .toList();
    }

    public static <ID extends Number, N extends Tree<ID, N>> List<N> buildOfReduce(List<N> nodes) {
        Map<ID, N> map = MapUtil.newHashMap();
        return nodes.stream().reduce(new ArrayList<>(), (tree, node) -> {
            map.put(node.getId(), node);
            add(tree, map, node);
            return tree;
        }, (tree01, tree02) -> tree01);
    }

    public static <ID extends Number, N extends Tree<ID, N>> List<N> buildOfMap(List<N> nodes) {
        Map<ID, N> map = nodes.stream().collect(Collectors.toMap(Tree::getId, tree -> tree));
        List<N> tree = CollUtil.newArrayList();
        map.values().forEach(node -> {
            add(tree, map, node);
        });
        return tree;
    }

    private static <ID extends Number, N extends Tree<ID, N>> void add(List<N> tree, Map<ID, N> map, N node) {
        if (BaseConstant.TREE_ROOT_PARENT_ID.equals(node.getParentId())) {
            tree.add(node);
        } else {
            List<N> children = map.get(node.getParentId()).getChildren();
            if (CollUtil.isEmpty(children)) {
                children = CollUtil.newArrayList();
            }
            children.add(node);
        }
    }

}
