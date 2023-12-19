package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.Models.*;
import com.example.ProTaskifyAPI.Models.Process;
import com.example.ProTaskifyAPI.Repositories.*;
import com.example.ProTaskifyAPI.Services.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final ProcessRepo processRepo;
    private final ProjectRepo projectRepo;
    private final SprintRepo sprintRepo;
    private final FeatureRepo featureRepo;

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void checkMissDeadline() {
        var listTasks = taskRepo.findAllMissDeadlineTasks();
        var listSprint = sprintRepo.findAllMissDeadlineSprints();
        for (Task task : listTasks) {
            task.setStatus("Miss Deadline");
        }
        for (Sprint sprint : listSprint) {
            sprint.setStatus("Miss Deadline");
        }
        for (Task task : listTasks) {
            var process = processRepo.findProcessByFeature(featureRepo.findById(task.getFeature().getFeature_id()).orElse(null));
            var processList = processRepo.findProcessesByProject(projectRepo.findById(process.get(process.size() - 1).getId().getProject()).orElse(null));
            for (int i = 0; i < processList.size(); i++) {
                if(process.get(process.size() - 1).getId().getSprint() < processList.get(i).getId().getSprint()) {
                    Process newProcess = Process.builder()
                            .id(ProcessCompositeKey.builder()
                                    .sprint(processList.get(i).getId().getSprint())
                                    .feature(process.get(process.size() - 1).getId().getFeature())
                                    .project(process.get(process.size() - 1).getId().getProject())
                                    .build())
                            .sprint(processList.get(i).getSprint())
                            .feature(process.get(process.size() - 1).getFeature())
                            .project(process.get(process.size() - 1).getProject())
                            .build();
                    processRepo.save(newProcess);
                    break;
                }
            }
        }

        sprintRepo.saveAll(listSprint);
        taskRepo.saveAll(listTasks);
    }
}
