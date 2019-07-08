/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.flow;

import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 工单状态 TODO服务目录的工单状态需要统一调整为此状态
 *
 * @author Feixu
 * @version $Id: StatusEnum.java, v 0.1 2018/4/26 Feixu Exp $
 */
public enum StatusEnum {
    /** 开始 */
    START("START", "开始", new String[]{OperationTypeEnum.SUBMIT.getCode(), OperationTypeEnum.APPROVAL_SKIP.getCode(), OperationTypeEnum.EDIT.getCode()}),
    DRAFT("DRAFT", "草稿", new String[]{OperationTypeEnum.SUBMIT.getCode(), OperationTypeEnum.APPROVAL_SKIP.getCode(), OperationTypeEnum.EDIT.getCode(), OperationTypeEnum.DELETE.getCode()}),
    PENDING_APPROVAL("PENDING_APPROVAL", "待审核", new String[]{OperationTypeEnum.APPROVING_EDIT.getCode(), OperationTypeEnum.PASS.getCode(), OperationTypeEnum.REJECT.getCode(), OperationTypeEnum.WITHDRAW.getCode(), OperationTypeEnum.DISCARD.getCode()}),
    REJECTED("REJECTED", "未通过", new String[]{OperationTypeEnum.SUBMIT.getCode(), OperationTypeEnum.DISCARD.getCode()}),
    DELETED("DELETED", "已删除", null),
    DISCARDED("DISCARDED", "已废弃", null),
    PENDING_IMPLEMENTION("PENDING_IMPLEMENTION", "待实施", new String[]{OperationTypeEnum.APPLY.getCode()}),
    IMPLEMENTING("IMPLEMENTING", "实施中", new String[]{OperationTypeEnum.SUCCEED.getCode(), OperationTypeEnum.FAILED.getCode()}),
    SUCCEED("SUCCEED", "已成功", null),
    FAILED("FAILED", "已失败", null),
    ;

    /** code */
    private String code;
    /** desc */
    private String desc;
    /** actions */
    private String[] actions;

    /**
     * 构造
     *
     * @param code
     * @param desc
     * @param actions
     */
    StatusEnum(String code, String desc, String[] actions) {
        this.code = code;
        this.desc = desc;
        this.actions = actions;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getActions() {
        return actions;
    }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static StatusEnum getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }

        for (StatusEnum statusEnum :
                StatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return null;
    }

    /**
     * 获取此状态之前可能的状态
     *
     * @return
     */
    public static Set<StatusEnum> getPreviousStatus(StatusEnum cur) {
        Set<StatusEnum> ret = new HashSet<>();

        Set<OperationTypeEnum> operations = new HashSet<>();
        for (OperationTypeEnum operation : OperationTypeEnum.values()) {
            if (null != operation.getResultStatus()) {
                for (String resultStatus : operation.getResultStatus()) {
                    if (resultStatus.equals(cur.code)) {
                        operations.add(operation);
                    }
                }
            }
        }

        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (null != statusEnum.actions) {
                for (int i = 0; i < statusEnum.actions.length; i++) {
                    boolean isBreak = false;
                    for (OperationTypeEnum operation : operations) {
                        if (operation.getCode().equals(statusEnum.actions[i])) {
                            ret.add(statusEnum);
                            isBreak = true;
                            break;
                        }
                    }
                    if (isBreak) {
                        break;
                    }
                }
            }
        }
        return ret;
    }

    /**
     * 获取此状态操作可能导致的结果
     *
     * @return
     */
    public static Set<StatusEnum> getNextStatus(StatusEnum cur) {
        Set<StatusEnum> ret = new HashSet<>();

        if (null != cur.actions) {
            for (String action : cur.actions) {
                OperationTypeEnum operation = OperationTypeEnum
                    .getByCode(action);
                if (null != operation && null != operation.getResultStatus()) {
                    for (String status : operation.getResultStatus()) {
                        StatusEnum statusEnum = StatusEnum.getByCode(status);
                        if (null != statusEnum) {
                            ret.add(statusEnum);
                        }
                    }
                }

            }
        }

        return ret;
    }
}
