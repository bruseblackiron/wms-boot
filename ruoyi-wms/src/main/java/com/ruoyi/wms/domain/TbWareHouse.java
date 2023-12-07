package com.ruoyi.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库对象 tb_ware_house
 *
 * @author sjz
 * @date 2023-12-07
 */
public class TbWareHouse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 仓库名称
     */
    @Excel(name = "仓库名称")
    private String wareHouseName;

    /**
     * 是否发布 0:未发布 1:已发布
     */
    @Excel(name = "是否发布 0:未发布 1:已发布")
    private Integer isPublish;

    /**
     * 是否删除 0:未删除 1:已删除
     */
    private Integer isDelete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("wareHouseName", getWareHouseName())
                .append("isPublish", getIsPublish())
                .append("isDelete", getIsDelete())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
