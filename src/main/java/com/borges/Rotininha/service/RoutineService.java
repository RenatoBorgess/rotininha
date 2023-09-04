package com.borges.Rotininha.service;

import com.borges.Rotininha.model.Routine;
import com.borges.Rotininha.repository.RoutineRepository;
import com.borges.Rotininha.dto.RoutineDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoutineService {

    private RoutineRepository routineRepository;
    public RoutineService(RoutineRepository routineRepository){
        this.routineRepository = routineRepository;
    }

    public RoutineDTO createRoutine(RoutineDTO routineDTO){
        Routine newRoutine = convertToEntity(routineDTO);
        Routine savedRoutine = routineRepository.save(newRoutine);
        return convertToDTO(savedRoutine);
    }
    public RoutineDTO updateRoutine(Long Id, RoutineDTO routineDTO){
        Optional<Routine> optionalRoutine = routineRepository.findById(routineDTO.Id());
        if(optionalRoutine.isPresent()){
            Routine routine = optionalRoutine.get();
            routine.setTitle(routineDTO.title());
            routine.setDescription(routineDTO.description());
            Routine updatedRoutine = routineRepository.save(routine);
            return convertToDTO(updatedRoutine);
        }else {
            throw new EntityNotFoundException("Routine not found with ID: " + routineDTO.Id());
        }
    }
    public RoutineDTO getRoutineById(Long id) {
        Optional<Routine> optionalRoutine = routineRepository.findById(id);
        if (optionalRoutine.isEmpty()) {
            throw new EntityNotFoundException("Routine not found with ID: " + id);
        } else {
            return convertToDTO(optionalRoutine.get());
        }
    }

    public void deleteRoutine(Long id) {
        Optional<Routine> optionalRoutine = routineRepository.findById(id);
        if (optionalRoutine.isPresent()) {
            routineRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Routine not found with ID: " + id);
        }
    }
    private RoutineDTO convertToDTO(Routine routine){
        return new RoutineDTO(routine.getId(), routine.getTitle(), routine.getDescription());
    }

    private Routine convertToEntity(RoutineDTO routineDTO){
        Routine newRoutine = new Routine();
        newRoutine.setTitle(newRoutine.getTitle());
        newRoutine.setDescription(newRoutine.getDescription());
        return newRoutine;
    }
}
