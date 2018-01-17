package com.sam.suitshub.Dao;

import com.sam.suitshub.Entity.CastMember;
import javassist.expr.Cast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface CastDao extends CrudRepository<CastMember, Long> {
    List<CastMember> findByName(String name);
    CastMember findOne(Long id); //  /find/{id}
    Collection<CastMember> findAll(); // /cast
    void delete(CastMember castMember); // /remove/{id}
    CastMember save(CastMember castMember);//  /insert/
}
