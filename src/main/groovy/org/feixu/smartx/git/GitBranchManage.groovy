/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.git

/**
*
 *
 * @author Feixu
 * @version $Id: GitBranchManage.java, v 0.1 2018/3/20 Feixu Exp $
 */
class GitBranchManage {
    static void generateDeleteBranch(branchLines){
        branchLines.eachLine {
            if (it) {
                println "git branch -D ${it.trim()}"
            }
        }
    }
}
