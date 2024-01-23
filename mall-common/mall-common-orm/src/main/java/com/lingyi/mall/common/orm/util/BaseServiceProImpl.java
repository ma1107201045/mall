package com.lingyi.mall.common.orm.util;


import com.lingyi.mall.common.core.dto.BaseIdDTO;
import com.lingyi.mall.common.core.query.BasePageQuery;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import com.lingyi.mall.common.orm.entity.BaseIdDO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.util.Collections;
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
    public List<ID> createList(List<DTO> dto, Class<DO> clazz) {
        var doEntityList = ConverterUtil.toList(dto, clazz);
        jpaRepository.saveAll(doEntityList);
        return getIdListByList(doEntityList);
    }

    @Override
    public List<ID> createList(List<DTO> dtoList, List<DO> doEntityList) {
        ConverterUtil.toList(dtoList, doEntityList);
        jpaRepository.saveAll(doEntityList);
        return getIdListByList(doEntityList);
    }

    @Override
    public List<ID> createList(List<DO> doEntityList) {
        jpaRepository.saveAll(doEntityList);
        return getIdListByList(doEntityList);
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
    public ID updateById(DTO dto, Class<DO> clazz) {
        if (isExist(dto.getId())) {
            return create(dto, clazz);
        }
        return ObjectUtil.getNull();
    }

    @Override
    public ID updateById(DTO dto, DO doEntity) {
        if (isExist(dto.getId())) {
            return create(dto, doEntity);
        }
        return ObjectUtil.getNull();
    }

    @Override
    public ID updateById(DO doEntity) {
        if (isExist(doEntity.getId())) {
            return create(doEntity);
        }
        return ObjectUtil.getNull();
    }

    @Override
    public ID updateById(DTO dto) {
        var optional = jpaRepository.findById(dto.getId());
        if (optional.isPresent()) {
            var doEntity = optional.get();
            return create(dto, doEntity);
        }
        return ObjectUtil.getNull();
    }

    @Override
    public List<ID> updateListById(List<DTO> dtoList, Class<DO> clazz) {
        var idList = getIdListByList(dtoList);
        if (isAllExist(idList)) {
            return createList(dtoList, clazz);
        }
        return Collections.emptyList();
    }

    @Override
    public List<ID> updateListById(List<DTO> dtoList, List<DO> doEntityList) {
        var idList = getIdListByList(dtoList);
        if (isAllExist(idList)) {
            return createList(dtoList, doEntityList);
        }
        return Collections.emptyList();
    }

    @Override
    public List<ID> updateListById(List<DO> doEntityList) {
        var idList = getIdListByList(doEntityList);
        if (isAllExist(idList)) {
            return createList(doEntityList);
        }
        return Collections.emptyList();
    }

    @Override
    public List<ID> updateListByIdV2(List<DTO> dtoList) {
        var idList = getIdListByList(dtoList);
        var doEntityList = jpaRepository.findAllById(idList);
        if (idList.size() == doEntityList.size()) {
            return createList(dtoList, doEntityList);
        }
        return Collections.emptyList();
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
        var doEntityList = jpaRepository.findAllById(idList);
        return idList.size() == doEntityList.size();
    }

    private List<ID> getIdListByDoEntityList(List<DO> doEntityList) {
        return doEntityList.stream().map(BaseIdDO::getId).toList();
    }

    private List<ID> getIdListByDTOList(List<DTO> dtoList) {
        return dtoList.stream().map(BaseIdDTO::getId).toList();
    }

    private List<ID> getIdListByList(List<?> list) {
        return list.stream().map(base -> {
            if (base instanceof BaseIdDTO<?> baseIdDTO) {
                return (ID) baseIdDTO.getId();
            }
            if (base instanceof BaseIdDO<?> baseIdDO) {
                return (ID) baseIdDO.getId();
            }
            return null;
        }).toList();
    }
}