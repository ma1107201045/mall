package com.lingyi.mall.common.orm.util;


import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.dto.BaseIdDTO;
import com.lingyi.mall.common.orm.entity.BaseIdDO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import com.lingyi.mall.common.core.query.BasePageQuery;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/9 9:51
 * @Description:
 */
public class BaseServiceProImpl<
        J extends JpaRepositoryImplementation<DO, ID>,
        M extends MybatisMapperImplementation<VO, QUERY, ID>,
        DTO extends BaseIdDTO<ID>,
        VO extends BaseIdVO<ID>,
        QUERY extends BasePageQuery,
        DO extends BaseIdDO<ID>,
        ID extends Serializable> implements BaseServicePro<DTO, VO, QUERY, DO, ID> {

    @Autowired
    protected J jpaRepository;

    @Autowired
    protected M mybatisMapper;

    @Override
    public ID create(DTO dto, Class<DO> clazz) {
        var doEntity = ConverterUtil.to(dto, clazz);
        jpaRepository.save(doEntity);
        return doEntity.getId();
    }
    @Override
    public ID create(DTO dto, DO doEntity) {
        ConverterUtil.to(dto, doEntity);
        jpaRepository.save(doEntity);
        return doEntity.getId();
    }

    @Override
    public ID create(DO doEntity) {
        jpaRepository.save(doEntity);
        return doEntity.getId();
    }


    @Override
    public void deleteByIds(List<ID> ids) {
        jpaRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void updateById(DTO dto) {
        var optional = jpaRepository.findById(dto.getId());
        if (optional.isPresent()) {
            var doEntity = optional.get();
            ConverterUtil.to(dto, doEntity);
            jpaRepository.save(doEntity);
        }
    }

    @Override
    public void updateById(DO doEntity) {
        var optional = jpaRepository.findById(doEntity.getId());
        if (optional.isPresent()) {
            var newDoEntity = optional.get();
            ConverterUtil.to(doEntity, newDoEntity);
            jpaRepository.save(newDoEntity);
        }
    }
    @Override
    public VO readById(ID id) {
        return mybatisMapper.selectById(id);
    }

    @Override
    public Long totalByParam(QUERY query) {
        return mybatisMapper.countByParam(query);
    }
    @Override
    public List<VO> readListByParam(QUERY query) {
        return mybatisMapper.selectListByParam(query);
    }


}