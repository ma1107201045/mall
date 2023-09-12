package com.lingyi.mall.common.orm.util;


import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import com.lingyi.mall.common.orm.entity.BaseIdDO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.vo.BaseIdVO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 9:51
 * @Description:
 */
@Getter
@Setter
public class BaseServiceProImpl<
        J extends JpaRepositoryImplementation<DO, ID>,
        M extends MybatisMapperImplementation<ID, PARAM, VO>,
        DTO extends BaseIdDTO<ID>,
        VO extends BaseIdVO<ID>,
        PARAM extends BasePageParam,
        DO extends BaseIdDO,
        ID extends Serializable> implements BaseServicePro<DTO, VO, PARAM, DO, ID> {

    protected J jpaRepositoryImplementation;

    protected M mybatisMapperImplementation;


    public void create(DTO dto, Class<DO> clazz) {
        var doEntity = ConverterUtil.to(dto, clazz);
        jpaRepositoryImplementation.save(doEntity);
    }

    public void create(DTO dto, DO doEntity) {
        ConverterUtil.to(dto, doEntity);
        jpaRepositoryImplementation.save(doEntity);
    }


    @Override
    public void deleteByIds(List<ID> ids) {
        jpaRepositoryImplementation.deleteAllByIdInBatch(ids);
    }



    public void updateById(DTO dto) {
        var optional = jpaRepositoryImplementation.findById(dto.getId());
        if (optional.isPresent()) {
            var doEntity = optional.get();
            ConverterUtil.to(dto, doEntity);
            jpaRepositoryImplementation.save(doEntity);
        }
    }
    public void updateById(DTO dto,DO doEntity) {
        var optional = jpaRepositoryImplementation.findById(dto.getId());
        if (optional.isPresent()) {
            var newDoEntity = optional.get();
            ConverterUtil.to(doEntity, newDoEntity);
            jpaRepositoryImplementation.save(newDoEntity);
        }
    }

    public VO readById(ID id) {
        return mybatisMapperImplementation.selectById(id);
    }

    @Override
    public Long totalByParam(PARAM param) {
        return mybatisMapperImplementation.countByParam(param);
    }

    public List<VO> readListByParam(PARAM param) {
        return mybatisMapperImplementation.selectListByParam(param);
    }


}