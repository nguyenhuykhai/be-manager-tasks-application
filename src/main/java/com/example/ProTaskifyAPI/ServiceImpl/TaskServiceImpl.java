package com.example.ProTaskifyAPI.ServiceImpl;

import com.example.ProTaskifyAPI.Models.Task;
import com.example.ProTaskifyAPI.Repositories.TaskRepo;
import com.example.ProTaskifyAPI.Services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void checkMissDeadline() {
        var listTasks = taskRepo.findAllMissDeadlineTasks();
        for (Task task : listTasks) {
            task.setStatus("Miss Deadline");
        }
        taskRepo.saveAll(listTasks);
    }
}
