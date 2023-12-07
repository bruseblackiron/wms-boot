package com.ruoyi.wms.service;

import java.util.List;

import com.ruoyi.wms.domain.TbWareHouse;

/**
 * 仓库Service接口
 *
 * @author sjz
 * @date 2023-12-07
 */
public interface ITbWareHouseService {
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
     * 批量删除仓库
     *
     * @param ids 需要删除的仓库主键集合
     * @return 结果
     */
    public int deleteTbWareHouseByIds(Long[] ids);

    /**
     * 删除仓库信息
     *
     * @param id 仓库主键
     * @return 结果
     */
    public int deleteTbWareHouseById(Long id);

    /**
     * 启用或禁用仓库
     * @param id 仓库id
     * @param publishValue 启用/禁用
     * @return --
     */
    int updateTbWareHousePublish(Long id, Integer publishValue);
}
