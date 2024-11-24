package br.com.faculdade.devmobile.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.faculdade.devmobile.model.ClinicModel;
import br.com.faculdade.devmobile.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public Page<ClinicModel> findAll(Pageable pageable) {
        return clinicRepository.findAll(pageable);
    }

    public List<ClinicModel> findAll() {
        return clinicRepository.findAll();
    }
}
