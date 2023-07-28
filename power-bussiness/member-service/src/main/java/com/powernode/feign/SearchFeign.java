package com.powernode.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.model.ProdES;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "search-service")
public interface SearchFeign {

    @GetMapping("/prod/getProdPageByProdIds")
    Page<ProdES> getProdByProdIds(@RequestParam("params") String params);
}
