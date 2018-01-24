package com.sam.suitshub.Service;

import com.sam.suitshub.Dao.CastDao;
import com.sam.suitshub.Entity.CastMember;
import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashMap;

@Service
public class CastService {

    @Autowired
    private CastDao castDao;

    public CastService() {

    }

    public Collection<CastMember> findAll() {
        HashMap cast = new HashMap<Integer,CastMember>();
        for (CastMember member : castDao.findAll()) {
            cast.put(member.getId(), member);
        }

        return cast.values();
    }

    public CastMember getMemberById(Long id) {
        return castDao.findOne(id);
    }

    public void removeMemberById(Long id) {
        castDao.delete(id);
    }

    public void updateMember(CastMember member){
        if (castDao.findOne(member.getId()) == null){
            return;
        }

        castDao.save(member);
    }


    public CastMember insertMember(CastMember member) {
        CastMember cm = castDao.findOne(member.getId());

        if (cm == null) {
            return castDao.save(member);
        }
        return castDao.save(cm);
    }
}
