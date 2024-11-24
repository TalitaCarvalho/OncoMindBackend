package br.com.faculdade.devmobile.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.faculdade.devmobile.model.DoctorModel;
import br.com.faculdade.devmobile.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Page<DoctorModel> findAll(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    public List<DoctorModel> findAll() {
        return doctorRepository.findAll();
    }

}
