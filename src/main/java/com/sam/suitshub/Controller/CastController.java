package com.sam.suitshub.Controller;

import com.sam.suitshub.Entity.CastMember;
import com.sam.suitshub.Service.CastService;
import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cast")
public class CastController {

    @Autowired
    private CastService castService;

    @RequestMapping( method = RequestMethod.GET)
    public Collection<CastMember> getCast() {
        return castService.findAll();
    }

    @RequestMapping( value = "/find/{id}", method = RequestMethod.GET)
    public CastMember getMemberById(@PathVariable("id") Long id) {
        return castService.getMemberById(id);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") Long id ){
        castService.removeMemberById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCastMember(@RequestBody CastMember castMember ){
        castService.updateMember(castMember);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CastMember insertMember(@RequestBody CastMember castMember) {
        return castService.insertMember(castMember);
    }


}
