package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpinfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinfenleiView;


/**
 * 账号分类
 *
 * @author 
 * @email 
 * @date 2023-03-08 09:39:22
 */
public interface ShangpinfenleiService extends IService<ShangpinfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpinfenleiVO> selectListVO(Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	ShangpinfenleiVO selectVO(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	List<ShangpinfenleiView> selectListView(Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	ShangpinfenleiView selectView(@Param("ew") Wrapper<ShangpinfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinfenleiEntity> wrapper);
   	

}

