package com.borges.Rotininha.controller;

import com.borges.Rotininha.dto.RoutineDTO;
import com.borges.Rotininha.service.RoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/routines")
public class RoutineController {

    private RoutineService  routineService;
    public RoutineController(RoutineService routineService){
        this.routineService = routineService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoutineDTO>  getRoutineById(@PathVariable Long id){
        RoutineDTO routineDTO = routineService.getRoutineById(id);
        return ResponseEntity.ok(routineDTO);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoutineDTO createRoutine(RoutineDTO routineDTO){
       return routineService.createRoutine(routineDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoutineDTO> updateRoutine(@PathVariable Long id, @RequestBody RoutineDTO routineDTO){
        RoutineDTO updatedRoutine = routineService.updateRoutine(id, routineDTO);
        return ResponseEntity.ok(updatedRoutine);
    }


}
