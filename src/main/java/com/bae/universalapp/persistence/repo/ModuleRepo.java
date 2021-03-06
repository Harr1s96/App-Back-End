package com.bae.universalapp.persistence.repo;

import com.bae.universalapp.persistence.domain.Module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * ModuleRepository
 */
@Repository
public interface ModuleRepo extends JpaRepository<Module, Long>, QueryByExampleExecutor<Module> {

    @Modifying
    @Transactional
    @Query(value = "delete from module", nativeQuery = true)
    void deleteModuleTable();

}