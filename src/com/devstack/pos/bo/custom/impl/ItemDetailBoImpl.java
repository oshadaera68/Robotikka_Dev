package com.devstack.pos.bo.custom.impl;

import com.devstack.pos.bo.custom.ItemDetailBo;
import com.devstack.pos.dao.DaoFactory;
import com.devstack.pos.dao.custom.ItemDetailDao;
import com.devstack.pos.dto.ItemDetailDto;
import com.devstack.pos.entity.ItemDetail;
import com.devstack.pos.enums.DaoType;

import java.sql.SQLException;

public class ItemDetailBoImpl implements ItemDetailBo {
    ItemDetailDao dao= DaoFactory.getInstance().getDao(DaoType.ITEM_DETAIL);
    @Override
    public boolean saveItemDetail(ItemDetailDto d) throws SQLException, ClassNotFoundException {
        return dao.save(
                new ItemDetail(d.getDetailCode(),d.getOrder(),d.getQty(),d.getDiscount(),d.getAmount())
        );
    }
}
