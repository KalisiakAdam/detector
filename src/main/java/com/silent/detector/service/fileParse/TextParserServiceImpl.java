package com.silent.detector.service.fileParse;

import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.List;

@Service
public class TextParserServiceImpl implements TextParserService{

    @Override
    public boolean isReadable(InputStream inputStream) {
        return false;
    }

    @Override
    public List<String> parse(InputStream inputStream) {
        return null;
    }
}
