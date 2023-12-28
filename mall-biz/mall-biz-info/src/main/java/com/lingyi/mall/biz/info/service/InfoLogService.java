package com.lingyi.mall.biz.info.service;

import com.lingyi.mall.biz.info.model.dto.InfoLogDTO;
import com.lingyi.mall.biz.info.model.entity.InfoLogDO;
import com.lingyi.mall.biz.info.model.param.InfoLogQuery;
import com.lingyi.mall.biz.info.model.vo.InfoLogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:19
 * @description
 */
@Service
public interface InfoLogService extends BaseServicePro<InfoLogDTO, InfoLogVO, InfoLogQuery, InfoLogDO, Long> {

}
