package br.com.faculdade.devmobile.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.faculdade.devmobile.model.ClinicModel;
import br.com.faculdade.devmobile.service.ClinicService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("clinicas")
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<List<ClinicModel>> fetchAll(Pageable pageable) {
        if (pageable == null) {
            List<ClinicModel> clinics = clinicService.findAll();
            return ResponseEntity.ok().body(clinics);
        }
        PageRequest page = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "name")));
        Page<ClinicModel> clinics = clinicService.findAll(page);
        return ResponseEntity.ok().body(clinics.getContent());
    }

}
