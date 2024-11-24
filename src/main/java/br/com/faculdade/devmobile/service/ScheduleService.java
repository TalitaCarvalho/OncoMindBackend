package br.com.faculdade.devmobile.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.faculdade.devmobile.model.ScheduleModel;
import br.com.faculdade.devmobile.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Page<ScheduleModel> findAll(Pageable pageable) {
        return scheduleRepository.findAll(pageable);
    }

    public ScheduleModel findById(Integer id) {
        Optional<ScheduleModel> schedule = scheduleRepository.findById(id);
        return schedule.orElseThrow();
    }

    public Page<ScheduleModel> findByUserId(Integer id, PageRequest pageable) {
        return scheduleRepository.findByUserId(id, pageable);
    }

    public ScheduleModel createSchedule(ScheduleModel schedule) {
        return scheduleRepository.save(schedule);
    }

    public boolean deleteSchedule(Integer id) {
        try {
            scheduleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
