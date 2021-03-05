package com.silent.detector.service.fileParse;

import java.util.List;

public interface TextParserService {
    List<String> parseTextByLinesToListAsLowerCase(String fileName);
}
