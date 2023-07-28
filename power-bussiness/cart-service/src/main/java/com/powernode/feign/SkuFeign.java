package com.powernode.feign;

import com.powernode.domain.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service",fallback = SkuFeignImpl.class)
public interface SkuFeign {

    @GetMapping("/prod/prod/getSkuListBySkuIds")
    List<Sku> getSkuListBySkuIds(@RequestParam("skuIds")List<Long> skuIds);
}
