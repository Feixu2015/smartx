/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.tree

/**
 * 节点
 *
 * @author Feixu
 * @version $Id: FxNode.java, v 0.1 2018/3/13 Feixu Exp $
 */
class FxNode {
    List<FxNode> froms
    List<FxNode> tos
    String name
    String remark

    void addBefore(FxNode node) {
        if (null == froms) {
            froms = new ArrayList<>()
        }
        froms.add(node)
    }

    void addAfter(FxNode node) {
        if (null == tos) {
            tos = new ArrayList<>()
        }
        tos.add(node)
    }

    boolean removeBefore(FxNode node) {
        if (null != froms && froms.contains(node)) {
            node.removeAfter(this)
            return froms.remove(node)
        }
        return false
    }

    boolean removeAfter(FxNode node) {
        if (null != tos && tos.contains(node)) {
            node.removeBefore(node)
            return tos.remove(node)
        }
        return false
    }
}
