package com.offerget.cndengzw.tiny.service.Impl;

import com.github.pagehelper.PageHelper;
import com.offerget.cndengzw.tiny.mbg.mapper.PmsBrandMapper;
import com.offerget.cndengzw.tiny.mbg.model.PmsBrand;
import com.offerget.cndengzw.tiny.mbg.model.PmsBrandExample;
import com.offerget.cndengzw.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Deng Zhiwen
 * @date 2020/8/1 10:41
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return brandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrandDto) {
        pmsBrandDto.setId(id);
        return brandMapper.updateByPrimaryKeySelective(pmsBrandDto);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
