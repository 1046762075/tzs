package com.bz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bz.dao.MonthSettleDao;
import com.bz.dao.MonthSettleDescDao;
import com.bz.dao.OrderGoodsDao;
import com.bz.dao.OrderInfoDao;
import com.bz.dao.zz.CustomerEnDao;
import com.bz.dao.zz.GoodsDao;
import com.bz.entity.Goods;
import com.bz.entity.MonthSettleDesc;
import com.bz.entity.OrderGoods;
import com.bz.entity.OrderInfo;
import com.bz.entity.zz.CustomerEn;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

@SpringBootTest
class TzsApplicationTests {


	@Autowired
	private MonthSettleDao monthSettleDao;

	@Autowired
	private CustomerEnDao customerEnDao;

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Autowired
	private OrderGoodsDao orderGoodsDao;

	@Autowired
	private MonthSettleDescDao monthSettleDescDao;

	/**
	 * 山东月结导入
	 */
	@Test
	public void month(){
		// 库存主体
		Long deliveryStaffId = 47L;

		Long honeycombId = 66L;
		Long honeycombGridId = 85L;
		TreeMap<String, String> names = new TreeMap<>();
		// 创建人
		Long creator = 1L;
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM");
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy.M");
		List<MonthSettleDesc> monthSettleDescs = monthSettleDescDao.selectList(new QueryWrapper<>());
		for (MonthSettleDesc monthSettleDesc : monthSettleDescs) {
			Date date;
			try {
				date = simpleDateFormat.parse(monthSettleDesc.getCreateTime());
			} catch (ParseException e) {
				try {
					date = simpleDateFormat1.parse(monthSettleDesc.getCreateTime());
				} catch (ParseException ex) {
					date = new Date();
				}
			}
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setCreateTime(date);
			orderInfo.setCreator(creator);
			orderInfo.setCustomerName(monthSettleDesc.getCustomerName());
			orderInfo.setDeliveryStatus(2);
			orderInfo.setOrderStatus(0);
			orderInfo.setOrderNo("YLH" + sdf.format(date));
			orderInfo.setOrderType(1);
			// 1 待月结 2: 待扎帐 3: 已扎帐
			orderInfo.setMonthSettleStatus(1);
			orderInfo.setRealPrice(new BigDecimal("0"));
			orderInfo.setTotalPrice(monthSettleDesc.getTotalPrice());
			orderInfo.setPayMode("2");
			orderInfo.setCompleteTime(date);
			orderInfo.setExpectStartTime(date);
			orderInfo.setExpectEndTime(date);
			orderInfo.setDeliveryStaffId(deliveryStaffId);
			orderInfo.setScStockMainId(deliveryStaffId);
			orderInfo.setTakeTime(date);
			// 应收金额
			orderInfo.setReceivablePrice(monthSettleDesc.getTotalPrice());
			// 月结实收金额
//			orderInfo.setMonthSettlePrice(new BigDecimal("0"));
			// 客户信息
			List<CustomerEn> customers = customerEnDao.selectList(new QueryWrapper<CustomerEn>().eq("customer_name", monthSettleDesc.getCustomerName()));
			if(customers.size() > 0){
				orderInfo.setCustomerId(customers.get(0).getId());
				orderInfo.setCustomerTypeName(customers.get(0).getCustomerTypeId() == 6 ? "终端客户" : customers.get(0).getCustomerTypeId() == 5 ? "协议客户": "超市代销（经销商）");
				orderInfo.setCustomerPhone(customers.get(0).getPhone());
				orderInfo.setHoneycombGridId(customers.get(0).getHoneycombGridId());
				orderInfo.setHoneycombId(customers.get(0).getHoneycombId());
			}else {
				names.put(monthSettleDesc.getCustomerName(), "");
//				CustomerEn customerEn = new CustomerEn();
//				customerEn.setPhone("");
//				customerEn.setCustomerStatus(0);
//				customerEn.setContacts(monthSettleDesc.getCustomerName());
//				customerEn.setSourceType(0);
//				customerEn.setCreator(1L);
//				customerEn.setCustomerTags("月结导入");
//				customerEn.setCustomerName(monthSettleDesc.getCustomerName());
//				customerEn.setHoneycombGridId(honeycombGridId);
//				customerEn.setHoneycombId(honeycombId);
//				customerEn.setCustomerTypeId(6L);
//				customerEn.setCreateTime(date);
//				customerEnDao.insert(customerEn);
//				orderInfo.setCustomerId(customerEn.getId());
//				orderInfo.setHoneycombGridId(customerEn.getHoneycombGridId());
//				orderInfo.setHoneycombId(customerEn.getHoneycombId());
				continue;
			}
			orderInfoDao.insert(orderInfo);
			OrderGoods orderGoods = new OrderGoods();
			List<Goods> goods = goodsDao.selectList(new QueryWrapper<Goods>().eq("goods_name", monthSettleDesc.getGoods()));
			if(goods.size() > 0){
				orderGoods.setGoodsId(goods.get(0).getId());
			}
			orderGoods.setOrderId(orderInfo.getId());
			orderGoods.setGoodsName(monthSettleDesc.getGoods());
			// 月结抵扣数量 必须大于0
			orderGoods.setMonthDeductNum(monthSettleDesc.getNum());
			orderGoods.setGoodsNum(monthSettleDesc.getNum());
			orderGoods.setGoodsPrice(monthSettleDesc.getUnitPrice());
			orderGoodsDao.insert(orderGoods);
		}
		System.out.println(names.size() + "========================================================" + names.keySet());
	}

}
