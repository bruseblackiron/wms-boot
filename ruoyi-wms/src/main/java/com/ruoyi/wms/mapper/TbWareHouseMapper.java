package com.ruoyi.wms.mapper;

import java.util.List;

import com.ruoyi.wms.domain.TbWareHouse;
import org.apache.ibatis.annotations.Param;

/**
 * 仓库Mapper接口
 *
 * @author sjz
 * @date 2023-12-07
 */
public interface TbWareHouseMapper {
    /**
     * 查询仓库
     *
     * @param id 仓库主键
     * @return 仓库
     */
    public TbWareHouse selectTbWareHouseById(Long id);

    /**
     * 查询仓库列表
     *
     * @param tbWareHouse 仓库
     * @return 仓库集合
     */
    public List<TbWareHouse> selectTbWareHouseList(TbWareHouse tbWareHouse);

    /**
     * 新增仓库
     *
     * @param tbWareHouse 仓库
     * @return 结果
     */
    public int insertTbWareHouse(TbWareHouse tbWareHouse);

    /**
     * 修改仓库
     *
     * @param tbWareHouse 仓库
     * @return 结果
     */
    public int updateTbWareHouse(TbWareHouse tbWareHouse);

    /**
     * 删除仓库
     *
     * @param id 仓库主键
     * @return 结果
     */
    public int deleteTbWareHouseById(Long id);

    /**
     * 批量删除仓库
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbWareHouseByIds(Long[] ids);

    /**
     * 判断新增修改仓库的名称唯一性
     * @param tbWareHouse --
     * @return --
     */
    TbWareHouse checkHouseNameUnique(TbWareHouse tbWareHouse);

    /**
     * 启用或禁用仓库
     * @param id 仓库id
     * @param publishValue 启用/禁用
     * @return --
     */
    int updateTbWareHousePublish(@Param("id") Long id, @Param("publishValue") Integer publishValue);

}
