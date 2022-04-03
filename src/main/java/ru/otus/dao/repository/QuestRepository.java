package ru.otus.dao.repository;


import org.springframework.stereotype.Repository;
import ru.otus.dao.entity.Quest;
import ru.otus.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class QuestRepository {

    public List<Quest> getQuestionnaire(String fileName, String lineSeparator) {
        List<Quest> quests = new ArrayList<>();

        try {
            Map<Integer, List<String>> questMap = FileUtils.getCsvWithTitle(fileName, lineSeparator);

            quests = questMap.values().stream()
                    .map(parsedLine -> new Quest(parsedLine.get(0),
                            Arrays.asList(parsedLine.get(1), parsedLine.get(2), parsedLine.get(3), parsedLine.get(4)),
                            parsedLine.get(5)))
                    .collect(Collectors.toList());
        } catch (IOException ignored) {
        }

        return quests;
    }

}
