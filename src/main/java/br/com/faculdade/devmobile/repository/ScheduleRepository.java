package br.com.faculdade.devmobile.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdade.devmobile.model.ScheduleModel;

public interface ScheduleRepository extends JpaRepository<ScheduleModel, Integer> {

    Page<ScheduleModel> findByUserId(Integer id, PageRequest pageRequest);

}
