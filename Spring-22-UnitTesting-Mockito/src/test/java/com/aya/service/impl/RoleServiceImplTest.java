package com.aya.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.aya.dto.RoleDTO;
import com.aya.entity.Role;
import com.aya.mapper.MapperUtil;
import com.aya.mapper.RoleMapper;
import com.aya.repository.RoleRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RoleServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RoleServiceImplTest {
    @MockBean
    private MapperUtil mapperUtil;

    @MockBean
    private RoleMapper roleMapper;

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles() {
        when(roleRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(roleServiceImpl.listAllRoles().isEmpty());
        verify(roleRepository).findAll();
    }

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles2() {
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(123L);
        role.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setInsertUserId(123L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setLastUpdateUserId(123L);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        when(roleRepository.findAll()).thenReturn(roleList);
        when(mapperUtil.convert((Object) any(), (RoleDTO) any())).thenReturn(new RoleDTO());
        assertEquals(1, roleServiceImpl.listAllRoles().size());
        verify(roleRepository).findAll();
        verify(mapperUtil).convert((Object) any(), (RoleDTO) any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#listAllRoles()}
     */
    @Test
    void testListAllRoles3() {
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(123L);
        role.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setInsertUserId(123L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setLastUpdateUserId(123L);

        Role role1 = new Role();
        role1.setDescription("The characteristics of someone or something");
        role1.setId(123L);
        role1.setInsertDateTime(LocalDateTime.of(2, 2, 2, 2, 1));
        role1.setInsertUserId(123L);
        role1.setIsDeleted(true);
        role1.setLastUpdateDateTime(LocalDateTime.of(2, 2, 2, 2, 1));
        role1.setLastUpdateUserId(123L);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role);
        when(roleRepository.findAll()).thenReturn(roleList);
        when(mapperUtil.convert((Object) any(), (RoleDTO) any())).thenReturn(new RoleDTO());
        assertEquals(2, roleServiceImpl.listAllRoles().size());
        verify(roleRepository).findAll();
        verify(mapperUtil, atLeast(1)).convert((Object) any(), (RoleDTO) any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#findByRoleId(Long)}
     */
    @Test
    void testFindByRoleId() {
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(123L);
        role.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setInsertUserId(123L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setLastUpdateUserId(123L);
        Optional<Role> ofResult = Optional.of(role);
        when(roleRepository.findById((Long) any())).thenReturn(ofResult);
        RoleDTO roleDTO = new RoleDTO();
        when(mapperUtil.convert((Object) any(), (RoleDTO) any())).thenReturn(roleDTO);
        assertSame(roleDTO, roleServiceImpl.findByRoleId(123L));
        verify(roleRepository).findById((Long) any());
        verify(mapperUtil).convert((Object) any(), (RoleDTO) any());
    }

    /**
     * Method under test: {@link RoleServiceImpl#findByRoleId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByRoleId2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.aya.service.impl.RoleServiceImpl.findByRoleId(RoleServiceImpl.java:46)
        //   In order to prevent findByRoleId(Long)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findByRoleId(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(roleRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(mapperUtil.convert((Object) any(), (Object) any())).thenReturn("Convert");
        when(mapperUtil.convert((Object) any(), (RoleDTO) any())).thenReturn(new RoleDTO());
        roleServiceImpl.findByRoleId(123L);
    }
}

