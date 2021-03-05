package com.silent.detector.service.fileParse;

import com.silent.detector.exception.DetectorRuntimeException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TextParserServiceImpl implements TextParserService{

    @Override
    public List<String> parseTextByLinesToListAsLowerCase(String fileName) {
       return parseTextByLinesToListOriginal(fileName).stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> parseTextByLinesToListOriginal(String fileName) {
        List<String> data = new ArrayList<>();
        try {
            Path path = Paths.get("src/main/resources/files/" + fileName);
            Stream<String> lines = Files.lines(path);
            data = lines.collect(Collectors.toList());
            lines.close();
        } catch (IOException ioException) {
            textParsingException(ioException);
        }
        return data;
    }

    private void textParsingException(IOException ioException) {
        throw new DetectorRuntimeException("IO exception while text parsing", ioException);
    }
}
