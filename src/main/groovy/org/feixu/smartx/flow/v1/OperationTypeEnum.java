/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.flow.v1;

import org.springframework.util.StringUtils;

/**
 * 【服务项实例】工单操作枚举 TODO
 *
 * @author jinbo
 * @version $Id: OrderOperateEnum.java, v 0.1 2017年3月10日 下午4:42:04 jinbo Exp $
 */
public enum OperationTypeEnum {
    /** 草稿 */
    EDIT("EDIT", "保存草稿", new String[]{"DRAFT"}),
    /** 删除草稿（暂未使用） */
    DELETE("DELETE", "删除草稿", new String[]{"DELETED"}),
    SUBMIT("SUBMIT", "申请", new String[]{"PENDING_APPROVAL"}),
    WITHDRAW("WITHDRAW", "撤回工单", new String[]{"DRAFT"}),
    APPROVING_EDIT("APPROVAL_EDIT", "审核编辑", new String[]{"PENDING_APPROVAL"}),
    REJECT("REJECT", "审核退回", new String[]{"REJECTED"}),
    PASS("PASS", "审核通过", new String[]{"PENDING_IMPLEMENTION"}),
    APPLY("APPLY", "实施工单", new String[]{"IMPLEMENTING"}),
    DISCARD("DISCARD", "废弃工单", new String[]{"DISCARDED"}),
    SUCCEED("SUCCEED", "成功", new String[]{"SUCCEED"}),
    FAILED("FAILED", "失败", new String[]{"FAILED"});

    /** 枚举Code */
    private String code;

    /** 枚举描述 */
    private String desc;

    /** 结果状态 */
    private String[] resultStatusArray;

    OperationTypeEnum(String code, String desc, String[] resultStatusArray) {
        this.code = code;
        this.desc = desc;
        this.resultStatusArray = resultStatusArray;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getResultStatus() {
        return resultStatusArray;
    }

    /**
     * 根据CODE获取枚举
     *
     * @param code
     * @return
     */
    public static OperationTypeEnum getByCode(String code) {
        if (!StringUtils.isEmpty(code)) {
            for (OperationTypeEnum orderOperate : OperationTypeEnum.values()) {
                if(orderOperate.code.equals(code)){
                    return orderOperate;
                }
            }
        }
        return null;
    }
}
