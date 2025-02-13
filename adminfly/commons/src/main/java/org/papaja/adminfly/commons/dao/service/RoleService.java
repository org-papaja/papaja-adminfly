package org.papaja.adminfly.commons.dao.service;

import org.papaja.adminfly.commons.pojo.RoleDto;
import org.papaja.adminfly.commons.dao.entity.Role;
import org.papaja.adminfly.commons.dao.mapper.RoleMapper;
import org.papaja.adminfly.commons.dao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService extends AbstractService<Role, RoleRepository> {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PrivilegeService privileges;

    @Autowired
    private RoleMapper mapper;

    public List<Role> getRoles() {
        return getAll();
    }

    public List<Role> getRoles(List<Integer> ids) {
        return getAll(ids);
    }

    public void store(RoleDto dto, Role entity) {
        mapper.map(dto, entity);

        if (entity.isOld()) {
            entity.setPrivileges(privileges.getPrivileges(dto.getPrivileges()));
        }

        repository.merge(entity);
    }

    public Role getRole(Integer id) {
        return getOne(id);
    }

    @Override
    public RoleRepository getRepository() {
        return repository;
    }

    @Override
    public Role get() {
        return new Role();
    }

}
