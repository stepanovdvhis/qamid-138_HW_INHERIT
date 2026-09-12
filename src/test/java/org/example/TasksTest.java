package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTaskByTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        Assertions.assertTrue(task.matches("Позвонить"));
        Assertions.assertTrue(task.matches("родителям"));
        Assertions.assertFalse(task.matches("Купить"));
    }

    @Test
    public void shouldMatchEpicBySubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void shouldMatchMeetingByTopicOrProject() {
        Meeting meeting = new Meeting(
                3,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertTrue(meeting.matches("НетоБанка"));
        Assertions.assertFalse(meeting.matches("Сбербанк"));
    }
}