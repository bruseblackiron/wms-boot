package com.ruoyi.web.controller.wms;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wms.domain.TbWareHouse;
import com.ruoyi.wms.service.ITbWareHouseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库Controller
 *
 * @author sjz
 * @date 2023-12-07
 */
@RestController
@RequestMapping("/wms/house")
public class TbWareHouseController extends BaseController {
    @Autowired
    private ITbWareHouseService tbWareHouseService;

    /**
     * 查询仓库列表
     */
    @PreAuthorize("@ss.hasPermi('wms:house:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbWareHouse tbWareHouse) {
        startPage();
        List<TbWareHouse> list = tbWareHouseService.selectTbWareHouseList(tbWareHouse);
        return getDataTable(list);
    }

    /**
     * 导出仓库列表
     */
    @PreAuthorize("@ss.hasPermi('wms:house:export')")
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbWareHouse tbWareHouse) {
        List<TbWareHouse> list = tbWareHouseService.selectTbWareHouseList(tbWareHouse);
        ExcelUtil<TbWareHouse> util = new ExcelUtil<TbWareHouse>(TbWareHouse.class);
        util.exportExcel(response, list, "仓库数据");
    }

    /**
     * 获取仓库详细信息
     */
    @PreAuthorize("@ss.hasPermi('wms:house:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tbWareHouseService.selectTbWareHouseById(id));
    }

    /**
     * 新增仓库
     */
    @PreAuthorize("@ss.hasPermi('wms:house:add')")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbWareHouse tbWareHouse) {
        return toAjax(tbWareHouseService.insertTbWareHouse(tbWareHouse));
    }

    /**
     * 修改仓库
     */
    @PreAuthorize("@ss.hasPermi('wms:house:edit')")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbWareHouse tbWareHouse) {
        return toAjax(tbWareHouseService.updateTbWareHouse(tbWareHouse));
    }

    /**
     * 删除仓库
     */
    @PreAuthorize("@ss.hasPermi('wms:house:remove')")
    @Log(title = "仓库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tbWareHouseService.deleteTbWareHouseByIds(ids));
    }

    /**
     * 启用和禁用仓库
     */
    @PreAuthorize("@ss.hasPermi('wms:house:publish')")
    @PostMapping(value = "/publish/{id}/{publishValue}")
    public AjaxResult taggerPublish(@PathVariable("id") Long id, @PathVariable("publishValue") Integer publishValue) {
        return AjaxResult.success(tbWareHouseService.updateTbWareHousePublish(id, publishValue));
    }
}
