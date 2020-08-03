package com.offerget.cndengzw.tiny.controller;

import com.offerget.cndengzw.tiny.common.api.CommonPage;
import com.offerget.cndengzw.tiny.common.api.CommonResult;
import com.offerget.cndengzw.tiny.mbg.model.PmsBrand;
import com.offerget.cndengzw.tiny.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Deng Zhiwen
 * @date 2020/8/1 10:26
 */
@Api(tags = "PmsBrandController", description = "商品品牌")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    public static final Logger log = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("展示品牌列表")
    @GetMapping("listAll")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("增加品牌")
    @PostMapping("create")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            log.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新品牌")
    @PostMapping("update/{id}")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            log.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    @ApiOperation("删除品牌")
    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页展示")
    @GetMapping("list")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("根据 id 查询")
    @GetMapping("{id}")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}
