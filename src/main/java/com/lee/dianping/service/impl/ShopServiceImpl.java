package com.lee.dianping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.dianping.common.BusinessException;
import com.lee.dianping.common.EmBusinessError;
import com.lee.dianping.entity.Category;
import com.lee.dianping.entity.Seller;
import com.lee.dianping.entity.Shop;
import com.lee.dianping.mapper.ShopMapper;
import com.lee.dianping.service.ICategoryService;
import com.lee.dianping.service.ISellerService;
import com.lee.dianping.service.IShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 门店服务实现
 * @Author 61671
 * @Date 2022/9/5 16:21
 * @Version 1.0.0
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private ISellerService sellerService;

    @Resource
    private ICategoryService categoryService;

    @Override
    public int create(Shop shop) throws BusinessException {

        //1、校验商家是否存在
        Seller seller = this.sellerService.getById(shop.getSellerId());
        if(seller == null){
            throw new BusinessException(EmBusinessError.SELLER_NOT_EXIST);
        }
        //2、校验商家是否禁用
        if(seller.getDisabledFlag() == 1){
            throw new BusinessException(EmBusinessError.SELLER_DISABLED);
        }
        //3、校验品类是否存在
        Category category = this.categoryService.getById(shop.getCategoryId());
        if(category == null){
            throw new BusinessException(EmBusinessError.CATEGORY_NOT_EXIST);
        }
        //4、保存门店
        boolean result = this.save(shop);

        return result ? 1 : 0;
    }

    @Override
    public List<Shop> getAllWithAssociation() {
        return this.getBaseMapper().getAllWithAssociation();
    }


}
