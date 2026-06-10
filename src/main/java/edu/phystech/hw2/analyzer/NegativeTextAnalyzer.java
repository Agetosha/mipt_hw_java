package edu.phystech.hw2.analyzer;

import java.util.Collection;
import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private final List<String> keywords = List.of(":(", "=(", ":|");

    @Override
    protected Collection<String> getKeywords() { 
        return keywords; 
    }

    @Override
    protected Label getLabel() { 
        return Label.NEGATIVE; 
    }
}