package com.offerget.cndengzw.tiny.service;

import com.offerget.cndengzw.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author Deng Zhiwen
 * @date 2020/8/1 10:29
 */

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrandDto);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(Integer pageNum, Integer pageSize);

    PmsBrand getBrand(Long id);
}
