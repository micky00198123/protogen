package com.qklt.protogen.service.main.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qklt.protogen.entity.Expression;
import com.qklt.protogen.service.main.ExpLedService;
import org.springframework.stereotype.Service;

@Service
public class ExpLedServiceImpl implements ExpLedService {

    @Override
    public Expression getExp(Integer id) {
        return new Expression().selectById(id);
    }

    @Override
    public Integer countExpNum() {
        return new Expression().selectCount(new QueryWrapper<>());
    }

}
