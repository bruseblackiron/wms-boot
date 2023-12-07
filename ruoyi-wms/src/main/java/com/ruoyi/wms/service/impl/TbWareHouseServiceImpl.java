package com.ruoyi.wms.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.common.utils.DateUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wms.mapper.TbWareHouseMapper;
import com.ruoyi.wms.domain.TbWareHouse;
import com.ruoyi.wms.service.ITbWareHouseService;

/**
 * 仓库Service业务层处理
 *
 * @author sjz
 * @date 2023-12-07
 */
@Service
public class TbWareHouseServiceImpl implements ITbWareHouseService {
    @Autowired
    private TbWareHouseMapper tbWareHouseMapper;

    /**
     * 查询仓库
     *
     * @param id 仓库主键
     * @return 仓库
     */
    @Override
    public TbWareHouse selectTbWareHouseById(Long id) {
        return tbWareHouseMapper.selectTbWareHouseById(id);
    }

    /**
     * 查询仓库列表
     *
     * @param tbWareHouse 仓库
     * @return 仓库
     */
    @Override
    public List<TbWareHouse> selectTbWareHouseList(TbWareHouse tbWareHouse) {
        return tbWareHouseMapper.selectTbWareHouseList(tbWareHouse);
    }

    /**
     * 新增仓库
     *
     * @param tbWareHouse 仓库
     * @return 结果
     */
    @Override
    public int insertTbWareHouse(TbWareHouse tbWareHouse) {
        //判断仓库名称的唯一性
        TbWareHouse tbWareHouseUnique = tbWareHouseMapper.checkHouseNameUnique(tbWareHouse);
        if(ObjectUtils.isNotEmpty(tbWareHouseUnique)){
            throw new ServiceException("新增失败，仓库名称已经存在！");
        }
        tbWareHouse.setCreateTime(DateUtils.getNowDate());
        return tbWareHouseMapper.insertTbWareHouse(tbWareHouse);
    }

    /**
     * 修改仓库
     *
     * @param tbWareHouse 仓库
     * @return 结果
     */
    @Override
    public int updateTbWareHouse(TbWareHouse tbWareHouse) {
        //判断仓库名称的唯一性
        TbWareHouse tbWareHouseUnique = tbWareHouseMapper.checkHouseNameUnique(tbWareHouse);
        if(ObjectUtils.isNotEmpty(tbWareHouseUnique)){
            throw new ServiceException("修改失败，仓库名称已经存在！");
        }
        tbWareHouse.setUpdateTime(DateUtils.getNowDate());
        return tbWareHouseMapper.updateTbWareHouse(tbWareHouse);
    }

    /**
     * 批量删除仓库
     *
     * @param ids 需要删除的仓库主键
     * @return 结果
     */
    @Override
    public int deleteTbWareHouseByIds(Long[] ids) {
        return tbWareHouseMapper.deleteTbWareHouseByIds(ids);
    }

    /**
     * 删除仓库信息
     *
     * @param id 仓库主键
     * @return 结果
     */
    @Override
    public int deleteTbWareHouseById(Long id) {
        return tbWareHouseMapper.deleteTbWareHouseById(id);
    }

    @Override
    public int updateTbWareHousePublish(Long id, Integer publishValue) {
        return tbWareHouseMapper.updateTbWareHousePublish(id, publishValue);
    }
}
