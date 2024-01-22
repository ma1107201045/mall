package com.lingyi.mall.common.orm.util;


import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.dto.BaseIdDTO;
import com.lingyi.mall.common.orm.entity.BaseIdDO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import com.lingyi.mall.common.core.query.BasePageQuery;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

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
    public List<ID> createList(List<DTO> dto, Class<DO> clazz) {
        var doEntityList = ConverterUtil.toList(dto, clazz);
        jpaRepository.saveAll(doEntityList);
        return doEntityList.stream().map(BaseIdDO::getId).toList();
    }

    @Override
    public List<ID> createList(List<DTO> dtoList, List<DO> doEntityList) {
        ConverterUtil.toList(dtoList, doEntityList);
        jpaRepository.saveAll(doEntityList);
        return doEntityList.stream().map(BaseIdDO::getId).toList();
    }

    @Override
    public List<ID> createList(List<DO> doEntityList) {
        jpaRepository.saveAll(doEntityList);
        return doEntityList.stream().map(BaseIdDO::getId).toList();
    }

    @Override
    public void deleteByIds(List<ID> ids) {
        jpaRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void updateById(DTO dto, Class<DO> clazz) {
        if (isExist(dto.getId())) {
            create(dto, clazz);
        }
    }

    @Override
    public void updateById(DTO dto, DO doEntity) {
        if (isExist(dto.getId())) {
            create(dto, doEntity);
        }
    }

    @Override
    public void updateById(DO doEntity) {
        if (isExist(doEntity.getId())) {
            create(doEntity);
        }
    }

    @Override
    public void updateById(DTO dto) {
        var optional = jpaRepository.findById(dto.getId());
        if (optional.isPresent()) {
            var doEntity = optional.get();
            create(dto, doEntity);
        }

    }

    @Override
    public void updateListById(List<DTO> dtoList, Class<DO> clazz) {
        var idList = dtoList.stream().map(BaseIdDTO::getId).toList();
        if (isAllExist(idList)) {
            createList(dtoList, clazz);
        }
    }

    @Override
    public void updateListById(List<DTO> dtoList, List<DO> doEntityList) {
        var idList = dtoList.stream().map(BaseIdDTO::getId).toList();
        if (isAllExist(idList)) {
            createList(dtoList, doEntityList);
        }
    }

    @Override
    public void updateListById(List<DO> doEntityList) {
        var idList = doEntityList.stream().map(BaseIdDO::getId).toList();
        if (isAllExist(idList)) {
            createList(doEntityList);
        }
    }

    @Override
    public void updateListByIdV2(List<DTO> dtoList) {
        var idList = dtoList.stream().map(BaseIdDTO::getId).toList();
        var doEntityList = jpaRepository.findAllById(idList);
        if (idList.size() == doEntityList.size()) {
            createList(dtoList, doEntityList);
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

    private boolean isExist(ID id) {
        var optional = jpaRepository.findById(id);
        return optional.isPresent();
    }

    private boolean isAllExist(List<ID> idList) {
        List<DO> doEntityList = jpaRepository.findAllById(idList);
        return idList.size() == doEntityList.size();
    }


}