/**
 *
 * http://www.idcos.com
 * Copyright (c) 2015-2017 All Rights Reserved.
 */

package org.feixu.smartx.other;

// auto generated imports

import java.io.Serializable;
import java.util.Date;


/**
 * 返回结果对象 EquipmentVO
 * <p>第一次由自动生成代码工具初始化，后续可以编辑，再次生成的时候不会进行覆盖</p>
 *
 * @author wangyue
 * @version EquipmentVO.java, v 1.1 2017-10-01 11:34:27 wangyue Exp $
 */

public class EquipmentVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String code;
    private String type;
    private String brand;
    private String model;
    private String serial;
    private String repertory;
    private Date storageTime;
    private Date unpackingTime;
    private String status;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getRepertory() {
        return repertory;
    }

    public void setRepertory(String repertory) {
        this.repertory = repertory;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    public Date getUnpackingTime() {
        return unpackingTime;
    }

    public void setUnpackingTime(Date unpackingTime) {
        this.unpackingTime = unpackingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}