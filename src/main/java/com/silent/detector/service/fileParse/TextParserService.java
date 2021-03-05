package com.silent.detector.service.fileParse;

import java.io.InputStream;
import java.util.List;

public interface TextParserService {
    boolean isReadable(InputStream inputStream);
    List<String> parse(InputStream inputStream);
}
