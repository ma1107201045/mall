package com.lingyi.mall.common.jdbc.util;


import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.jdbc.dto.BaseIdDTO;
import com.lingyi.mall.common.jdbc.entity.BaseIdDO;
import com.lingyi.mall.common.jdbc.param.BasePageParam;
import com.lingyi.mall.common.jdbc.vo.BaseIdVO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 9:51
 * @Description:
 */
@Getter
@Setter
public class BaseServicePlusImpl<J extends JpaRepositoryImplementation<T, ID>,
        M extends MybatisMapperImplementation<ID, PARAM, VO>,
        T extends BaseIdDO,
        DTO extends BaseIdDTO<ID>,
        PARAM extends BasePageParam,
        VO extends BaseIdVO<ID>,
        ID extends Serializable> implements BaseServicePlus<T, DTO, PARAM, VO, ID> {

    protected J jpaRepositoryImplementation;

    protected M mybatisMapper;


    public void create(DTO dto, Class<T> clazz) {
        T t = ConverterUtil.to(dto, clazz);
        jpaRepositoryImplementation.save(t);
    }


    @Override
    public void deleteByIds(List<ID> ids) {
        jpaRepositoryImplementation.deleteAllByIdInBatch(ids);
    }


    public void updateById(DTO dto) {
        Optional<T> optional = jpaRepositoryImplementation.findById(dto.getId());
        if (optional.isPresent()) {
            T t = optional.get();
            ConverterUtil.to(dto, t);
            jpaRepositoryImplementation.save(t);
        }
    }

    public VO readById(ID id) {
        return mybatisMapper.selectById(id);

    }

    public List<VO> readListByParam(PARAM param) {
        return mybatisMapper.selectListByParam(param);
    }


}