package com.hqm.smartbin.controllers;

import com.hqm.smartbin.models.Bin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/bin")
public class BinController {

    EntityManager em = Persistence.createEntityManagerFactory("bin-unit").createEntityManager();
    EntityTransaction et = em.getTransaction();

    @GetMapping(value = "")
    public String index(Model model){
        List<Bin> bin = em.createNamedQuery("BinFindAll").getResultList();
        model.addAttribute("bins", bin);

        return "bin";
    }

    @GetMapping(value = "/new")
    public String baru(Model model){
        Bin bin = new Bin();

        model.addAttribute("bin", bin);
        model.addAttribute("action", "new");

        return "bin-form" ;
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView save(Bin bin){
        et.begin();
        em.persist(bin);
        et.commit();

        return new RedirectView("/bin");
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable UUID id, Model model){
        Bin bin = em.find(Bin.class, id);
        model.addAttribute("bin", bin);
        model.addAttribute("action", "edit");

        return  "bin-form";
    }

    @GetMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable UUID id){
        Bin bin = em.find(Bin.class, id);

        et.begin();
        em.remove(bin);
        et.commit();

        return new RedirectView("/bin");
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView update(Bin bin){
        Bin _bin = em.find(Bin.class, bin.getId());

        et.begin();
        _bin.setLatitude(bin.getLatitude());
        _bin.setLongitude(bin.getLongitude());
        _bin.setDescription(bin.getDescription());
        et.commit();
        return new RedirectView("/bin");

    }
}
