package br.com.faculdade.devmobile.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.faculdade.devmobile.model.ScheduleModel;
import br.com.faculdade.devmobile.service.ScheduleService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("agendamentos")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<List<ScheduleModel>> fetchAll(Pageable pageable) {
        PageRequest page = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id")));
        Page<ScheduleModel> schedules = scheduleService.findAll(page);
        return ResponseEntity.ok().body(schedules.getContent());
    }

    @GetMapping("{id}")
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<ScheduleModel> fetchById(@PathVariable Integer id) {
        try {
            ScheduleModel schedules = scheduleService.findById(id);
            return ResponseEntity.ok().body(schedules);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<ScheduleModel> schedule(@RequestBody ScheduleModel body) {
        ScheduleModel newSchedule = scheduleService.createSchedule(body);
        return ResponseEntity.status(201).body(newSchedule);
    }

    @DeleteMapping("{id}")
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Id não pode ser nulo"));
        }
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok(Map.of("message", "Agendamento deletado com sucesso"));
    }

    @PutMapping("{id}")
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<ScheduleModel> update(@RequestBody ScheduleModel body) {
        ScheduleModel newSchedule = scheduleService.createSchedule(body);
        return ResponseEntity.status(201).body(newSchedule);
    }

}
